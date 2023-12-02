package com.gae4coon.cloudmaestro.domain.ssohost.service;

import com.gae4coon.cloudmaestro.domain.ssohost.dto.*;
import io.swagger.v3.oas.models.links.Link;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class DiagramDTOService {
    public HashMap<String, Object> DiagramDTOtoResponse(GraphLinksModel graphLinksModel){
        Map<String, Object> dtog = dtoGenerator(graphLinksModel);

        List<NodeData> nodeDataList = (List<NodeData>) dtog.get("nodeDataArray");
        List<GroupData> groupDataList = (List<GroupData>) dtog.get("groupDataArray");
        List<LinkData> linkDataList = (List<LinkData>) dtog.get("linkDataArray");
        Map<String, Object> cost = (Map<String, Object>) dtog.get("cost");

        HashMap<String, Object> response = dtoComplete(nodeDataList, groupDataList, linkDataList, cost);
        return response;
    }
    
    public Map<String, Object> dtoGenerator(GraphLinksModel graphLinksModel){
        List<NodeData> dataArray = graphLinksModel.getNodeDataArray();
        List<NodeData> nodeDataList = new ArrayList<>();
        List<GroupData> groupDataList = new ArrayList<>();
        Map<String, Object> cost = graphLinksModel.getCost();

        List<LinkData> linkDataList = graphLinksModel.getLinkDataArray();

        for (NodeData data : dataArray) {
            if (data.getIsGroup() != null) {
                GroupData groupData = new GroupData(data.getKey(), data.getText(), data.getIsGroup(), data.getGroup(), data.getType(), data.getStroke(), data.getLoc());
                groupDataList.add(groupData);
            } else {
                nodeDataList.add(data);
            }
        }

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("nodeDataArray", nodeDataList);
        responseBody.put("groupDataArray", groupDataList);
        responseBody.put("linkDataArray", linkDataList);
        responseBody.put("cost", cost);

        return responseBody;
    }

    
    public HashMap<String, Object> dtoComplete(List<NodeData> nodeDataList, List<GroupData> groupDataList, List<LinkData> linkDataList, Map<String, Object> cost){

        List<Object> finalDataArray = new ArrayList<>();
        finalDataArray.addAll(nodeDataList);
        finalDataArray.addAll(groupDataList);
        finalDataArray.removeIf(Objects::isNull);

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("class", "GraphLinksModel");
        responseBody.put("linkKeyProperty", "key");
        responseBody.put("nodeDataArray", finalDataArray);
        responseBody.put("linkDataArray", linkDataList);
        responseBody.put("cost", cost);

        HashMap<String, Object> response = new HashMap<>();

        response.put("result", responseBody);

        return response;
    }


    public void addServiceGroup(List<GroupData> groupDataList){
        if(isGroupDataContains(groupDataList, "Service")) return;
        GroupData groupData = new GroupData();
        groupData.setKey("Service");
        groupData.setText("Service");
        groupData.setStroke("rgb(158, 224, 255)");
        groupDataList.add(groupData);
    }


    public boolean isNodeDataContains(List<NodeData> nodeDataList,String nodeText){
        for (NodeData node : nodeDataList) {
            if(node.getKey().contains(nodeText)) return true;
        }
        return false;
    }

    public boolean isGroupDataContains(List<GroupData> groupDataList, String groupText){
        for (GroupData group: groupDataList){
            if(group.getKey().contains(groupText)) return true;
        }
        return false;
    }

    public boolean isGroupDataEquals(List<GroupData> groupDataList, String groupText){
        for (GroupData group: groupDataList){
            if(group.getKey().equals(groupText)) return true;
        }
        return false;
    }

    public Set<String> getNestedGroupList(List<GroupData> groupDataList, String groupName){
        Set<String> nestedGroup = new HashSet<>();
        for (GroupData groupData: groupDataList){
            if (groupData.getGroup()!=null && groupData.getGroup().equals(groupName)){
                nestedGroup.add(groupData.getKey());
            }
        }
        return nestedGroup;
    }

    public Set<String> getNestedGroupListByLabel(List<GroupData> groupDataList, String groupLabel){
        Set<String> nestedGroup = new HashSet<>();
        for (GroupData groupData: groupDataList){
            if (groupData.getGroup()!=null && groupData.getGroup().startsWith(groupLabel)){
                nestedGroup.add(groupData.getKey());
            }
        }
        return nestedGroup;
    }

    public LinkData getLinkDataByTo(List<LinkData> linkDataList, String to){
        for (LinkData link : linkDataList) {
            if(link.getTo().equals(to)) return link;
        }
        return null;
    }
    public LinkData getLinkDataByFrom(List<LinkData> linkDataList, String from){
        for (LinkData link : linkDataList) {
            if(link.getFrom().equals(from)) return link;
        }
        return null;
    }

    public List<LinkData> getLinkDataListByFrom(List<LinkData> linkDataList, String from){
        List<LinkData> linklist = new ArrayList<>();
        for (LinkData link : linkDataList) {
            if(link.getFrom().equals(from))
                linklist.add(link);
        }

        return linklist;
    }
    public boolean isLink(List<LinkData> LinkDataList, String from, String to){
        for (LinkData link: LinkDataList){
            if(link.getFrom().contains(from) && link.getTo().contains(to)){
                return true;
            }
        }
        return false;
    }

    public NodeData getNodeDataByKey(List<NodeData> nodeDataList, String key){
        for (NodeData node : nodeDataList) {
            if(node.getKey().equals(key)) return node;
        }
        return null;
    }

    public NodeData getNodeDataByText(List<NodeData> nodeDataList, String text){
        for (NodeData node : nodeDataList) {
            if(node.getKey().contains(text)) return node;
        }
        return null;
    }

    public GroupData getGroupDataByKey(List<GroupData> groupDataList, String key){
        for (GroupData group : groupDataList) {
            if(group.getKey().equals(key)) return group;
        }
        return null;
    }



    public List<NodeData> getNodeListByText(List<NodeData> nodeDataList, String text){
        List<NodeData> nodeList = new ArrayList<>();
        for (NodeData node : nodeDataList) {
            if(node.getKey().contains(text)) nodeList.add(node);
        }
        return nodeList;
    }

    public List<GroupData> getGroupListByText(List<GroupData> groupDataList, String text) {
        List<GroupData> groupList = new ArrayList<>();
        for (GroupData group : groupDataList) {
            if (group.getText().contains(text)) groupList.add(group);
        }
        return groupList;
    }

    public int getNodeNumber(List<NodeData> nodeDataList, String text){
        int number=0;

        for (NodeData groupitem : nodeDataList) {
            if(groupitem.getKey().startsWith(text)){
                Pattern pattern = Pattern.compile("^" + Pattern.quote(text) + "(\\d*)");
                Matcher matcher = pattern.matcher(groupitem.getKey());
                if (matcher.find()) {
                    String numberStr = matcher.group(1); // text 다음의 숫자 부분
                    int tempnum = 1; // 기본값을 1로 설정
                    // 숫자가 있으면 그 숫자를 사용, 없으면 기본값 사용
                    if (!numberStr.isEmpty()) {
                        tempnum = Integer.parseInt(numberStr)+1;
                    }
                    if(number<tempnum) number=tempnum;
                }

            }
        }
        return number; // number 반환
    }
    public int getGroupNumber(List<GroupData> groupDataList, String text){
        int number=0;

        for (GroupData groupitem : groupDataList) {
            if(groupitem.getKey().startsWith(text)){
                Pattern pattern = Pattern.compile("^" + Pattern.quote(text) + "(\\d*)"); // 'S3' 대신 'text' 사용
                Matcher matcher = pattern.matcher(groupitem.getKey());
                if (matcher.find()) {
                    String numberStr = matcher.group(1); // text 다음의 숫자 부분
                    int tempnum = 1; // 기본값을 1로 설정
                    // 숫자가 있으면 그 숫자를 사용, 없으면 기본값 사용
                    if (!numberStr.isEmpty()) {
                        tempnum = Integer.parseInt(numberStr)+1;
                    }
                    if(number<tempnum) number=tempnum;
                }

            }
        }
        return number; // number 반환
    }

    public List<LinkData> uniqueLink(List<LinkData> linkDataList) {
        Set<LinkData> linkDataSet = new HashSet<>();
        for (LinkData link1 : linkDataList) {
            linkDataSet.add(link1);
        }

        List<LinkData> setlist = new ArrayList<>();
        for (LinkData l : linkDataSet) {
            setlist.add(l);
        }
        return setlist;
    }

}
