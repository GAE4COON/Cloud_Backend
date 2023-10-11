package com.example.EC2.domain.controller;

import com.example.EC2.domain.dto.ApiNameRequest;
import com.example.EC2.domain.dto.MemberDTO;

import com.example.EC2.domain.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ec2")
@CrossOrigin(origins="http://localhost:3000")
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    private MemberService memberService;



    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/all")
    public List<MemberDTO> getAllMembers() {
        List<MemberDTO> members = memberService.getAllMembers();
        logger.info("Fetched members: {}", members);
        return members;
    }

    public List<MemberDTO> getMembersByAPIName(@PathVariable("APIName") String APIName) {
        List<MemberDTO> members = memberService.getMembersByAPIName(APIName);
        logger.info("Fetched members by name '{}': {}", APIName, members);
        return members;
    }


    @PostMapping(value = "/apiname", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getMembersByAPIName(@RequestBody ApiNameRequest request) {
        List<String> splitAPIname = null;
        logger.info("hello world '{}': {}", request.getPlatform(), request.getInstanceType());
        if(request.getInstanceType() == null) {
            // Only platform provided
            splitAPIname = memberService.getSplitByAPIName(request.getPlatform());
            logger.info("Fetched members by platform '{}': {}", request.getPlatform(), splitAPIname);
        } else {
            splitAPIname = memberService.getSplitByAPINameAndInstanceType(request.getPlatform(), request.getInstanceType());
            logger.info("Fetched members by instance '{}': {}", request.getInstanceType(), splitAPIname);
        }



        return splitAPIname;
    }


}
