package com.gae4coon.cloudmaestro.domain.rehost.service.impl;


import com.gae4coon.cloudmaestro.domain.rehost.dto.GroupData;
import com.gae4coon.cloudmaestro.domain.rehost.dto.NodeData;
import com.gae4coon.cloudmaestro.domain.rehost.service.StandardServiceInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StandardSerivceImpl implements StandardServiceInterface {


    // network를 group 별로 분리
    @Override
    public Map<String, Object> processNodeData(List<NodeData> data) {
        Map<String, List<NodeData>> groupedData = new HashMap<>();

        for (NodeData item : data) {
            String group = item.getGroup();
            if (group != null) {
                groupedData
                        .computeIfAbsent(group, k -> new ArrayList<>())
                        .add(item);
            }
        }

        System.out.println("groupeddata"+groupedData);

        Map<String, Object> result = new HashMap<>();
        List<Object> nodeDataArray = new ArrayList<>();
        int count = 1;

        for (String key : groupedData.keySet()) {


            GroupData groupNode = new GroupData();
            groupNode.setIsGroup(true);
            groupNode.setKey("Virtual private cloud (VPC)" + count);
            groupNode.setStroke("rgba(0,0,198,0.3)");
            groupNode.setType("group");


            nodeDataArray.add(groupNode); // GroupData 객체를 리스트에 추가

            List<NodeData> groupList = groupedData.get(key);
            for (NodeData node : groupList) {
                node.setGroup("Virtual private cloud (VPC)" + count);
                NetToAws(node);
                node.setFigure("Rectangle");
                nodeDataArray.add(node);
            }

            count++;
        }

        result.put("nodeDataArray", nodeDataArray);

        System.out.println("nodeDataArray"+nodeDataArray);

        return result;
    }


    @Override
    public void NetToAws(NodeData node) {
        String networkKey = node.getKey();
        String networkText = node.getText();
        // getText()가 null을 반환하는 경우의 예외 처리
        if (networkText == null) {
            // 로깅 또는 다른 오류 처리를 이 부분에 추가할 수 있습니다.
            networkText = networkKey;
        }
        String imagePath = "";
        String typePath = "";
        networkKey = NetToAws(networkKey, networkText);
        node.setText(networkKey);
        switch (networkKey) {
            case "EC2":
                imagePath = "/img/AWS_icon/Arch_Compute/Arch_Amazon-EC2_48.svg";
                typePath = "Arch_Compute";
                node.setSource(imagePath);
                node.setType(typePath);
                break;
            case "Shield":
                imagePath = "/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_AWS-Shield_48.svg";
                typePath = "Arch_Security-Identity-Compliance";
                node.setSource(imagePath);
                node.setType(typePath);
                break;

            case "CloudTrail":
                imagePath = "/img/AWS_icon/Arch_Management-Governance/Arch_AWS-CloudTrail_48.svg";
                typePath = "Arch_Management-Governance";
                node.setSource(imagePath);
                node.setType(typePath);
                break;

            case "RDS":
                imagePath = "/img/AWS_icon/Arch_Database/Arch_Amazon-RDS_48.svg";
                typePath = "Arch_Database";
                node.setSource(imagePath);
                node.setType(typePath);
                break;
        }


    }


    @Override
    public String NetToAws(String nodeKey, String nodeText) {
        if (nodeKey.contains("WS") || nodeKey.contains("SVR")) {
            nodeKey = "EC2";
            return nodeKey;
        }
        if (nodeKey.contains("DB")) {
            nodeKey = "RDS";
            return nodeKey;
        }

        if (nodeKey.contains("AD")) {
            nodeKey = "Shield";
            return nodeKey;
        }
        if (nodeKey.contains("IDS") || nodeKey.contains("IPS")) {
            nodeKey = "CloudTrail";
            return nodeKey;
        } else {
            return nodeText;
        }
    }

    @Override
    public Map<String, Object> processKeyData(Map<String, Object> nodesData) {

        // nodeData -> List<Object>
        List<NodeData> nodesList = new ArrayList<>();
        List<Object> nodeDataArray = (List<Object>) nodesData.get("nodeDataArray");

        for (Object obj : nodeDataArray) {
            if (obj instanceof NodeData) {  // NodeData 인스턴스만 처리
                nodesList.add((NodeData) obj);
            } else if (obj instanceof HashMap) { // HashMap을 NodeData로 변환
                HashMap<String, Object> hashMap = (HashMap<String, Object>) obj;
                NodeData nodeData = new NodeData();

                // 예를 들면, 아래와 같이 데이터를 설정할 수 있습니다.
                // 단, NodeData의 모든 속성에 대해 적절한 데이터를 설정해야 합니다.
                // 이 예제는 key와 group만 예시로 사용하였습니다.
                // 실제 NodeData의 모든 필드와 hashMap의 키 값을 확인하여 적절히 매핑해주세요.
                nodeData.setKey((String) hashMap.get("key"));
                nodeData.setGroup((String) hashMap.get("group"));
                // ... 다른 필드들도 설정 ...

                nodesList.add(nodeData);
            }
        }

        // 키별로 NodeData를 그룹화
        Map<String, List<NodeData>> groupedNodes = nodesList.stream()
                .collect(Collectors.groupingBy(NodeData::getKey));

        for (String key : groupedNodes.keySet()) {
            List<NodeData> nodeList = groupedNodes.get(key);
            if (nodeList.size() > 1) {
                for (int i = 0; i < nodeList.size(); i++) {
                    nodeList.get(i).setKey(key + i);
                }
            }
        }

        // 결과를 Map<String, Object>로 변환하여 반환
        Map<String, Object> result = new HashMap<>();
        result.put("groupedNodes", groupedNodes);

        return result;
    }
}
