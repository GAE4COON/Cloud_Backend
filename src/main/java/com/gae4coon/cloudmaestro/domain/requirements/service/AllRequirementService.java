package com.gae4coon.cloudmaestro.domain.requirements.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gae4coon.cloudmaestro.domain.available.service.AvailableService;
import com.gae4coon.cloudmaestro.domain.logging.service.LoggingService;
import com.gae4coon.cloudmaestro.domain.refactor.service.BackupService;
import com.gae4coon.cloudmaestro.domain.requirements.dto.RequireDTO;
import com.gae4coon.cloudmaestro.domain.requirements.dto.RequireDiagramDTO;
import com.gae4coon.cloudmaestro.domain.requirements.dto.ZoneDTO;
import com.gae4coon.cloudmaestro.domain.resource.service.AddResourceService;
import com.gae4coon.cloudmaestro.domain.security.service.SecurityService;
import com.gae4coon.cloudmaestro.domain.naindae.service.DnsMultiService;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.GraphLinksModel;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.GroupData;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.LinkData;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.NodeData;
import com.gae4coon.cloudmaestro.domain.ssohost.service.DiagramDTOService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AllRequirementService {

    private final DiagramDTOService diagramDTOService;
    private final SecurityService securityService;
    private final LoggingService loggingService;
    private final AvailableService availableService;
    private final BackupService backupService;
    private final DnsMultiService dnsMultiService;
    public HashMap<String, Object> requirement(RequireDiagramDTO requireDiagramDTO) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        GraphLinksModel diagramData = mapper.readValue(requireDiagramDTO.getDiagramData(), GraphLinksModel.class);
        RequireDTO requirementData = requireDiagramDTO.getRequirementData();

        System.out.println("requirement: " + requirementData);
        System.out.println("diagramData:"+diagramData);

        // diagramData formatter
        Map<String, Object> responseArray = diagramDTOService.dtoGenerator(diagramData);

        List<NodeData> nodeDataList = (List<NodeData>) responseArray.get("nodeDataArray");
        List<GroupData> groupDataList = (List<GroupData>) responseArray.get("groupDataArray");
        List<LinkData> linkDataList = (List<LinkData>) responseArray.get("linkDataArray");


        securityService.security(requirementData, nodeDataList, groupDataList, linkDataList);
        loggingService.logging(requirementData, nodeDataList, groupDataList, linkDataList);

        backupService.requirementParsing(requireDiagramDTO, nodeDataList, linkDataList, groupDataList);
        dnsMultiService.getRequirementDns(requireDiagramDTO, nodeDataList, linkDataList, groupDataList);

        //HashMap<String, Object> available = availableService.availalbeService(requirementData.getZones(),responseArray);




        HashMap<String, Object> response = diagramDTOService.dtoComplete(nodeDataList, groupDataList, linkDataList);


        return response;
    }
}