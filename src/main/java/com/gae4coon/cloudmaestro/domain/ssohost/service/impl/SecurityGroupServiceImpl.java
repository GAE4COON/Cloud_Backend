package com.gae4coon.cloudmaestro.domain.ssohost.service.impl;

import com.gae4coon.cloudmaestro.domain.ssohost.dto.GroupData;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.NodeData;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.LinkData;
import com.gae4coon.cloudmaestro.domain.ssohost.service.SecurityGroupService;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class SecurityGroupServiceImpl implements SecurityGroupService {

    @Override
    public void addSecurityGroup(List<NodeData> nodeDataList, List<GroupData> groupDataList, List<LinkData> linkDataList) {
        List<NodeData> newNodeDataList = new ArrayList<>();
        List<GroupData> newGroupDataList = new ArrayList<>();

        newNodeDataList.addAll(nodeDataList);
        newGroupDataList.addAll(groupDataList);

        // from==fw 찾기
        String from;
        String to;
        int index = 0;

        List<String> linkFrom = new ArrayList<>();
        for (LinkData link1 : linkDataList) {
            if (!link1.getFrom().contains("Firewall")) continue;
            from = link1.getFrom();
            if (linkFrom.contains(from)) continue;
            else linkFrom.add(from);

            // sg 생성된다면 원래 group이 sg의 상위 그룹
            GroupData sg = new GroupData();

            // 해당 FW에 연결된 노드 전부 찾기
            for (LinkData link2 : linkDataList) {
                if (!link2.getFrom().equals(from)) continue;
                to = link2.getTo();

                if (!to.contains("Server") && !to.contains("Database")) continue;

                // FW에 연결된 노드에 SG 그룹 설정
                for (NodeData node2 : nodeDataList) {
                    if (node2.getKey().equals(to)) {
                        String SGName = "Security Group" + index;
                        if (node2.getGroup() != null) {
                            String node2Group = node2.getGroup();

                            sg.setGroup(node2Group);
                            sg.setKey(SGName);
                            sg.setText(SGName);
                            sg.setIsGroup(true);
                            sg.setType("group");
                            sg.setStroke("rgb(221,52,76)");
                        }
                        node2.setGroup("Security Group" + index);
                    }
                }
            }
            if (sg.getStroke() != null) {
                groupDataList.add(sg);
            }
            index++;
        }

        // 리턴용
        Map<List<GroupData>, List<NodeData>> resultMap = new HashMap<>();
        resultMap.put(groupDataList, nodeDataList);

        return;
    }

    @Override
    public void modifySecurityGroupLink(List<NodeData> nodeDataList, List<GroupData> groupDataList, List<LinkData> linkDataList) {
        for (NodeData nodeData : nodeDataList) {
            if (nodeData.getGroup()!=null&&!nodeData.getGroup().contains("Security Group")) continue;

            for (LinkData linkData : linkDataList) {
                if (linkData.getFrom().equals(nodeData.getKey())) {
                    linkData.setFrom(nodeData.getGroup());
                } else if (linkData.getTo().equals(nodeData.getKey())) {
                    linkData.setTo((nodeData.getGroup()));

                }
            }
        }

        Map<List<GroupData>, List<NodeData>> resultMap = new HashMap<>();
        resultMap.put(groupDataList, nodeDataList);

        return;
    }


    // from 이 server이고, to가 같은 목적지라면 ?
    @Override
    public void addEc2Group(List<NodeData> nodeDataList, List<GroupData> groupDataList, List<LinkData> linkDataList){

        List<NodeData> newNodeDataList = new ArrayList<>();
        List<GroupData> newGroupDataList = new ArrayList<>();

        // Server에서 같은 to를 향한다면 같은 그룹으로 묶기
        for (NodeData nodedata : nodeDataList) {
            System.out.println("NodeData" + nodedata);
            for(LinkData linkdata : linkDataList){
                if(nodedata.getText().contains("Server")){


                }
            }
        }


    }
}
