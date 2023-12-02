package com.gae4coon.cloudmaestro.domain.ssohost.service;

import com.gae4coon.cloudmaestro.domain.ssohost.dto.GroupData;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.NodeData;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.LinkData;
import io.swagger.v3.oas.models.links.Link;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface NetworkToAWS {
    void changeNodeSource (List<NodeData> nodeDataList);
    void changeGroupSource (List<NodeData> nodeDataList, List<GroupData> groupDataList);
    void changeLinkSource (List<LinkData> linkDataList);
    void changeAll (List<NodeData> nodeDataList, List<GroupData> groupDataList, List<LinkData> linkDataList);

    void changeAll2(List<NodeData> nodeDataList, List<GroupData> groupDataList, List<LinkData> linkDataList);

    void setRegionAndVpcData(List<NodeData> nodeDataList, List<GroupData> groupDataList, List<LinkData> linkDataList);

    void addNetwork(List<NodeData> nodeDataList, List<GroupData> groupDataList, List<LinkData> linkDataList);

    void setNodeLocation(List<NodeData> nodeDataList, List<GroupData> groupDataList, List<LinkData> linkDataList);

    void deleteServiceDuplicatedNode(List<NodeData> nodeDataList);

    //void setNodeLocation(List<NodeData> nodeDataList, List<GroupData> groupDataList, List<LinkData> linkDataList);
}
