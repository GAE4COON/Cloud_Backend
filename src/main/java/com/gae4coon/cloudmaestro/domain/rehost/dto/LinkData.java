package com.gae4coon.cloudmaestro.domain.rehost.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LinkData {
    private String from;
    private String to;
    private int key;
    @JsonIgnore
    private String group;
    @JsonIgnore
    private String vpcgroup;
    public LinkData(String from, String to, String vpcgroup, int key) {
        this.from = from;
        this.to = to;
        this.vpcgroup = vpcgroup;
        this.key = key;
    }
    public LinkData(String from, String to, int key) {
        this.from = from;
        this.to = to;
        this.key = key;
    }
    public LinkData(LinkData original) {  // 복제 생성자
        this.from = original.from;
        this.to = original.to;
        this.vpcgroup = original.vpcgroup;
        this.group = original.group;
        this.key = original.key;
    }


    // getters and setters
}

