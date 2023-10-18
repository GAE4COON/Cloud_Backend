package com.gae4coon.cloudmaestro.domain.rehost.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;


import com.gae4coon.cloudmaestro.domain.rehost.dto.GroupData;
import com.gae4coon.cloudmaestro.domain.rehost.dto.LinkData;
import com.gae4coon.cloudmaestro.domain.rehost.dto.NodeData;
import com.gae4coon.cloudmaestro.domain.rehost.service.AlgorithmServiceInterface;


import org.apache.commons.collections4.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.*;

import java.util.List;

@Service
public class AlgorithmServiceImpl implements AlgorithmServiceInterface {


    // 방화벽 밑에 1단을 기준으로 security group을 묶는다.

    private static final Logger logger = LoggerFactory.getLogger(AlgorithmServiceImpl.class);

    @Override
    public Map<String, Object> algorithmDataList(Map<String, Object> nodesData, List<LinkData> linkData) {


        // 1. security group으로 묶기
        // nodeData로 캐스팅하기
        ObjectMapper mapper = new ObjectMapper();
        Object rawNodeData = nodesData.get("nodeDataArray");
        Map<String, Object> result = new HashMap<>();


        List<Object> nodeDataList = null;
        if (rawNodeData instanceof List) {
            nodeDataList = (List<Object>) rawNodeData;
        } else {
            logger.error("Unexpected type for nodeDataArray. Expected List but got: {}", rawNodeData.getClass().getName());
            return Collections.emptyMap();
        }


        logger.info("nodeDataList2: {}", nodeDataList);


        //어떤 그룹을 security group 묶을 건지
        Map<String, List<LinkData>> groupedByFrom = new HashMap<>();

        // 일단은 from 키를 묶어서 해결 -> 여기까지는 잘 들어가는 걸 확인
        for (LinkData link : linkData) {
            String fromKey = link.getFrom();
            groupedByFrom.putIfAbsent(fromKey, new ArrayList<>());
            groupedByFrom.get(fromKey).add(link);

        }

        // Security group 찾기 ( waf/ fw -> svr/ was ) 찾아서 security group으로 묶기
        // 일단 group을 null 이라고 해서 전체 데이터가 들어오게 하는 건 성공
        int index = 0;
        List<LinkData> addGroupList = new ArrayList<>();
        for (String key : groupedByFrom.keySet()) {
            if (key.contains("FW") || key.contains("WAF")) {
                List<LinkData> modifiedLinks = addGroup(groupedByFrom.get(key), index);
                addGroupList.addAll(modifiedLinks);
                index += 1;
            } else {
                addGroupList.addAll(groupedByFrom.get(key));
            }

        }


        // Step2 : linkDataArray를 순회하면서 해당 LinkData를 NodeData에 연결
        //addGroupList (즉, LinkData 리스트)의 각 항목마다 to 필드 값을 확인
        //해당 to 값이 nodesData (즉, NodeData 리스트)의 어떤 항목의 key 값과 일치하는 지 확인
        //만약 일치한다면, 해당 NodeData 항목의 group 값을 LinkData의 group 값으로 변경

        // NodesData - securityGroup도 여기서 묶자
        List<Object> nodesToAdd = new ArrayList<>();
        for (Object obj : nodeDataList) {
            if (obj instanceof NodeData) {
                NodeData fixGroupData = (NodeData) obj;
                for (LinkData linkdata : addGroupList) {
                    if (fixGroupData.getKey().equals(linkdata.getTo())
                            && linkdata.getGroup() != null) {
                        GroupData groupNode = new GroupData();
                        groupNode.setIsGroup(true);
                        groupNode.setKey(linkdata.getGroup());
                        groupNode.setStroke("rgba(255,165,0,0.3)");
                        groupNode.setType("group");
                        groupNode.setGroup(fixGroupData.getGroup());
                        boolean nodeExistsInToAddList = nodesToAdd.stream()
                                .filter(n -> n instanceof GroupData)
                                .map(n -> (GroupData) n)
                                .anyMatch(existingNode -> existingNode.getKey().equals(groupNode.getKey()));
                        if (!nodeExistsInToAddList) {
                            nodesToAdd.add(groupNode);
                        }
                        fixGroupData.setGroup(linkdata.getGroup());

                        break;

                    }
                }
            } else {
                // Error handling: obj is not an instance of NodeData
                logger.error("Unexpected object type in nodeDataList: {}", obj.getClass().getName());
            }
        }

        nodeDataList.addAll(nodesToAdd);


        // 이제부터는 새로운 알고리즘 시작 ..하하 ( 연결고리 정보 건들기 )
        // 2. linkDataArray 정보를 활용해서 연결 고리 정보를 확인합시다

        // ips / ids 는 따로 아이콘으로 빼기
        //  fw / network_waf는 빼야 한다.

        // currentlist.to = nextlist.from 이 같은 거 연결
        List<LinkData> addLogicList = generateLinksFromToWS(addGroupList);

        // 추가 로직 하기
        // from : AD3 -> to : Network_WAF / from : Network_WAF -> to : else 인거 AD3->else1, else2, .. 묶기
        List<LinkData> modifiedLinkDataList = addLogic(addLogicList);

        List<Object> modifiedNodeList = addNodeLogic(nodeDataList);

        // 같은 링크 중복 제거하기
        List<LinkData> unique = unique(modifiedLinkDataList);


        // svr/sv->ec2, database -> rds
        Map<String,Object> awsKey = fixKey(modifiedNodeList, unique);





        result.put("nodeDataArray", awsKey.get("nodeDataArray") );
        result.put("linkDataArray", awsKey.get("linkDataArray"));
        result.put("addGroupList", nodeDataList);

        return result;
    }


    @Override
    // security group으로 무엇을 묶을 것인지 결정을 한다.
    // 일단 group을 null 이라고 해서 이렇게 값이 들어오게 하는건 성공
    public List<LinkData> addGroup(List<LinkData> linkData, int index) {
        for (LinkData data : linkData) {
            if (data.getTo().toLowerCase().startsWith("ws") || data.getTo().toLowerCase().startsWith("svr")) {
                data.setGroup("SecurityGroup" + index);
            }
        }
        return linkData;  // 이제 linkData는 수정된 리스트입니다.
    }


    @Override
    public List<LinkData> generateLinksFromToWS(List<LinkData> originalList) {
        List<LinkData> resultList = new ArrayList<>();
        int index = 0;
        for (LinkData linkData : originalList) {

            String from = linkData.getFrom();
            String to = linkData.getTo();
            String nextFrom = to;

            // While the 'to' doesn't start with "WS", we try to find the next link
            while (!to.startsWith("WS") || !to.startsWith("SVR") || !to.startsWith("RDS")) {
                boolean linkFound = false;

                for (LinkData nextLink : originalList) {
                    if (nextLink.getFrom().equals(to)) {
                        to = nextLink.getTo(); // nextlink 다음으로 가기
                        nextFrom = nextLink.getFrom(); // nextlink 처음으로 가기
                        linkFound = true;
                        break;
                    }
                }

                // If we don't find a link, we exit the loop
                if (!linkFound) break;
            }

            // At this point, 'to' should be the end of the chain or a "WS" node
            resultList.add(new LinkData(from, nextFrom, index -= 1));
        }


        return resultList;
    }

    @Override
    public List<LinkData> addLogic(List<LinkData> originalList) {
        List<LinkData> resultList = new ArrayList<>();
        int index = 0;
        for(LinkData original : originalList) {
            String from = original.getFrom();
            String to = original.getTo();

            if(from.startsWith("AD") || from.startsWith("WS") ||  from.startsWith("SVR")){
                while(!to.startsWith("WS") || !to.startsWith("SVR")){
                    boolean linkFound = false;
                    for(LinkData nextLink : originalList){
                        if(nextLink.getFrom().equals(to)){
                            resultList.add(new LinkData(from, nextLink.getTo(), index -= 1));
                        }
                    }
                    if(!linkFound){
                        break;
                    }
                }
            }

        }

        return resultList;
    }


    @Override
    public List<Object> addNodeLogic(List<Object> nodeDataList){

        List<Object> NewNodeDataList = new ArrayList<>();
        for(Object data: nodeDataList){
            if (data instanceof NodeData) {
                NodeData nodedata = (NodeData) data;
                String key = nodedata.getKey();
                if (!key.startsWith("Network") && !key.startsWith("FW") && !key.startsWith("WAF")) {
                    NewNodeDataList.add(nodedata);
                }
            }
            if(data instanceof GroupData){

                NewNodeDataList.add(data);

            }


        }

        return NewNodeDataList;
    }


    public List<LinkData> unique(List<LinkData> modifiedLinkDataList){

        Set<List<String>> set = new HashSet<>();
        Map<String,LinkData> temp = new HashMap<>();
        List<List> templist = new ArrayList<>();

        List<LinkData> uniquelink = new ArrayList<>();
        for(LinkData linkdata : modifiedLinkDataList){
            List<String> list = new LinkedList<>();
            list.add(linkdata.getFrom());
            list.add(linkdata.getTo());
            templist.add(list);
        }

        for(List tempdata: templist){
            set.add(tempdata);
        }
        int i = 0;
        for(List<String> data : set){
            uniquelink.add(new LinkData(data.get(0), data.get(1), i-=1));

        }

        return uniquelink;

    }

    public Map<String,Object> fixKey(List<Object> modifiedNodeList, List<LinkData> unique) {
        Map<String, Object> fixkey = new HashMap<>();
        Map<String, String> Awsnode = new HashedMap<>();
        int EC2_index = 0;
        int RDS_index = 0;
        int Shield_index = 0;
        int Rds_index = 0;

        for(Object node : modifiedNodeList) {

            if(node instanceof NodeData){
                NodeData nodedata = (NodeData) node;
                String key = nodedata.getKey();
                if(key.contains("database")){
                    if(Awsnode.containsKey(key)){
                        nodedata.setKey(Awsnode.get(key));
                    }else{
                        nodedata.setKey("RDS" + RDS_index);
                        RDS_index += 1;
                        Awsnode.put(key,nodedata.getKey());

                    }

                }
                if(key.contains("WS")){
                    if(Awsnode.containsKey(key)){
                        nodedata.setKey(Awsnode.get(key));
                    }else{
                        nodedata.setKey("EC2" + EC2_index);
                        EC2_index += 1;
                        Awsnode.put(key,nodedata.getKey());

                    }
                }
                if(key.contains("SVR")){
                    if(Awsnode.containsKey(key)){
                        nodedata.setKey(Awsnode.get(key));
                    }else{
                        nodedata.setKey("EC2" + EC2_index);
                        EC2_index += 1;
                        Awsnode.put(key,nodedata.getKey());

                    }
                }
                if(key.contains("AD")){
                    if(Awsnode.containsKey(key)){
                        nodedata.setKey(Awsnode.get(key));
                    }else{
                        nodedata.setKey("Shield" + Shield_index);
                        Shield_index += 1;
                        Awsnode.put(key,nodedata.getKey());

                    }
                }
                if(key.contains("DB")){
                    if(Awsnode.containsKey(key)){
                        nodedata.setKey(Awsnode.get(key));
                    }else{
                        nodedata.setKey("RDS" + Rds_index);
                        Rds_index += 1;
                        Awsnode.put(key,nodedata.getKey());

                    }
                }
            }

        }

        logger.info("nodeDataList444: {}", modifiedNodeList);

        for(LinkData link : unique){
            if(Awsnode.containsKey(link.getFrom())){
                link.setFrom(Awsnode.get(link.getFrom()));
            }
            if(Awsnode.containsKey(link.getTo())){
                link.setTo(Awsnode.get(link.getTo()));
            }

        }

        fixkey.put("linkDataArray",unique);
        fixkey.put("nodeDataArray",modifiedNodeList);

        return fixkey;
    }
}









