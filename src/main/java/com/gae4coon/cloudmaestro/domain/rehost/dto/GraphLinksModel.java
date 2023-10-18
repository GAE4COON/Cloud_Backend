package com.gae4coon.cloudmaestro.domain.rehost.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GraphLinksModel {
    @JsonProperty("class")
    private String className;
    private String linkKeyProperty;
    private List<NodeData> nodeDataArray;
    private List<LinkData> linkDataArray;
    @JsonProperty("ec2")
    private Ec2 ec2;
    // getters and setters
}

