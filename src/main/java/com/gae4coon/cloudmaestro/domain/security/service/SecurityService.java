package com.gae4coon.cloudmaestro.domain.security.service;

import com.gae4coon.cloudmaestro.domain.requirements.dto.RequireDTO;
import com.gae4coon.cloudmaestro.domain.requirements.dto.ZoneDTO;
import com.gae4coon.cloudmaestro.domain.resource.service.AddResourceService;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.GroupData;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.LinkData;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.NodeData;
import com.gae4coon.cloudmaestro.domain.ssohost.service.DiagramDTOService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class SecurityService{

    private final DiagramDTOService diagramDTOService;
    private final AddResourceService addResourceService;

    List<NodeData> nodeDataList;
    List<GroupData> groupDataList;
    List<LinkData> linkDataList;

    // globalRequirements list service

    public void security(RequireDTO requireDTO,List<NodeData> originNodeDataList, List<GroupData> originGroupDataList, List<LinkData> originLinkDataList) {
        List<String> globalRequirements = requireDTO.getGlobalRequirements();
        List<ZoneDTO> Zones = requireDTO.getZones();

        this.nodeDataList = originNodeDataList;
        this.groupDataList = originGroupDataList;
        this.linkDataList = originLinkDataList;

        globalService(globalRequirements);
        zoneService(Zones);

//        HashMap<String, Object> response = diagramDTOService.dtoComplete(nodeDataList, groupDataList, linkDataList);

        return;
    }



    private void globalService(List<String> globalRequirements) {
        for (var global : globalRequirements) {
            switch (global) {
                case "보안":
                    setSecurity();
                    break;
                case "네트워크보호":
                    setNetworkSecure();
                    break;
                case "데이터보호":
                    setDataSecure();
                    break;
                case "iam":
                    setIAM();
                    break;
                case "securityhub":
                    setSecurityHub();
                    break;
                case "guardduty":
                    setGuardDuty();
                    break;
                case "detective":
                    setDetective();
                    break;
                case "networkfirewall":
                    setNetworkFW();
                    break;
                case "shield":
                    setShield();
                    break;
                case "secretsmanager":
                    setSecretsManager();
                    break;
                case "kms":
                    setKMS();
                    break;
            }
        }
    }

    private void setDataSecure() {
        setKMS();
        setSecretsManager();
    }

    private void setNetworkSecure() {
        setNetworkFW();
        setShield();
    }

    private void setDetect() {
        setDetective();
        setGuardDuty();
        setSecurityHub();
    }

    private void setSecurity() {
        setIAM();
        setDetect();
        setNetworkSecure();
        setDataSecure();
    }

    public void zoneService(List<ZoneDTO> Zones) {
        // Zone Requiremnts 처리
        for (ZoneDTO zone : Zones) {
            for (String zoneRequirement : zone.getZoneRequirements()) {
                switch (zoneRequirement) {
                    case "웹 방화벽으로 보호":
                        setZoneWAF(zone.getName());
                        break;
                }
            }
        }
    }

    private void setIAM() {
        if (diagramDTOService.isNodeDataContains(nodeDataList, "Identity and Access Management")) return;
        diagramDTOService.addServiceGroup(groupDataList);

        NodeData IAM = addResourceService.addIdentityandAccessManagementIAM();
        IAM.setGroup("Service");
        nodeDataList.add(IAM);
    }

    private void setSecurityHub() {
        if (diagramDTOService.isNodeDataContains(nodeDataList, "Security Hub")) return;
        diagramDTOService.addServiceGroup(groupDataList);

        NodeData SecurityHub = addResourceService.addSecurityHub();
        SecurityHub.setGroup("Service");
        nodeDataList.add(SecurityHub);
    }

    private void setGuardDuty() {
        if (diagramDTOService.isNodeDataContains(nodeDataList, "GuardDuty")) return;
        diagramDTOService.addServiceGroup(groupDataList);

        NodeData GuardDuty = addResourceService.addGuardDuty();
        GuardDuty.setGroup("Service");
        nodeDataList.add(GuardDuty);
    }

    private void setDetective() {
        if (diagramDTOService.isNodeDataContains(nodeDataList, "Detective")) return;
        diagramDTOService.addServiceGroup(groupDataList);

        NodeData Detective = addResourceService.addDetective();
        Detective.setGroup("Service");
        nodeDataList.add(Detective);
    }

    private void setNetworkFW() {
        // network firewall있으면 endpoint만 검사
        diagramDTOService.addServiceGroup(groupDataList);

        if (!diagramDTOService.isNodeDataContains(nodeDataList, "Network Firewall")) {
            // add Network Firewall into Region
            NodeData NetworkFW = addResourceService.addNetworkFirewall();
            NetworkFW.setGroup("Region");
            NetworkFW.setLoc("0 -300");
            nodeDataList.add(NetworkFW);
        }

        // create Network Firewall Group in VPC
        GroupData groupData = addResourceService.addPublicsubnet();
        groupData.setKey("Firewall Public Subnet");
        groupData.setText("Firewall Public Subnet");
        groupData.setGroup("VPC");
        groupDataList.add(groupData);

        // add Network Firewall endpoint into Firewall Public Subnet
        NodeData nodeData = addResourceService.addNetworkFirewallEndpoints();
        nodeData.setGroup("Firewall Public Subnet");
        nodeData.setLoc("200 -200");
        nodeDataList.add(nodeData);

        LinkData netFWtoendpoint = new LinkData();
        netFWtoendpoint.setFrom("Network Firewall");
        netFWtoendpoint.setTo("Network Firewall Endpoints");
        linkDataList.add(netFWtoendpoint);
    }

    private void setShield() {
        if (diagramDTOService.isNodeDataContains(nodeDataList, "Shield")) return;
        diagramDTOService.addServiceGroup(groupDataList);
        NodeData Shield = addResourceService.addShield();
        Shield.setGroup("Service");
        nodeDataList.add(Shield);
    }
    private void setSecretsManager() {
        if (diagramDTOService.isNodeDataContains(nodeDataList, "Secrets Manager")) return;
        diagramDTOService.addServiceGroup(groupDataList);

        NodeData SecretsManager = addResourceService.addSecretsManager();
        SecretsManager.setGroup("Service");
        nodeDataList.add(SecretsManager);
    }

    private void setKMS() {
        diagramDTOService.addServiceGroup(groupDataList);
        if (diagramDTOService.isNodeDataContains(nodeDataList, "Key Management Service")) return;

        NodeData KMS = addResourceService.addKeyManagementService();
        KMS.setGroup("Service");
        nodeDataList.add(KMS);
    }


    private void setZoneWAF(String zoneName) {
        // zoneName의 nestedGroup까지 확인
        Set<String> nestedGroup = new HashSet<>();


        // DEV, PROD와 같이 이름의 일부면
        if(!diagramDTOService.isGroupDataEquals(groupDataList, zoneName)){
            List<GroupData> tmp = diagramDTOService.getGroupListByText(groupDataList,zoneName);
            for (var t:tmp){
                nestedGroup.add(t.getKey());
            }
            nestedGroup.addAll(diagramDTOService.getNestedGroupListByLabel(groupDataList, zoneName));
        }
        else{
            nestedGroup.add(zoneName);
            nestedGroup.addAll(diagramDTOService.getNestedGroupList(groupDataList, zoneName));
        }

        Set<String> groupsToProcess = new HashSet<>(nestedGroup);


        while (!groupsToProcess.isEmpty()) {
            // Process each group and find its nested groups
            Set<String> newlyDiscoveredGroups = new HashSet<>();
            for (String group : groupsToProcess) {
                Set<String> currentGroupNested = diagramDTOService.getNestedGroupList(groupDataList, group);
                // Add new groups to the set for the next iteration
                for (String newGroup : currentGroupNested) {
                    if (!nestedGroup.contains(newGroup)) {
                        newlyDiscoveredGroups.add(newGroup);
                    }
                }
            }

            // Update nestedGroup and groupsToProcess for the next iteration
            nestedGroup.addAll(newlyDiscoveredGroups);
            groupsToProcess = newlyDiscoveredGroups;
        }

        // CloudFront, API Gateway에 대해
        List<String> containResource = new ArrayList<>();
        if (diagramDTOService.isNodeDataContains(nodeDataList, "CloudFront")) {
            containResource.add(diagramDTOService.getNodeDataByText(nodeDataList, "CloudFront").getKey());
        }
        if (diagramDTOService.isNodeDataContains(nodeDataList, "API Gateway")) {
            containResource.add(diagramDTOService.getNodeDataByText(nodeDataList, "API Gateway").getKey());
        }
        if (containResource.isEmpty()) return;

        // 다이어그램에 WAF 없으면 예외처리
        if (!diagramDTOService.isNodeDataContains(nodeDataList, "AWS_WAF")) {
            NodeData WAF = addResourceService.addAWS_WAF();
            WAF.setGroup("Region");
            WAF.setLoc("0 200");
            nodeDataList.add(WAF);
        }

        for (var resource : containResource) {
            // 이미 링크되어있는 경우 예외처리
            if(diagramDTOService.isLink(linkDataList, "AWS_WAF", resource)) continue;

            LinkData WAFtoResource = new LinkData();
            WAFtoResource.setFrom("AWS_WAF");
            WAFtoResource.setTo(resource);
            linkDataList.add(WAFtoResource);
        }

        Set<NodeData> zoneConnectedALB = new HashSet<>();
        List<NodeData> ALBList = diagramDTOService.getNodeListByText(nodeDataList, "Application Load Balancer (ALB)");

        if (ALBList.isEmpty()) return;

        // ALB 노드 모음
        for (NodeData alb : ALBList) {

            // ALB가 아니면 continue
            List<LinkData> ALBLinkList = diagramDTOService.getLinkDataListByFrom(linkDataList, alb.getKey());
            if (ALBLinkList == null) continue;

            for(LinkData ALBLink : ALBLinkList) {
                System.out.println("alb" + ALBLink);

                // ALB와 연결된 from 데이터의 group확인
                NodeData ALBToNode = diagramDTOService.getNodeDataByKey(nodeDataList, ALBLink.getTo());
                if (ALBToNode != null) {
                    String group = ALBToNode.getGroup();
                    // 해당 망이 ALB와 연결되지 않았음
                    if (!nestedGroup.contains(group)) continue;
                }

                GroupData ALBToGroup = diagramDTOService.getGroupDataByKey(groupDataList, ALBLink.getTo());
                if (ALBToGroup != null) {
                    String group = ALBToGroup.getGroup();
                    // 해당 망이 ALB와 연결되지 않았음
                    System.out.println(nestedGroup + " " + group + " " + nestedGroup.contains(group));
                    if (!nestedGroup.contains(group)) continue;
                }
                zoneConnectedALB.add(alb);
            }
        }

        // 다이어그램에 WAF 없으면 생성
        if (!diagramDTOService.isNodeDataContains(nodeDataList, "AWS_WAF")) {
            NodeData WAF = addResourceService.addAWS_WAF();
            WAF.setGroup("Region");
            WAF.setLoc("0 -200");
            nodeDataList.add(WAF);
        }

        // ALB마다 WAF 연결
        for (NodeData alb : zoneConnectedALB) {
            LinkData WAFtoResource = new LinkData();
            WAFtoResource.setFrom("AWS_WAF");
            WAFtoResource.setTo(alb.getKey());
            linkDataList.add(WAFtoResource);
        }
    }
}

