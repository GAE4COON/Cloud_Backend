package com.gae4coon.cloudmaestro.domain.available.service;

import com.gae4coon.cloudmaestro.domain.requirements.dto.RequireDiagramDTO;
import com.gae4coon.cloudmaestro.domain.requirements.dto.ZoneDTO;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.GroupData;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.LinkData;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.NodeData;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AvailableService {

    public int alb_index =0;
    public double alb_node_x; public double alb_node_y; public double node_x; public double node_y;
    public String originalpublicsubnetname = ""; public String originalprivatesubnetname = ""; public int Auto_index = 0;

    public double nat_node_x;
    public double nat_node_y;
    public void availalbeService(RequireDiagramDTO requireDiagramDTO, List<NodeData>nodeDataList, List<GroupData> groupDataList, List<LinkData>linkDataList) {

            if (   !requireDiagramDTO.getRequirementData().getZones().isEmpty()
            ) {
                if (    requireDiagramDTO.getRequirementData().getZones().get(0).getAvailableNode().size() > 0 ||
                        requireDiagramDTO.getRequirementData().getZones().get(0).getServerNode().size() > 0) {
                    List<ZoneDTO> zoneRequirements = requireDiagramDTO.getRequirementData().getZones();

                    int key = -10;

                    for (int i = 0; i < zoneRequirements.size(); i++) {
                            String zone_name = zoneRequirements.get(i).getName();
                            madeSubnetName(linkDataList, zone_name);

                            String publicSubnetName = originalpublicsubnetname + "_copy";
                            String privateSubnetName = originalprivatesubnetname + "_copy";

                            String az ="";
                            for(GroupData groupData: groupDataList){
                                if(groupData.getGroup() != null &&
                                        groupData.getKey().equals(originalprivatesubnetname)){
                                    az = groupData.getGroup();
                                    break;
                                }
                            }

                            // Available Zone
                            String vpc = "";
                            for(GroupData groupdata : groupDataList){
                                if(     groupdata.getGroup() != null &&
                                        groupdata.getKey().equals(az)){
                                    vpc = groupdata.getGroup();
                                    break;
                                }
                            }
                            // 위치 정보가 왼쪽으로 제일 긴 X의 node를 선택 한다.
                            double[] nat = defaulSetting(nodeDataList, linkDataList, groupDataList, nat_node_x, nat_node_y, originalprivatesubnetname,az,vpc,originalpublicsubnetname);
                            nat_node_x = nat[0];
                            nat_node_y = nat[1];

                            // 새로운 AZ 생성
                            madeAvaliableZone(publicSubnetName, privateSubnetName, nodeDataList, linkDataList,groupDataList ,key, az, vpc,nat_node_x, nat_node_y);


                            // Available Node 정렬하기
                            List<String> availableNodes = zoneRequirements.get(i).getAvailableNode();

                            linkDataList.sort(Comparator.comparing(LinkData::getFrom).thenComparing(LinkData::getTo));
                            List<String> availalbeNodes = LinkDataSort(linkDataList, availableNodes);

                            List<String> serverNodes = zoneRequirements.get(i).getServerNode();
                            List<LinkData> deleteLink = new ArrayList<>();

                            if (zoneRequirements.get(i).getServerNode().size() > 0) {
                                ServerNode(serverNodes, linkDataList, groupDataList, nodeDataList,
                                        node_x, node_y, key, privateSubnetName, originalprivatesubnetname, deleteLink,vpc,az);
                            }
                            if (availalbeNodes.size() > 0) {
                                // ALB node 생성 및 node 연결
                                ServerandAvailable(linkDataList, groupDataList, nodeDataList,
                                        availableNodes, node_x, node_y, key, privateSubnetName);
                            }
                            // 마지막에 linked list data 정리 ..
                            DeleteLinkedList(nodeDataList, linkDataList, deleteLink);

                    }
                }
            }
        }


    public void DeleteLinkedList(List<NodeData> nodeDataList, List<LinkData> linkDataList, List<LinkData> deleteLink) {
        // A -> TO -> FROM 이 같은 경우 //
        List<LinkData> temp = new ArrayList<>();
        for(LinkData linkdata : linkDataList){
            for (LinkData linkdata2 : linkDataList){
                if(linkdata.getFrom().contains("ALB") && linkdata.getTo().equals(linkdata2.getTo())){
                    temp.add(linkdata);
                }
            }
        }
        linkDataList.remove(deleteLink);

    }


    public void madeAvaliableZone(String publicSubnetName, String privateSubnetName, List<NodeData> nodeDataList, List<LinkData> linkDataList,List<GroupData> groupDataList ,int key, String az, String vpc, double nat_node_x, double nat_node_y) {
        GroupData publicSubnetNode = createGroupData(publicSubnetName, "group", az + "a", "rgb(122,161,22)",null);
        groupDataList.add(publicSubnetNode);
        GroupData privateSubnetNode = createGroupData(privateSubnetName, "group",  az + "a",  "rgb(0,164,166)",null);
        groupDataList.add(privateSubnetNode);


        GroupData availableNode = createGroupData(az+"a", "AWS_Groups",vpc,"rgb(0,164,166)",null);
        //groupDataList.add(availableNode);

        boolean exists = false;
        for(GroupData groupData : groupDataList){
            if(groupData.getText().equals(availableNode.getText())){
                exists = true;
                break;
            }
        }
        if (!exists) {
            groupDataList.add(availableNode);
        }

        // link 정보 연결하기
        LinkData pubToPriv = createLinkData(publicSubnetName, privateSubnetName, key - 1);
        linkDataList.add(pubToPriv);

        key -= 1;
        LinkData intToPub = createLinkData("Internet Gateway", publicSubnetName, key - 1);
        linkDataList.add(intToPub);

        key -= 1;
        NodeData natNode = makeNat(linkDataList,nodeDataList,publicSubnetName,nat_node_x, nat_node_y,key,vpc);
        nat_node_x += 200; nat_node_y += 400;
        // nat 기준으로 node data 설정_
        node_x = nat_node_x + 430; node_y = nat_node_y - 460;
    }


    public void madeSubnetName(List<LinkData> linkDataList,String zone_name) {
        String from =  "";
        String to = "";
        for(LinkData linkdata : linkDataList){
            if(linkdata.getFrom() != null){
                String[] group_name = linkdata.getFrom().split(" ");
                from = group_name[0];
                if(from.equals(zone_name) && linkdata.getFrom().contains("Public")){
                    originalpublicsubnetname = linkdata.getFrom();

                }
            }
            if(linkdata.getTo() != null){
                String[] group_name = linkdata.getTo().split(" ");
                to = group_name[0];
                if(to.equals(zone_name) && linkdata.getTo().contains("Private")){
                    originalprivatesubnetname = linkdata.getTo();
                    //System.out.println("Private Subnet Name" + originalprivatesubnetname);
                }
            }


        }
    }

    public double [] defaulSetting(List<NodeData> nodeDataList, List<LinkData> linkDataList, List<GroupData> groupDataList, double nat_node_x, double nat_node_y, String originalprivatesubnetname, String az, String vpc,String originalpublicsubnetname) {

        NodeData highestNode = null;

        double[] coordinates = findNodeWithHighestYCoordinate(nodeDataList,groupDataList, originalprivatesubnetname ,az, vpc);


        alb_node_x = coordinates[0];
        alb_node_y = coordinates[1];

        // nat_node 위치 설정
        nat_node_x = coordinates[0];
        nat_node_y = coordinates[1];

        alb_node_x += 200; alb_node_y -=10;
        nat_node_x += 600; nat_node_y += 100;

        int key = -10;

//        // AZ 존은 하나 생성
//        GroupData Azdata = makeAz(groupDataList, az, vpc);

        // linkdata from, to 를 기준으로 zoneRequirement를 정렬시키기

        linkDataList.sort(Comparator.comparing(LinkData::getFrom).thenComparing(LinkData::getTo));
        return new double[]{nat_node_x, nat_node_y};
    }

    public List<LinkData> ServerandAvailable(List<LinkData> linkDataList, List<GroupData> groupDataList, List<NodeData> nodeDataList, List<String> availableNodes, double nodeX, double nodeY, int key, String privateSubnetName)
        {
            // 삭제할 linked list 가져오기
            List<LinkData> delete_linked_list = new ArrayList<>();

            for (String node : availableNodes) {
                // NodeData 복사 시작
                List<NodeData> node_temp_list = new ArrayList<>();
                String security_group = "";

                // ALB Node 생성makeALBandInternet
                NodeData AlbNode;

                // node 추가하기
                boolean includeGroup = true;
                boolean includeALB = true;
                if (node.contains("Security Group")) {

                    security_group = node + "a";
                    AlbNode = makeALb(alb_index, alb_node_x, alb_node_y);

                    // internet gateway to ALB
                    LinkData addIntoALB = createLinkData("Internet Gateway", AlbNode.getKey(), key - 1);
                    linkDataList.add(addIntoALB);

                    // ALB to 기존 Node
                    LinkData addALBintoGroup = createLinkData(AlbNode.getKey(), node, key - 1);
                    linkDataList.add(addALBintoGroup);
                    nodeDataList.add(AlbNode);
                    // 이미 기존에 있는 그룹일테니깐 ... 그 그룹에다가 선택을 하는 거지 ...
                    for (GroupData groupdata : groupDataList) {

                        if (groupdata.getKey() != null &&
                                groupdata.getKey().equals(security_group)) {
                            GroupData new_security_group = groupdata;
                            addLinkSecurityGroup(new_security_group, linkDataList, AlbNode, key -= 1);
                            includeGroup = false;
                            break;
                        }
                    }
                    if (includeGroup) {
                        // 새로운 그룹 생성하고 그룹과 alb의 연결
                        GroupData new_security_group = createAndConfigureGroupData(security_group, privateSubnetName);
                        addSecurityGroup(node, security_group, new_security_group, groupDataList, nodeDataList, linkDataList, node_temp_list, node_x, node_y, AlbNode, key -= 1);
                    }

                } else if (node.contains("EC2")) {

                    // Ec2를 선택을 했는데 같은 계층에 ec2 중 auto scaling group 이 있다면 그것과 연결을 하기
                    String To = "";
                    boolean nodeExists = false;
                    for (LinkData linkData : linkDataList) {
                        if (linkData.getFrom().equals(node)) {
                            To = linkData.getTo();
                            break;
                        }
                    }
                    boolean includeEc2 = false;
                    boolean includelink2 = false;
                    // 같은 To를 향한 node 중에 auto scaling group이 있다면 ?
                    for (LinkData linkData : linkDataList) {
                        if (linkData.getTo().equals(To)) {
                            includelink2 = true;
                            for (NodeData nodeData : nodeDataList) {
                                if (nodeData.getKey().equals(linkData.getFrom()) &&
                                        nodeData.getGroup().contains("Auto Scaling")) {
                                    node = nodeData.getKey();
                                    includeEc2 = true;
                                    break;
                                }
                            }
                        }
                    }
                    if(!includelink2){
                        for(NodeData nodedata : nodeDataList){
                            if(nodedata.getKey().equals(node) &&
                                    nodedata.getGroup().contains("Auto Scaling")){
                                node = nodedata.getKey();
                                includeEc2 = true;
                                break;
                            }
                        }
                    }


                    for (LinkData linkdata : linkDataList) {
                        if (linkdata.getFrom().contains("ALB") && linkdata.getTo().equals(node)) {
                            includeALB = false;
                        }
                    }

                    if (includeEc2 && includeALB) {
                        AlbNode = makeALb(alb_index, alb_node_x, alb_node_y);

                        // internet gateway to ALB
                        LinkData addIntoALB = createLinkData("Internet Gateway", AlbNode.getKey(), key - 1);
                        linkDataList.add(addIntoALB);

                        // ALB to 기존 Node
                        LinkData addALBintoGroup = createLinkData(AlbNode.getKey(), node, key - 1);
                        linkDataList.add(addALBintoGroup);

                        LinkData addALBintoEC2 = createLinkData(AlbNode.getKey(), node, key - 1);
                        nodeDataList.add(AlbNode);
                        if (!linkDataList.contains(addALBintoEC2)) {
                            linkDataList.add(addALBintoEC2);
                        }

                        LinkData albtogroup = createLinkData(AlbNode.getKey(), node + "a", key -= 1);
                        if (!linkDataList.contains(albtogroup)) {
                            linkDataList.add(albtogroup);
                        }

                    }
                    if (!includeEc2) {
                        AlbNode = makeALb(alb_index, alb_node_x, alb_node_y);
                        // internet gateway to ALB
                        LinkData addIntoALB = createLinkData("Internet Gateway", AlbNode.getKey(), key - 1);
                        linkDataList.add(addIntoALB);

                        // ALB to 기존 Node
                        LinkData addALBintoGroup = createLinkData(AlbNode.getKey(), node, key - 1);
                        linkDataList.add(addALBintoGroup);
                        nodeDataList.add(AlbNode);
                        double[] newCoordinates = addNode(node, groupDataList, nodeDataList, linkDataList, AlbNode, node_x, node_y, privateSubnetName, key -= 1);
                        node_x = newCoordinates[0];
                        node_y = newCoordinates[1];
                    }

                }

                alb_index += 1;
                alb_node_x += 100;
                alb_node_y -= 10;

            }

            return delete_linked_list;

    }


    public void makeALBandInternet(NodeData AlbNode, List<LinkData> linkDataList, int albIndex, double albNodeX, double albNodeY, int key, String node) {
        AlbNode = makeALb(alb_index,alb_node_x,alb_node_y);

        // internet gateway to ALB
        LinkData addIntoALB = createLinkData("Internet Gateway", AlbNode.getKey(), key - 1);
        linkDataList.add(addIntoALB);

        // ALB to 기존 Node
        LinkData addALBintoGroup = createLinkData(AlbNode.getKey(), node, key - 1);
        linkDataList.add(addALBintoGroup);

        key -= 1;
    }

    public void linkEc2andALB(NodeData AlbNode, String node, int key,List<LinkData> linkDataList) {
        LinkData addALBintoEC2 = createLinkData(AlbNode.getKey(), node, key - 1);
        if(!linkDataList.contains(addALBintoEC2)){
            linkDataList.add(addALBintoEC2);
        }

        LinkData albtogroup = createLinkData(AlbNode.getKey(),node+"a",key-=1);
        if(!linkDataList.contains(albtogroup)){
            linkDataList.add(albtogroup);
        }
    }

    private double[] addLinkSecurityGroup( GroupData new_security_group, List<LinkData> linkDataList, NodeData albNode, int key) {

        // ALB Node와 연결
        LinkData albtogroup = createLinkData(albNode.getKey(),new_security_group.getKey(),key-=1);
        linkDataList.add(albtogroup);
        return new double[]{node_x, node_y};

    }


    public List<String> LinkDataSort(List<LinkData> linkDataList, List<String> availableNodes) {

        Map<String, Integer> linkDataOrder = new HashMap<>();
        for (int i = 0; i < linkDataList.size(); i++) {
            String key = linkDataList.get(i).getFrom(); // or any relevant property
            linkDataOrder.put(key, i);
        };
        Comparator<String> sortByLinkDataOrder = (node1, node2) -> {
            Integer order1 = linkDataOrder.getOrDefault(node1, Integer.MAX_VALUE);
            Integer order2 = linkDataOrder.getOrDefault(node2, Integer.MAX_VALUE);
            return Integer.compare(order1, order2);
        };
        availableNodes.sort(sortByLinkDataOrder);
        return availableNodes;
    }



    public void removeNode(List<String> exceptNode, List<LinkData> linkDataList, List<NodeData> nodeDataList,List<LinkData> deleteLink) {
        List<NodeData> exceptNode2 = new ArrayList<>(); // 올바른 리스트 초기화
        if(!exceptNode.isEmpty()) {
            for (int i = 0; i < exceptNode.size(); i++) {
                for (NodeData nodedata : nodeDataList) {
                    if (nodedata.getKey().equals(exceptNode.get(i)) && nodedata.getGroup().contains("Auto Scaling group")) {
                        // Auto Scaling group에 속하는 노드는 제외
                    } else if (nodedata.getKey().equals(exceptNode.get(i))) {
                        // Auto Scaling group에 속하지 않는 노드는 삭제 목록에 추가
                        for (LinkData linkdata : linkDataList) {
                            if (linkdata.getFrom().equals(nodedata.getKey())) {
                                deleteLink.add(linkdata);
                            }
                        }
                        exceptNode2.add(nodedata);
                    }
                }
            }
            nodeDataList.removeAll(exceptNode2); // 삭제 목록에 있는 모든 노드 제거

        }
   }


    public void addCopyNode(List<String> exceptNode, List<GroupData> groupDataList, List<NodeData> nodeDataList, String privateSubnetName, int autoIndex, int text_index,String node) {
        GroupData AutoGroup = new GroupData();
        AutoGroup.setIsGroup(true);
        AutoGroup.setStroke("rgb(237,113,0)");
        AutoGroup.setText("Auto Scaling group" + text_index);
        AutoGroup.setKey("Auto Scaling group" + autoIndex);
        AutoGroup.setType("AWS_Groups");
        AutoGroup.setGroup(privateSubnetName);
        groupDataList.add(AutoGroup);

        List<NodeData> newNodes = new ArrayList<>();
        if(! exceptNode.isEmpty()) {
            for (NodeData nodedata : nodeDataList) {
                if (nodedata.getKey().equals(exceptNode.get(0))) {
                    NodeData copiedNode = new NodeData();
                    node_x += 200;
                    String newLoc = (node_x) + " " + (node_y);

                    copiedNode.setText(nodedata.getText());
                    copiedNode.setType(nodedata.getType());
                    copiedNode.setKey(nodedata.getKey() + "a");
                    copiedNode.setIsGroup(null);
                    copiedNode.setSource("/img/AWS_icon/Arch_Compute/Arch_Amazon-EC2_48.svg");
                    copiedNode.setGroup("Auto Scaling group" + autoIndex);
                    copiedNode.setLoc(newLoc);
                    newNodes.add(copiedNode);

                }
            }
        }

        if(exceptNode.isEmpty()){
            for(NodeData nodedata : nodeDataList){
                if(nodedata.getKey().equals(node)){
                    NodeData copiedNode = new NodeData();
                    node_x += 200;
                    String newLoc = (node_x) + " " + (node_y);

                    copiedNode.setText(nodedata.getText());
                    copiedNode.setType(nodedata.getType());
                    copiedNode.setKey(nodedata.getKey() + "a");
                    copiedNode.setIsGroup(null);
                    copiedNode.setSource("/img/AWS_icon/Arch_Compute/Arch_Amazon-EC2_48.svg");
                    copiedNode.setGroup("Auto Scaling group" + autoIndex);
                    copiedNode.setLoc(newLoc);
                    newNodes.add(copiedNode);

                }
            }
        }


        nodeDataList.addAll(newNodes);


    }

    public void addOriginalNode(List<String> exceptNode, List<GroupData> groupDataList, List<NodeData> nodeDataList, String originalprivatesubnetname, int autoIndex, int text_index,String node) {
        GroupData AutoGroup = new GroupData();
        if(!exceptNode.isEmpty()) {
            for (NodeData nodedata : nodeDataList) {
                if (nodedata.getKey().equals(exceptNode.get(0))) {
                    nodedata.setGroup("Auto Scaling group" + autoIndex);
                    AutoGroup.setIsGroup(true);
                    AutoGroup.setStroke("rgb(237,113,0)");
                    AutoGroup.setText("Auto Scaling group" + text_index);
                    AutoGroup.setKey("Auto Scaling group" + autoIndex);
                    AutoGroup.setType("AWS_Groups");
                    AutoGroup.setGroup(originalprivatesubnetname);

                }
            }
        }
        GroupData AutoGroup2 = new GroupData();
        if(exceptNode.isEmpty()){
            for(NodeData nodedata : nodeDataList){
                if(nodedata.getKey().equals(node)){
                    nodedata.setGroup("Auto Scaling group" + autoIndex);
                    AutoGroup2.setIsGroup(true);
                    AutoGroup2.setStroke("rgb(237,113,0)");
                    AutoGroup2.setText("Auto Scaling group" + text_index);
                    AutoGroup2.setKey("Auto Scaling group" + autoIndex);
                    AutoGroup2.setType("AWS_Groups");
                    AutoGroup2.setGroup(originalprivatesubnetname);

                }
            }
        }
        if (AutoGroup != null && AutoGroup.getIsGroup()) {
            groupDataList.add(AutoGroup);
        }
        if (AutoGroup2 != null && AutoGroup2.getIsGroup()) {
            groupDataList.add(AutoGroup2);
        }


    }

    public List<String> ExceptandAddInvidiualNode(List<NodeData> nodeDataList, List<LinkData> linkDataList, List<GroupData> groupDataList, String node) {
        List<String> ExceptNode = new ArrayList<>();
        String to = "";
        int text_index;
        for(LinkData listdata : linkDataList){
            if(listdata.getFrom().equals(node)){
                to = listdata.getTo();
            }

        }

        for(LinkData listdata2: linkDataList) {
            if (to != "") {
                if (listdata2.getTo().equals(to)) {
                    ExceptNode.add(listdata2.getFrom());
                }
            }else{
                if(listdata2.getTo().equals(node)){
                    ExceptNode.add(node);
                }

            }
        }

        return ExceptNode;
    }

    public GroupData createAutoGroup(String security_group, int index, int text_index, List<NodeData> nodeDataList, List<GroupData> groupDataList, String privateSubnetName) {
        GroupData autogroup = new GroupData();
        autogroup.setKey(security_group);
        autogroup.setText(security_group);
        autogroup.setIsGroup(true);
        autogroup.setGroup("Auto Scaling group" + index);
        autogroup.setType("group");
        autogroup.setStroke("rgb(221,52,76)");

        groupDataList.add(autogroup);

        GroupData AutoGroup = new GroupData();
        AutoGroup.setIsGroup(true);
        AutoGroup.setStroke("rgb(237,113,0)");
        AutoGroup.setText("Auto Scaling group" + text_index);
        AutoGroup.setKey("Auto Scaling group" + index);
        AutoGroup.setType("AWS_Groups");
        AutoGroup.setGroup(privateSubnetName);

        groupDataList.add(AutoGroup);
        return autogroup;
    }

    public void ExceptNode(String node, List<NodeData> nodeDataList, List<GroupData> groupDataList, List<NodeData> exceptNode) {
        System.out.println("node :: " + node);
        System.out.println("nodeDataList :: "+ nodeDataList);
        System.out.println("groupDataList :: " + groupDataList);
        System.out.println("exceptNode :: " + exceptNode);


        for(NodeData nodedata : nodeDataList){
            if(nodedata.getGroup().equals(node)){
                exceptNode.add(nodedata);
            }
        }
        System.out.println("exceptNode1 :: " + exceptNode);
        if(exceptNode.size() >=2){
            for (int i = 1; i < exceptNode.size(); i++) {
                nodeDataList.remove(exceptNode.get(i));
            }
        }
        System.out.println("exceptNode2 :: " + exceptNode);
        List<GroupData> exceptgroup = new ArrayList<>();
        for(GroupData groupData : groupDataList){
            if(groupData.getKey() != null &&
                groupData.getKey().equals(node)){
                System.out.println("groupData :: " + groupData);
                exceptgroup.add(groupData);
            }
        }

        System.out.println("exceptNode3 :: " + exceptNode);
        groupDataList.remove(exceptgroup.get(0));

    }


    public double[] addNode(String node, List<GroupData> groupDataList, List<NodeData> nodeDataList, List<LinkData> linkDataList, NodeData AlbNode, double node_x, double node_y, String privateSubnetName, int Key) {
        String node_name = node + "a";
        NodeData nodedata = new NodeData();
        node_x += 150;
        nodedata.setGroup(privateSubnetName);
        nodedata.setText("EC2");
        nodedata.setType("Compute");
        nodedata.setKey(node_name);
        nodedata.setSource( "/img/AWS_icon/Arch_Compute/Arch_Amazon-EC2_48.svg");
        String newLoc = (node_x) + " " + (node_y);
        nodedata.setLoc(newLoc);
        nodedata.setIsGroup(null);

        nodeDataList.add(nodedata);
        LinkData albtogroup = createLinkData(AlbNode.getKey(),nodedata.getKey(),Key-=1);
        linkDataList.add(albtogroup);
        return new double[]{node_x, node_y};
    }

    public double[] addSecurityGroup(String node, String security_group, GroupData new_security_group, List<GroupData> groupDataList, List<NodeData> nodeDataList, List<LinkData> linkDataList, List<NodeData> node_temp_list, double node_x, double node_y, NodeData AlbNode, int key) {
        if (!groupDataList.contains(new_security_group)) {
            groupDataList.add(new_security_group); // Add new security group if not present
        }
        for (NodeData nodedata : nodeDataList) {
            if (nodedata.getGroup().equals(node)) {
                node_temp_list.add(nodedata);
            }
        }
        // 새로운 그룹을 생성하면서, 그룹에 해당하는 노드들  복사
        for (NodeData copy_node : node_temp_list){
            node_x += 150;
            String newLoc = (node_x) + " " + (node_y);
            NodeData copiedNode = new NodeData();
            copiedNode.setText(copy_node.getText());
            copiedNode.setType(copy_node.getType());
            copiedNode.setKey(copy_node.getKey() + alb_index);
            copiedNode.setSource(copy_node.getSource());
            copiedNode.setIsGroup(null);
            copiedNode.setGroup(security_group);
            copiedNode.setLoc(newLoc);
            nodeDataList.add(copiedNode);
        }
        // ALB Node와 연결
        LinkData albtogroup = createLinkData(AlbNode.getKey(),new_security_group.getKey(),key -=1);
        linkDataList.add(albtogroup);
        return new double[]{node_x, node_y};

    }

    public GroupData makeAz(List<GroupData> groupDataList, String az, String vpc) {
        GroupData Azdata = new GroupData();
        Azdata.setKey(az + "a");
        Azdata.setText("Availability Zone");
        Azdata.setIsGroup(true);
        Azdata.setGroup(vpc);
        Azdata.setType("AWS_Groups");
        Azdata.setStroke("rgb(0,164,166)");

        groupDataList.add(Azdata);
        return Azdata;
    }

    public NodeData makeNat(List<LinkData> linkDataList, List<NodeData> nodeDataList, String publicSubnetName, double natNodeX, double natNodeY, int index, String vpc) {
        int nat_sum = 1;
        for(LinkData linkdata : linkDataList){
            if(linkdata.getFrom().contains("Public Subnet"))
            {
                nat_sum +=1 ;
            }
        }

        nat_sum += index;
        NodeData natnode = new NodeData();
        natnode.setText("NAT Gateway");
        natnode.setType("Networking-Content-Delivery");
        natnode.setKey("NAT Gateway" + nat_sum);
        natnode.setSource("/img/AWS_icon/Arch_Networking-Content-Delivery/Arch_Amazon-VPC_NAT-Gateway_48.svg");
        String newLoc = (natNodeX) + " " + (natNodeY);
        natnode.setLoc(newLoc);
        natnode.setIsGroup(null);
        natnode.setGroup(publicSubnetName);

        nodeDataList.add(natnode);
        return natnode;


    }

    public double[] findNodeWithHighestYCoordinate(List<NodeData> nodeDataList, List<GroupData> groupDataList, String originalPrivateSubnetName, String az , String vpc) {


        // string originalprivatesubnetname
        NodeData highestXNode = null;

        double highestX = Double.NEGATIVE_INFINITY;
        double lowestY = Double.MAX_VALUE; // 초기값을 가장 큰 값으로 설정


        // First iteration - directly over nodeDataList
        for (NodeData nodeData : nodeDataList) {
            if (nodeData.getGroup().contains(originalPrivateSubnetName)) {
                highestX = updateHighestX(nodeData, highestX);
                String location = nodeData.getLoc();
                String[] locParts = location.split(" ");
                double y = Double.parseDouble(locParts[1]);

                if (y < lowestY) {
                    lowestY = y;
                }
            }
        }

        // Second iteration - now iterating over groupDataList
        for (GroupData groupData : groupDataList) {
            if (    groupData.getGroup() != null &&
                    groupData.getGroup().contains(originalPrivateSubnetName)) {
                String securityGroup = groupData.getKey();
                for (NodeData nodeData : nodeDataList) {
                    if (nodeData.getGroup().equals(securityGroup)) {
                        highestX = updateHighestX(nodeData, highestX);
                        String location = nodeData.getLoc();
                        String[] locParts = location.split(" ");
                        double y = Double.parseDouble(locParts[1]);

                        if (y < lowestY) {
                            lowestY = y;
                        }
                    }
                }
            }
        }

        NodeData lowestYNode = null;

        for (NodeData nodedata : nodeDataList) {
            if (nodedata.getGroup().contains(originalprivatesubnetname)) {
                String location = nodedata.getLoc();
                String[] locParts = location.split(" ");

                double y = Double.parseDouble(locParts[1]);
                if (y < lowestY) {
                    lowestY = y;
                }
            }
        }
        return new double[]{highestX, lowestY};
    }
    private double updateHighestX(NodeData nodeData, double currentHighestX) {
        try {
            String location = nodeData.getLoc();
            String[] locParts = location.split(" ");
            double x = Double.parseDouble(locParts[0]);
            if (x > currentHighestX) {
                return x;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid location format for node: " + nodeData);
        }
        return currentHighestX;
    }

    public NodeData makeALb(int index, double node_x, double node_y){
        NodeData AlbNode = new NodeData();
        AlbNode.setText("Application Load Balancer (ALB)");
        AlbNode.setKey("Application Load Balancer (ALB)" + index);
        AlbNode.setFigure("Rectangle");
        AlbNode.setSource("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Elastic-Load-Balancing_Application-Load-Balancer_48.svg");
        AlbNode.setType("Networking-Content-Delivery");
        String newLoc = (node_x) + " " + (node_y);
        AlbNode.setLoc(newLoc);
        AlbNode.setGroup("VPC");
        return AlbNode;

    }

    public GroupData createGroupData(String name, String type, String group, String stroke, String newLoc) {
        GroupData node = new GroupData();
        node.setKey(name);
        node.setText(name);
        node.setIsGroup(true);
        node.setGroup(group);
        node.setType(type);
        node.setStroke(stroke);
        if (newLoc != null && !newLoc.isEmpty()) {
            node.setLoc(newLoc);
        }
        return node;
    }
    public LinkData createLinkData(String from, String to, int key) {
        LinkData link = new LinkData();
        link.setFrom(from);
        link.setTo(to);
        link.setKey(key);
        return link;
    }
    public GroupData createAndConfigureGroupData(String securityGroup, String privateSubnetName) {
        GroupData group = new GroupData();
        group.setKey(securityGroup);
        group.setText("Security Group");
        group.setIsGroup(true);
        group.setGroup(privateSubnetName);
        group.setType("group");
        group.setStroke("rgb(221,52,76)");

        return group;
    }

    public void ServerNode(List<String> serverNode, List<LinkData> linkDataList, List<GroupData> groupDataList,
                           List<NodeData> nodeDataList, double node_x,
                           double node_y, int key, String privateSubnetName,
                           String originalprivatesubnetname, List<LinkData> deleteLink, String vpc, String az) {

        int text_index;
        List<String> exceptNode2 = new ArrayList<>();  // 리스트 초기화
        for(String node : serverNode){
            System.out.println("serverNode는 : " + serverNode + node);
            List<NodeData> exceptNode = new ArrayList<>();
            // Node 1개만 빼고 제외하기
            if(node.contains("EC2")){
                System.out.println("Ec2 : " + node);
                boolean exit = true;
                boolean nolink = true;
                for(String except : exceptNode2){
                    if(except.equals(node)){
                        exit = false;
                    }
                }
                if (exceptNode2.isEmpty() || exit) { // 리스트가 비어있지 않고, 특정 node가 포함되지 않은 경우

                    exceptNode2 = ExceptandAddInvidiualNode(nodeDataList, linkDataList, groupDataList, node);
                    // Available 에 Node 넣기
                    text_index = Auto_index;
                    addOriginalNode(exceptNode2, groupDataList, nodeDataList, originalprivatesubnetname, Auto_index, text_index, node);
                    Auto_index += 1;
                    addCopyNode(exceptNode2, groupDataList, nodeDataList, privateSubnetName, Auto_index, text_index, node);

                    removeNode(exceptNode2, linkDataList, nodeDataList,deleteLink);

                }

            }
            if (node.contains("Security Group")){
                // 먼저 노드 하나만 빼고 제외하기
                System.out.println("SecurityGroup : " + node);
                ExceptNode(node, nodeDataList, groupDataList, exceptNode);
                text_index =  Auto_index;
                System.out.println("SecurityGroup2 : " + node + nodeDataList + groupDataList + exceptNode);
                // 기존에 있는 그룹을 Auto Group으로 변화시키기
                GroupData newAutoGroup =  createAutoGroup(node, Auto_index, text_index,nodeDataList, groupDataList,originalprivatesubnetname);
                Auto_index += 1;
                // 일단 AutoGroup은 복사를 한다.
                GroupData CopyAutoGroup = createAutoGroup(node + "a" , Auto_index, text_index, nodeDataList, groupDataList,privateSubnetName);

                // NodeData 순환하기
                List<NodeData> newNodes = new ArrayList<>(); // 새로운 노드를 저장할 리스트
                System.out.println("newAutoGroup : " + newAutoGroup);
                System.out.println("CopyAutoGroup : " + CopyAutoGroup);
                for (NodeData nodedata : nodeDataList) {
                    if (nodedata.getGroup().equals(node)) {
                        NodeData copiedNode = new NodeData();
                        node_x += 200;
                        String newLoc = (node_x) + " " + (node_y);

                        copiedNode.setText(nodedata.getText());
                        copiedNode.setType(nodedata.getType());
                        copiedNode.setKey(nodedata.getKey() + "a");
                        copiedNode.setSource(nodedata.getSource());
                        copiedNode.setIsGroup(null);
                        copiedNode.setGroup(CopyAutoGroup.getKey());
                        copiedNode.setLoc(newLoc);
                        newNodes.add(copiedNode); // 새 노드를 별도의 리스트에 추가
                    }
                }

                nodeDataList.addAll(newNodes); // 순회가 끝난 후 새 노드들을 nodeDataList에 추가

            }

            Auto_index += 1;
        }

        Auto_index += 1;

    }



}