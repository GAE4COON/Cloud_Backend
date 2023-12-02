package com.gae4coon.cloudmaestro.domain.ssohost.service.impl;

import com.gae4coon.cloudmaestro.domain.ssohost.dto.GroupData;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.LinkData;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.NodeData;
import com.gae4coon.cloudmaestro.domain.ssohost.service.ModifyLink;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ModifyLinkImpl implements ModifyLink {

    @Override
    public Map<List<GroupData>, List<NodeData>> excludeNode(List<NodeData> nodeDataList, List<GroupData> groupDataList, List<LinkData> linkDataList) {

        for(LinkData link: linkDataList){
            String rootTo = link.getTo();
            if(isExclude(rootTo)){
                String normalTo = findNormalNode(rootTo, linkDataList);
                link.setTo(normalTo);
            }
        }

        unique(linkDataList);

        Map<List<GroupData>, List<NodeData>> resultMap = new HashMap<>();
        resultMap.put(groupDataList, nodeDataList);

        return resultMap;

    }

    private String findNormalNode(String from, List<LinkData> linkDataList){
        String destination = from;

        for(LinkData link: linkDataList){
            if(link.getFrom().equals(destination)) {
                if (isExclude(link.getTo())){
                    return findNormalNode(link.getTo(), linkDataList);
                } else {
                    return link.getTo();
                }
            }
        }
        return destination;
    }


    private Boolean isExclude(String node){
        List<String> exclude = new ArrayList<>(Arrays.asList("Anti DDoS","IPS", "IDS", "Firewall"));

        for (String excludeItem : exclude) {
            if (node.contains(excludeItem)){
                return true;
            }
        }
        return false;
    }

    private List<LinkData> unique(List<LinkData> originalList) {
        Set<LinkData> linkDataSet = new HashSet<>();
        for (LinkData link1 : originalList) {
            linkDataSet.add(link1);
        }

        List<LinkData> setlist = new ArrayList<>();
        for (LinkData l : linkDataSet) {
            setlist.add(l);
        }
        return setlist;
    }

    @Override
    public Map<List<NodeData>,List<LinkData>> deleteNode(List<NodeData> nodeDataList, List<LinkData> linkDataList){
        List<NodeData> tmpNodeDataList = new ArrayList<>(nodeDataList);
        Iterator<NodeData> iterator = tmpNodeDataList.iterator();

        List<LinkData> tmpLinkDataList = new ArrayList<>(linkDataList);


        while(iterator.hasNext()){
            NodeData node = iterator.next();
            if(!isExclude(node.getKey())) continue;

            // linkDataList에서 node가 포함된 링크 전부 delete (from/to 상관없음)
            linkDataList = deleteExcludeLink(node.getKey(), tmpLinkDataList);

            // replace node (ips, ids)가 아니면 nodeData에서도 삭제
            if(!isReplace(node.getKey())){
                iterator.remove();
            }
        }


        Map<List<NodeData>, List<LinkData>> resultMap = new HashMap<>();
        resultMap.put(tmpNodeDataList, tmpLinkDataList);

        return resultMap;
    }

    private List<LinkData> deleteExcludeLink(String node, List<LinkData> linkDataList){
        Iterator<LinkData> iterator = linkDataList.iterator();

        while(iterator.hasNext()){
            LinkData link = iterator.next();
            if(link.getTo().equals(node) || link.getFrom().equals(node)){
                iterator.remove();
            }
        }

        return linkDataList;
    }


    private Boolean isReplace(String node){
        List<String> replace = new ArrayList<>(Arrays.asList("IPS", "IDS", "Anti DDoS"));

        for (String replaceNode : replace) {
            if (node.contains(replaceNode)){
                return true;
            }
        }
        return false;
    }


}
