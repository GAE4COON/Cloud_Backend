package com.gae4coon.cloudmaestro.domain.ssohost.service;

import com.gae4coon.cloudmaestro.domain.ssohost.dto.GroupData;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.NodeData;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.LinkData;

import java.util.List;
import java.util.Map;

public interface SecurityGroupService {
    void addSecurityGroup(List<NodeData> nodeDataList, List<GroupData> groupDataList, List<LinkData> linkDataList);
    void modifySecurityGroupLink(List<NodeData> nodeDataList, List<GroupData> groupDataList, List<LinkData> linkDataList);


    void addEc2Group(List<NodeData> nodeDataList, List<GroupData> groupDataList, List<LinkData> linkDataList);
}