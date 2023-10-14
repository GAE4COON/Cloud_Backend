package com.gae4coon.cloudmaestro.domain.standard.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gae4coon.cloudmaestro.domain.standard.dto.GraphLinksModel;
import com.gae4coon.cloudmaestro.domain.standard.dto.LinkData;
import com.gae4coon.cloudmaestro.domain.standard.dto.NodeData;
import com.gae4coon.cloudmaestro.domain.standard.service.AlgorithmServiceInterface;
import com.gae4coon.cloudmaestro.domain.standard.service.StandardServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/file-api/")

public class StandardController {

    private static final Logger logger = LoggerFactory.getLogger(com.gae4coon.cloudmaestro.domain.standard.controller.StandardController.class);
    private final StandardServiceInterface standardService;
    private final AlgorithmServiceInterface algorithmService;

    @Autowired
    public StandardController(StandardServiceInterface standardService, AlgorithmServiceInterface algorithmService) {
        this.standardService = standardService;
        this.algorithmService = algorithmService;
    }



//    @PostMapping("/ec2")
//    public ResponseEntity<?> postMember (@RequestBody Map<String, Object> postData){
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            StringBuilder sb = new StringBuilder();
//            postData.entrySet().forEach(map -> {
//                String key = map.getKey();
//                String value = map.getValue();
//
//            });
//
//            return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
//        } catch (Exception e) {
//
//            ObjectNode errorNode = mapper.createObjectNode();
//            errorNode.put("error", e.getMessage());
//
//            return new ResponseEntity<>(errorNode, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }



    @PostMapping("/network")
    public ResponseEntity<HashMap<String, Object> > postNetworkData(@RequestBody(required = false) String postData) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println("postData: "+postData);
            GraphLinksModel graphData = mapper.readValue(postData, GraphLinksModel.class);
            List<NodeData> nodes = graphData.getNodeDataArray();
            List<LinkData> linkData = graphData.getLinkDataArray();


            // 정말 단순한 일대일 대응
            Map<String, Object> nodesData =  standardService.processNodeData(nodes);

            Map<String, Object> finalData = algorithmService.algorithmDataList(nodesData, linkData);

            Map<String, Object> responseBody = new HashMap<>();

            responseBody.put("class","GraphLinksModel");
            responseBody.put("linkKeyProperty","key");
            responseBody.put("nodeDataArray",finalData.get("nodeDataArray"));
            responseBody.put("linkDataArray", finalData.get("linkDataArray"));
            //responseBody.put("addGroupList", finalData.get("addGroupList"))

            HashMap<String, Object> finalBody = new HashMap<>();
            finalBody.put("result",responseBody);
            System.out.println("finalBody: "+finalBody);

            return ResponseEntity.ok().body(finalBody);

        } catch (Exception e) {
            ObjectNode errorNode = mapper.createObjectNode();
            errorNode.put("error", e.getMessage());
            System.out.println("error:"+ e.getMessage());

            HashMap<String, Object> ErrorBody = new HashMap<>();
            ErrorBody.put("result","fail");
            return ResponseEntity.ok().body(ErrorBody);
        }
    }


}



