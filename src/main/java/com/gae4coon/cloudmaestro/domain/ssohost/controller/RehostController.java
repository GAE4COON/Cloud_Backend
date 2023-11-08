package com.gae4coon.cloudmaestro.domain.ssohost.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.*;
import com.gae4coon.cloudmaestro.domain.ssohost.service.ModifyLink;
import com.gae4coon.cloudmaestro.domain.ssohost.service.NetworkToAWS;
import com.gae4coon.cloudmaestro.domain.ssohost.service.SecurityGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/v1/file-api/rehost")
@RequiredArgsConstructor
public class RehostController {
    private final SecurityGroupService securityGroupService;
    private final ModifyLink modifyLink;
    private final NetworkToAWS networkToAWS;

    @PostMapping("/ssohost")
    public ResponseEntity<HashMap<String, Object>> postNetworkData(@RequestBody(required = false) String postData) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            GraphLinksModel model = mapper.readValue(postData, GraphLinksModel.class);

            if (model == null) return null;

            List<NodeData> dataArray = model.getNodeDataArray();
            List<NodeData> nodeDataList = new ArrayList<>();
            List<GroupData> groupDataList = new ArrayList<>();

            List<LinkData> linkDataList = model.getLinkDataArray();

            for (NodeData data : dataArray) {
                if (data.getIsGroup() != null) {
                    GroupData groupData = new GroupData(data.getKey(), data.getText(), data.getIsGroup(), data.getGroup(), data.getType(), data.getStroke());
                    groupDataList.add(groupData);
                } else {
                    nodeDataList.add(data);
                }
            }

            securityGroupService.addSecurityGroup(nodeDataList, groupDataList, linkDataList);
            linkDataList = unique(linkDataList);

            securityGroupService.modifySecurityGroupLink(nodeDataList, groupDataList, linkDataList);
            linkDataList = unique(linkDataList);

            modifyLink.excludeNode(nodeDataList, groupDataList, linkDataList);
            linkDataList = unique(linkDataList);

            Map<List<NodeData>, List<LinkData>> tmpData = modifyLink.deleteNode(nodeDataList, linkDataList);
            nodeDataList.clear();
            linkDataList.clear();
            for (Map.Entry<List<NodeData>, List<LinkData>> entry : tmpData.entrySet()) {
                nodeDataList.addAll(entry.getKey());
                linkDataList.addAll(entry.getValue());
            }
            linkDataList = unique(linkDataList);



            // node, group, link 정보 변경 (network node to aws)
            //networkToAWS.changeAll(nodeDataList, groupDataList, linkDataList);

            //node, group, link 정보 변경 (network node to aws)

            networkToAWS.changeAll2(nodeDataList, groupDataList, linkDataList);

            // Region, vpc, available zone 넣기
            networkToAWS.setRegionAndVpcData(nodeDataList, groupDataList, linkDataList);

            networkToAWS.addNetwork(nodeDataList, groupDataList, linkDataList);

            System.out.println("------------final--------------");
            System.out.println("nodeDataList " + nodeDataList);
            System.out.println("groupDataList " + groupDataList);
            System.out.println("linkDataList " + linkDataList);

            Map<String, Object> responseBody = new HashMap<>();

            List<Object> finalDataArray = new ArrayList<>();
            finalDataArray.addAll(nodeDataList);
            finalDataArray.addAll(groupDataList);

            finalDataArray.removeIf(Objects::isNull);

            responseBody.put("class", "GraphLinksModel");
            responseBody.put("linkKeyProperty", "key");
            responseBody.put("nodeDataArray", finalDataArray);  // 예시
            responseBody.put("linkDataArray", linkDataList);  // 예시

            HashMap<String, Object> response = new HashMap<>();

            response.put("result", responseBody);
            System.out.println("response: "+response);

            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            System.out.println("error" + e);
            return null;
        }

    }

    public List<LinkData> unique(List<LinkData> originalList) {
        Set<LinkData> linkDataSet = new HashSet<>();
        for (LinkData link1 : originalList) {
            linkDataSet.add(link1);
        }

        List<LinkData> setlist = new ArrayList<>();
        for (LinkData l : linkDataSet) {
            setlist.add(l);
        }
        return setlist;
    }

}