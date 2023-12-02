package com.gae4coon.cloudmaestro.domain.ssohost.service;

import com.gae4coon.cloudmaestro.domain.ssohost.dto.GroupData;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.LinkData;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.NodeData;

import java.util.List;
import java.util.Map;

public interface ModifyLink {
    Map<List<GroupData>,List<NodeData>> excludeNode(List<NodeData> nodeDataList, List<GroupData> groupDataList, List<LinkData> linkDataList);
    Map<List<NodeData>,List<LinkData>> deleteNode(List<NodeData> nodeDataList, List<LinkData> linkDataList);

}
