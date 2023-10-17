package com.gae4coon.cloudmaestro.domain.rehost.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;


import com.gae4coon.cloudmaestro.domain.rehost.dto.GroupData;
import com.gae4coon.cloudmaestro.domain.rehost.dto.LinkData;
import com.gae4coon.cloudmaestro.domain.rehost.dto.NodeData;
import com.gae4coon.cloudmaestro.domain.rehost.service.AlgorithmServiceInterface;


import io.swagger.v3.oas.models.links.Link;
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


        // nodeDataList와 linkedList Vpc 묶기

        List<LinkData> vpcLinkData = vpcLink(nodeDataList, linkData);
        System.out.println("VPCLinkDAta0"+vpcLinkData);

        //어떤 그룹을 security group 묶을 건지
        Map<String, List<LinkData>> groupedByFrom = new HashMap<>();

        // 일단은 from 키를 묶어서 해결 -> 여기까지는 잘 들어가는 걸 확인
        for (LinkData link : vpcLinkData) {
            String fromKey = link.getFrom();
            groupedByFrom.putIfAbsent(fromKey, new ArrayList<>());
            // groupedByFrom에 From key에 해당하는 key 값이 있으면 연결
            if(link.getFrom().equals(fromKey)){
                groupedByFrom.get(fromKey).add(link);
            }
        }

        System.out.println("groupedByFrom"+groupedByFrom);

        // Security group 찾기 ( waf/ fw -> svr/ was ) 찾아서 security group으로 묶기
        // 일단 group을 null 이라고 해서 전체 데이터가 들어오게 하는 건 성공
        int index = 0;
        List<LinkData> addGroupList = new ArrayList<>();
        for (String key : groupedByFrom.keySet()) {
            if (key.contains("FW")) {
                List<LinkData> modifiedLinks = addGroup(groupedByFrom.get(key), index);
                addGroupList.addAll(modifiedLinks);
                index += 1;
            } else {
                addGroupList.addAll(groupedByFrom.get(key));
            }

        }

        System.out.println("ADDGROUPLISTLISt"+addGroupList);


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

                        // security group 생생
                        GroupData groupNode = new GroupData();
                        groupNode.setIsGroup(true);
                        groupNode.setKey(linkdata.getGroup());
                        groupNode.setStroke("rgb(221,52,76)");
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


       System.out.println("addGroupList"+addGroupList);

        // addGroupList를 vpc 별로 묶기
        // 이를 generateLinksFromToWS2 에 넣어서 돌려보기

        //일단은 from 키를 묶어서 해결 -> 여기까지는 잘 들어가는 걸 확인

        Map<String, List<LinkData>> groupedByVpc = new HashMap<>();

        for (LinkData link : addGroupList) {
            String vpcKey = link.getVpcgroup();
            groupedByVpc.putIfAbsent(vpcKey, new ArrayList<>());
            // groupedByFrom에 From key에 해당하는 key 값이 있으면 연결
            if(link.getVpcgroup().equals(vpcKey)){
                groupedByVpc.get(vpcKey).add(link);
            }
        }
        System.out.println("keySet: " + groupedByVpc.keySet());
        List<LinkData> entireLogicList = new ArrayList<>();

        for (Map.Entry<String, List<LinkData>> entry : groupedByVpc.entrySet()) {

            System.out.println("entry"+entry);
            List<LinkData> addLogicList = generateLinksFromToWS2(entry.getValue());
            System.out.println("addloglcList" + addLogicList);
            entireLogicList.addAll(addLogicList);
        }




        List<LinkData> addLogicList = generateLinksFromToWS2(addGroupList);
         //방화벽 전까지 linked list 돌리기

        //
        //List<LinkData> addLogicList = generateLinksFromToWS3(addGroupList);


        //System.out.println("addLogicList"+entireLogicList);


        // 추가 로직 하기
        // from : AD3 -> to : Network_WAF / from : Network_WAF -> to : else 인거 AD3->else1, else2, .. 묶기

//        List<LinkData> modifiedLinkDataList = addLogic(addLogicList);
//        System.out.println("modifiedLinkDataList"+modifiedLinkDataList);

        //List<Object> modifiedNodeList = addNodeLogic(nodeDataList);
        //System.out.println("modifiedNodeList"+ modifiedNodeList);

        // 같은 링크 중복 제거하기
        List<LinkData> unique = unique(entireLogicList);

        List<LinkData> modifiedLinkDataList = addLogic(unique);

        System.out.println("unique"+unique);


        // svr/sv->ec2, database -> rds
        //sMap<String,Object> awsKey = fixKey(modifiedNodeList, unique);

        //result.put("nodeDataArray", awsKey.get("nodeDataArray") );
        //result.put("linkDataArray", awsKey.get("linkDataArray"));
        result.put("nodeDataArray",  nodeDataList);
        result.put("linkDataArray", unique);
        //result.put("linkDataArray", nodeDataList);
        System.out.println("result"+result);
        return result;
    }



    // security group으로 무엇을 묶을 것인지 결정을 한다.
    // 일단 group을 null 이라고 해서 이렇게 값이 들어오게 하는건 성공
    // security group과 vpc group을 같이 묶어보자

    // security group으로 무엇을 묶을 것인지 결정을 한다.
    // 일단 group을 null 이라고 해서 이렇게 값이 들어오게 하는건 성공
    public List<LinkData> addGroup(List<LinkData> linkData, int index) {
        System.out.println("LinkData"+linkData);
        for (LinkData data : linkData) {
            System.out.println("data: " + data);

            if (data.getTo().toLowerCase().startsWith("ws") || data.getTo().toLowerCase().startsWith("svr") || data.getTo().toLowerCase().startsWith("db")) {
                data.setGroup("SecurityGroup" + index);
            }
        }
        return linkData;  // 이제 linkData는 수정된 리스트입니다.
    }


    public List<LinkData> vpcLink(List<Object>nodeDataList, List<LinkData>linkData){

        List<LinkData> vpcLinkData = new ArrayList<>();
        for(Object node : nodeDataList){
            for (LinkData link : linkData) {
                String from = link.getFrom();
                String to = link.getTo();
                int key = link.getKey();
                if(node instanceof NodeData){
                    if (link.getFrom().equals(((NodeData) node).getKey())) {
                        LinkData newLink = new LinkData(link.getFrom(), link.getTo(),((NodeData) node).getGroup(),link.getKey() );
                        vpcLinkData.add(newLink);
                    }
                    if (link.getTo().equals(((NodeData) node).getKey())) {
                        LinkData newLink = new LinkData(link.getFrom(), link.getTo(),((NodeData) node).getGroup(),link.getKey() );
                        vpcLinkData.add(newLink);
                    }
                }
            }


        }
        System.out.println("vpcLink"+vpcLinkData);
        return vpcLinkData;

    }




    @Override
    public List<LinkData> generateLinksFromToWS(List<LinkData> originalList) {
        List<LinkData> resultList = new ArrayList<>();
        int index = 0;
        for (LinkData linkData : originalList) {

            String from = linkData.getFrom();
            String to = linkData.getTo();
            String vpcGroup = linkData.getVpcgroup();
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

                if (!linkFound) break;
            }
            System.out.println("new LinkData(from, nextFrom, index -= 1)"+ new LinkData(from, nextFrom, vpcGroup,index -= 1));
            resultList.add(new LinkData(from, nextFrom, vpcGroup,index -= 1));
        }


        return resultList;
    }

    public List<LinkData> generateLinksFromToWS2(List<LinkData> originalList) {
        List<LinkData> resultList = new ArrayList<>();
        System.out.println("originalList222" + originalList);
        int index = 0;
        for (LinkData linkData : originalList) {

            String from = linkData.getFrom();
            String to = linkData.getTo();
            String nextTo=null;


            if (!to.startsWith("WS") || !to.startsWith("SVR") || !to.startsWith("RDS")) {
                for (LinkData nextLink : originalList) {
                    if(nextLink==linkData) {
                        //resultList.add(nextLink);
                        continue;
                    }
                    // 그룹간의 연결

                        if(linkData.getTo().equals(nextLink.getFrom())){

                            //
                            if((linkData.getGroup() != null )&&(nextLink.getGroup() !=null)){

                                resultList.add(new LinkData(linkData.getGroup(), nextLink.getGroup(), index-= 1));
                                break;
                            }

                            // waf-> db -> ips
                            if((linkData.getGroup() == null )&&(nextLink.getGroup() ==null)){

                                from = linkData.getFrom();
                                nextTo = nextLink.getTo();
                                resultList.add(linkData);
                                break;
                            }
                            // ips -> fw -> svr
                            if((linkData.getGroup() == null )&&(nextLink.getGroup() !=null)){

                                resultList.add(new LinkData(linkData.getFrom(), nextLink.getGroup(), index-= 1));
                                break;
                            }

                            // fw -> svr -> fw2 -> svr2

                            if((linkData.getGroup() != null )&&(nextLink.getGroup() !=null)){

                                resultList.add(new LinkData(linkData.getGroup(), nextLink.getGroup(), index-= 1));
                                break;
                            }

                            //




//                            if(linkData.getGroup()!=null){
//                                from = linkData.getGroup();
//
//                                // 방화벽 -> 노드 :
//                                if(linkData.getTo().contains("FW") && nextLink.getGroup() == null){
//                                    resultList.add(new LinkData(linkData.getGroup(), nextLink.getFrom(), index-= 1));
//                                    break;
//                                }
//
//                                // 방화벽 -> 노드 : 그룹 -> 노드 연결
//                                if(linkData.getFrom().contains("FW") && nextLink.getGroup() == null){
//                                    resultList.add(new LinkData(linkData.getGroup(), nextLink.getTo(), index-= 1));
//                                    break;
//                                }
//
//                                // 그룹 - 그룹이 같은 연결 x : 그룹간의 연결
//                                if(!(linkData.getGroup().equals(nextLink.getGroup()))&& (nextLink.getGroup()!=null)){
//                                    nextTo = nextLink.getGroup();
//                                    resultList.add(new LinkData(from, nextTo, index-= 1));
//                                    break;
//                                }
//
//
//                                // 그룹 - 노드 연결
//                                if(!(linkData.getGroup().equals(nextLink.getGroup()))&& (nextLink.getGroup() ==null)){
//                                    nextTo = nextLink.getTo();
//                                    resultList.add(new LinkData(from, nextTo, index-= 1));
//                                    break;
//                                }
//
//                        }


                    }




                }
            }
        }

        System.out.println("resultList" + resultList);


        return resultList;
    }


    public List<LinkData> generateLinksFromToWS3(List<LinkData> originalList) {
        System.out.println("기존의 linkedlist"+ originalList);
        List<LinkData> resultList = new ArrayList<>();
        int index = 0;


        // from -> to 를 각 노드와 그룹으로 연결 ( 그룹 x : 노드 -> 노드 , 그룹 0 : 그룹 -> 노드 or 노드 -> 그룹 , 그룹 -> 그룹 )
        for (LinkData linkData : originalList) {

            String from = linkData.getFrom();
            String to = linkData.getTo();
            String vpcGroup = linkData.getVpcgroup();
            String nextTo=null;

            if (!to.startsWith("WS") && !to.startsWith("SVR") && !to.startsWith("RDS")) {
                for (LinkData nextLink : originalList) {
                    if(nextLink==linkData) continue;

                    if(linkData.getGroup()!=null){
                        from = linkData.getGroup();

                        if(!(linkData.getGroup().equals(nextLink.getGroup()))&&nextLink.getGroup()!=null){
                            nextTo = nextLink.getGroup();
                            resultList.add(new LinkData(from, nextTo, vpcGroup,index -=1));
                            break;
                        }
                    }

                    // secruity 간의 그룹 설계 하기 && vpc 그룹 같은 거 한해서
                    // vpc 그룹 이 왜인지는 모르겠지만 1은 null 로 들어감
                    if(linkData.getVpcgroup() == null  ){
                        linkData.setVpcgroup("Virtual private cloud (VPC)1");
                    }
                    if(nextLink.getVpcgroup() == null) {
                        nextLink.setVpcgroup("Virtual private cloud (VPC)1");
                    }

                    if ((to.startsWith("FW")&&nextLink.getFrom().equals(to) )&&
                        (linkData.getVpcgroup().equals(nextLink.getVpcgroup()))) {

                        if(nextLink.getGroup()!=null){
                            nextTo = nextLink.getGroup();
                        }
                        else {
                            nextTo = nextLink.getTo(); // nextlink 다음으로 가기
                        }
                        System.out.println("add parameter" +linkData.getFrom()+"12" + new LinkData(from, nextTo, 2));
                    }
                    if(nextTo!=null)
                        resultList.add(new LinkData(from, nextTo, index -= 1));

                    else{

                        if(linkData.getGroup()!=null&&nextLink.getGroup()!=null&&!(linkData.getGroup().equals(nextLink.getGroup()))){
                            System.out.println(linkData.getGroup()+"!!"+nextLink.getGroup());

                        resultList.add(new LinkData(linkData.getGroup(), nextLink.getGroup(), index -= 1));
                            System.out.println("add parameter" +linkData.getFrom()+"12" + new LinkData(linkData.getGroup(), nextLink.getGroup(),index -= 1));

                        }
                        else{
                            resultList.add(new LinkData(from, to, index -= 1));
                        }


                    }

                }
            }
        }
        // 중복된 리스트 제거
        resultList = unique(resultList);



        // 1. 그룹과의 그룹을 남겨두기
        // 2. 그룹 -> 노드 or 노드 -> 그룹 의 연결은 해당 노드가 그룹에 포함되었다면 그룹 -> 그룹으로 생성
        // 3. 노드 -> 노드 같은 경우 그룹으로 포함되지 않았다는 얘기 or 그룹 내의 연결이라서 일단 넣어두기

        List<LinkData> GroupList = new ArrayList<>();
        for (LinkData data : resultList) {
            // 그룹과의 그룹을 남겨두기
            if (data.getFrom().contains("Group") && data.getTo().contains("Group")) {
                GroupList.add(data);
            }
            // 노드 -> 노드 의 연결
            else if (!(data.getFrom().contains("Group")) && !(data.getTo().contains("Group"))) {
                GroupList.add(data);
            }


        }

        System.out.println("groupp"+GroupList);


        return GroupList;
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
                if(key.contains("DB")){
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









