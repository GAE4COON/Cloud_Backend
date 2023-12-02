package com.gae4coon.cloudmaestro.domain.ssohost.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gae4coon.cloudmaestro.domain.file.service.S3Service;
import com.gae4coon.cloudmaestro.domain.mypage.service.NetworkService;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.*;
import com.gae4coon.cloudmaestro.domain.ssohost.service.DiagramDTOService;
import com.gae4coon.cloudmaestro.domain.ssohost.service.ModifyLink;
import com.gae4coon.cloudmaestro.domain.ssohost.service.NetworkToAWS;
import com.gae4coon.cloudmaestro.domain.ssohost.service.SecurityGroupService;
import com.gae4coon.cloudmaestro.domain.user.entity.Member;
import com.gae4coon.cloudmaestro.domain.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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
    private final S3Service s3Service;
    private final NetworkService networkService;
    private final MemberRepository memberRepository;
    private final DiagramDTOService diagramDtoService;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @PostMapping("/ssohost")
    public ResponseEntity<HashMap<String, Object>> postNetworkData(@RequestBody(required = false) String postData) {
        System.out.println(postData);

        // put s3
        String fileName = "NetworkData_" + System.currentTimeMillis() + ".json";
//        s3Service.uploadS3File(fileName, postData);

//       임시 할당
        Member member = Member.builder()
                .userId(String.valueOf("1"))
                .userPw("null")
                .userName("null")
                .belong("null")
                .phoneNumber("null")
                .email("null")
                .role(Member.UserRole.valueOf("member"))
                .build();

//        memberRepository.save(member);
//       임시 할당


        // put network
//        networkService.addNetwork(member, fileName, null);

        // 파일 저장
        try {
            ObjectMapper mapper = new ObjectMapper();
            GraphLinksModel model = mapper.readValue(postData, GraphLinksModel.class);

            Map<String, Object> responseArray = diagramDtoService.dtoGenerator(model);
            List<NodeData> nodeDataList = (List<NodeData>) responseArray.get("nodeDataArray");
            List<GroupData> groupDataList = (List<GroupData>) responseArray.get("groupDataArray");
            List<LinkData> linkDataList = (List<LinkData>) responseArray.get("linkDataArray");
            Map<String, Object> cost = (Map<String, Object>) responseArray.get("cost");



            securityGroupService.addSecurityGroup(nodeDataList, groupDataList, linkDataList);
            securityGroupService.modifySecurityGroupLink(nodeDataList, groupDataList, unique(linkDataList));
            modifyLink.excludeNode(nodeDataList, groupDataList, unique(linkDataList));
            Map<List<NodeData>, List<LinkData>> tmpData = modifyLink.deleteNode(nodeDataList, unique(linkDataList));

            nodeDataList.clear();
            linkDataList.clear();

            for (Map.Entry<List<NodeData>, List<LinkData>> entry : tmpData.entrySet()) {
                nodeDataList.addAll(entry.getKey());
                linkDataList.addAll(entry.getValue());
            }

            // node, group, link 정보 변경 (network node to aws)
            //networkToAWS.changeAll(nodeDataList, groupDataList, linkDataList);

            //node, group, link 정보 변경 (network node to aws)

            networkToAWS.changeAll2(nodeDataList, groupDataList, linkDataList);

            networkToAWS.addNetwork(nodeDataList, groupDataList, linkDataList);

            // Region, vpc, available zone 넣기
            networkToAWS.setRegionAndVpcData(nodeDataList, groupDataList, linkDataList);

            // 위치 정보 수정 ,,, ,하하
            networkToAWS.setNodeLocation(nodeDataList, groupDataList,linkDataList);

            // 서비스 노드 중복 잡기
            networkToAWS.deleteServiceDuplicatedNode(nodeDataList);

            System.out.println("SetRegion and VPC Data : " + nodeDataList);


            GroupData groupData = new GroupData();
            groupData.setKey("Service");
            groupData.setText("Service");
            groupData.setStroke("rgb(158, 224, 255)");

            groupDataList.add(groupData);

            HashMap<String, Object> response = diagramDtoService.dtoComplete(nodeDataList, groupDataList, unique(linkDataList), cost);
            System.out.println("response"+ response);

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