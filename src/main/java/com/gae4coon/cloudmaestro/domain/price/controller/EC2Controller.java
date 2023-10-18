package com.gae4coon.cloudmaestro.domain.price.controller;

import com.gae4coon.cloudmaestro.domain.price.dto.requestPrice;
import com.gae4coon.cloudmaestro.domain.price.service.EC2Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gae4coon.cloudmaestro.domain.price.dto.rdsCostRequest;
import com.gae4coon.cloudmaestro.domain.price.service.NodeService;
import com.gae4coon.cloudmaestro.domain.price.service.rdsCostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pricing-api")
public class EC2Controller {
    private final EC2Service ec2Service;
    private final Logger logger = LoggerFactory.getLogger(EC2Controller.class);
    @Autowired
    public EC2Controller(EC2Service ec2Service) {
        this.ec2Service = ec2Service;
    }

    @PostMapping("/ec2")
    public ResponseEntity<JsonNode> getVantagePricing(@RequestBody requestPrice request){


        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode response = ec2Service.getVantagePricing(request.getPlatform(), request.getInstance(), request.getLifeCycle());
            //logger.info("price",response);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {

            ObjectNode errorNode = mapper.createObjectNode();
            errorNode.put("error", e.getMessage());

            return new ResponseEntity<>(errorNode, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Autowired
    private rdsCostService rdsPricingService;

    @PostMapping("/rds")
    public ResponseEntity<String> handleRdsRequest(@RequestBody rdsCostRequest request) throws Exception {
        //System.out.println("Received dbEngine: " + request.getDbEngine()+"\nReceived instanceType: " + request.getInstanceType());

        String dbPrice = rdsPricingService.getRdsAwsPricing(request.getDbEngine(), request.getInstanceType());

        return new ResponseEntity<>(dbPrice, HttpStatus.OK);
    }


}
