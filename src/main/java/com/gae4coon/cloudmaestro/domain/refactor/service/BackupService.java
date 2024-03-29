package com.gae4coon.cloudmaestro.domain.refactor.service;
import java.awt.geom.Point2D;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gae4coon.cloudmaestro.domain.alert.service.AlertGroupService;
import com.gae4coon.cloudmaestro.domain.refactor.entity.BpModule;
import com.gae4coon.cloudmaestro.domain.refactor.repository.ModuleRepository;
import com.gae4coon.cloudmaestro.domain.requirements.dto.RequireDTO;
import com.gae4coon.cloudmaestro.domain.requirements.dto.RequireDiagramDTO;
import com.gae4coon.cloudmaestro.domain.requirements.dto.ZoneDTO;
import com.gae4coon.cloudmaestro.domain.resource.service.AddResourceService;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.GroupData;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.LinkData;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.NodeData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.Region;

@Service
@RequiredArgsConstructor
public class BackupService {

    private final BPService bpService;
    private final AddResourceService addResourceService;
    private final AlertGroupService alertGroupService;

    public Map<String, Object> requirementParsing(RequireDiagramDTO requireDiagramDTO, List<NodeData> nodeDataList, List<LinkData> linkDataList, List<GroupData> groupDataList){


//        List<String> centralManage= new ArrayList<>();
//        List<String> generalManage= new ArrayList<>();
//        GroupData newGroup;

        if(requireDiagramDTO.getRequirementData().getBackup().size()!= 0){
            if(requireDiagramDTO.getRequirementData().getBackup().contains("중앙관리")){
                centralBackup(nodeDataList,linkDataList, groupDataList);
            };
            if(requireDiagramDTO.getRequirementData().getBackup().contains("일반")){
                generalBackup(nodeDataList, groupDataList);
            };
        }

        int cnt = 0;
        System.out.println(requireDiagramDTO.getRequirementData().getZones());
        for (ZoneDTO zone: requireDiagramDTO.getRequirementData().getZones()) {
            if(zone.getFunction()!=null){
                bpService.bpsearch(zone.getFunction(), nodeDataList, linkDataList, groupDataList, cnt);
            }
            cnt += 1;
        }


        List<Object> finalDataArray = new ArrayList<>();
        finalDataArray.addAll(nodeDataList);
        finalDataArray.addAll(groupDataList);

        Map<String, Object> responseBody = new HashMap<>();

        responseBody.put("class", "GraphLinksModel");
        responseBody.put("linkKeyProperty", "key");
        responseBody.put("nodeDataArray", finalDataArray);  // 예시
        responseBody.put("linkDataArray", linkDataList);  // 예시

        return responseBody;


    }

    public Point2D selectLocation (List<NodeData> nodeDataList, List<GroupData> groupDataList, List<GroupData> regionList){
        GroupData mainRegion = regionList.get(0);
        Set<String> regionTemp = new HashSet<>();

        regionTemp.add(mainRegion.getKey());

        for (GroupData grd: groupDataList) {
            if(mainRegion.getKey() == grd.getGroup()){
                regionTemp.add(grd.getKey());
            }
        }

        for (GroupData grd: groupDataList) {
            if(regionTemp.contains(grd.getGroup())){
                regionTemp.add(grd.getKey());
            }
        }

        for (GroupData grd: groupDataList) {
            if(regionTemp.contains(grd.getGroup())){
                regionTemp.add(grd.getKey());
            }
        }

        for (GroupData grd: groupDataList) {
            if(regionTemp.contains(grd.getGroup())){
                regionTemp.add(grd.getKey());
            }
        }

        System.out.println("regionTemp: "+regionTemp);

        double maxY = Double.MIN_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;

        for (NodeData item: nodeDataList) {
            if(regionTemp.contains(item.getGroup())) {
                if (item.getLoc() != null) {
                    String location = item.getLoc();

                    if (location.equals("loc")) {
                        continue;
                    }

                    System.out.println("location: " + item.getKey() + ", " + location);
                    System.out.println("minY, maxY, maxX: " + minY + ", " + maxY+ ", " +maxX);
                    String[] locParts = location.split(" ");

                    try {
                        double x = Double.parseDouble(locParts[0]);
                        double y = Double.parseDouble(locParts[1]);

                        if (x < -100000 || x > 100000) continue;

                        if (y > maxY) {
                            maxY = y;
                        }
                        if (y < minY) {
                            minY = y;
                        }
                        if (x > maxX) {
                            maxX = x;
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid location format for NodeData with key: " + item.getKey()+", "+item.getLoc());
                        continue; // Skip this iteration if parsing fails
                    }
                }
            }
        }


        return new Point2D.Double(maxX, (maxY+minY)/2);
    }

    public GroupData addRegionGroup (List<GroupData> groupDataList){

        int number=0;


        for (GroupData groupitem : groupDataList) {
            if(groupitem.getKey().contains("Region")){

                Pattern pattern = Pattern.compile("Region(\\d*)");
                Matcher matcher = pattern.matcher(groupitem.getKey());
                if (matcher.find()) {
                    String numberStr = matcher.group(1); // Region 다음의 숫자 부분
                    int tempnum = 1; // 기본값을 1로 설정

                    // 숫자가 있으면 그 숫자를 사용, 없으면 기본값 사용
                    if (!numberStr.isEmpty()) {
                        tempnum = Integer.parseInt(numberStr)+1;
                    }

                    if(number<tempnum) number=tempnum;

                }

            }
        }

        GroupData newGroup=new GroupData("Region" + number,"Region"+number,true,null,"AWS_Groups","rgb(0,164,166)",null);
        groupDataList.add(newGroup);

        return newGroup;

    }



    public void sortRegionList(List<GroupData> regionList) {
        final Pattern pattern = Pattern.compile("Region(\\d*)");

        Collections.sort(regionList, (o1, o2) -> {
            Matcher matcher1 = pattern.matcher(o1.getKey());
            Matcher matcher2 = pattern.matcher(o2.getKey());

            int number1 = matcher1.find() && !matcher1.group(1).isEmpty()
                    ? Integer.parseInt(matcher1.group(1)) : 0;
            int number2 = matcher2.find() && !matcher2.group(1).isEmpty()
                    ? Integer.parseInt(matcher2.group(1)) : 0;

            return Integer.compare(number1, number2);
        });
    }

    public Point2D selectLocation2(List<NodeData> nodeDataList){
        double maxY = Double.MIN_VALUE;
        double minY = Double.MAX_VALUE;

        for (NodeData item: nodeDataList) {
            if (item.getLoc() != null && !item.getLoc().equals("loc")) {
                String location = item.getLoc();

                if (location.equals("loc")) {
                    continue;
                }

                String[] locParts = location.split(" ");
                try {
                    double x = Double.parseDouble(locParts[0]);
                    double y = Double.parseDouble(locParts[1]);

                    if (x < -100000 || x > 100000) continue;

                    if (y > maxY) {
                        maxY = y;
                    }
                    if (y < minY) {
                        minY = y;
                    }

                } catch (NumberFormatException e) {
                    System.err.println("Invalid location format for NodeData with key: " + item.getKey()+" "+item.getLoc());
                    System.out.println();
                    continue; // Skip this iteration if parsing fails
                }
            }
        }


//        return new Point2D.Double(maxX, (maxY+minY)/2);
        return new Point2D.Double(minY, maxY);
    }



    public void centralBackup (List<NodeData> nodeDataList, List<LinkData> linkDataList,List<GroupData> groupDataList){

        boolean regioncheck = false;

        List<GroupData> regionList = new ArrayList<>();
        for (GroupData grd:groupDataList) {
            if(grd.getKey().contains("Region")){
                regionList.add(grd);
            }
        }

        System.out.println("regionList: "+regionList);

        if(regionList.size()==1){
            GroupData newGroup = addRegionGroup(groupDataList);
            regionList.add(newGroup);
        }else{
            regioncheck = true;
        }


        if(regionList.size()==0){
            return;
        }

        sortRegionList(regionList);


        int number=0;

        //기존에 backup 버킷이 있다면 카운트
        for (NodeData groupitem : nodeDataList) {
            if(groupitem.getKey().contains("Backup")){

                Pattern pattern = Pattern.compile("Backup(\\d*)");
                Matcher matcher = pattern.matcher(groupitem.getKey());
                if (matcher.find()) {
                    String numberStr = matcher.group(1); // Region 다음의 숫자 부분
                    int tempnum = 1; // 기본값을 1로 설정

                    // 숫자가 있으면 그 숫자를 사용, 없으면 기본값 사용
                    if (!numberStr.isEmpty()) {
                        tempnum = Integer.parseInt(numberStr)+1;
                    }

                    if(number<tempnum) number=tempnum;

                }

            }
        }

        Point2D location = selectLocation(nodeDataList,groupDataList,regionList);

        System.out.println("Location: "+location.getX()+" "+location.getY());

        NodeData backup1= addResourceService.addBackup();
        NodeData backup2= addResourceService.addBackup();

        backup1.setKey("Backup " + number);
        backup1.setGroup(""+regionList.get(0).getKey());
        backup1.setLoc(""+(location.getX()+300)+" "+location.getY());

        backup2.setKey("Backup " + (number + 1));
        backup2.setGroup("" + regionList.get(1).getKey());

        String region2 = "" + regionList.get(1).getKey();

        List<String> region2Group =alertGroupService.groupSearch2(region2, groupDataList);

        if (regioncheck) {
            List<NodeData> region2Node = new ArrayList<>();
            for (NodeData node: nodeDataList) {
                if(region2Group.contains(node.getGroup())){
                    region2Node.add(node);
                }
            }

            Point2D regionLoc = selectLocation2(region2Node);
            System.out.println("regionLoc: "+regionLoc);

            backup2.setLoc("" + (location.getX() + 300) + " " + ((regionLoc.getY()-(regionLoc.getX()-location.getY()))+900));
        }else {
            backup2.setLoc("" + (location.getX() + 600) + " " + location.getY());
        }

        LinkData newlink = new LinkData();
        newlink.setFrom("Backup " + (number+1));
        newlink.setTo("Backup " + number);
        newlink.setKey(1);


        nodeDataList.add(backup1);
        nodeDataList.add(backup2);
        linkDataList.add(newlink);

    }
    public void generalBackup (List<NodeData> nodeDataList, List<GroupData> groupDataList){

        List<GroupData> regionList = new ArrayList<>();
        for (GroupData grd:groupDataList) {
            if(grd.getKey().contains("Region")){
                regionList.add(grd);
            }
        }

        if(regionList.size()<2 && regionList.size()>0){
            GroupData newGroup = addRegionGroup(groupDataList);
            regionList.add(newGroup);
        };


        if(regionList.size()==0){
            return;
        }

        sortRegionList(regionList);

        Point2D location = selectLocation(nodeDataList,groupDataList,regionList);

        int number=0;

        //기존에 s3 버킷이 있다면 카운트
        for (NodeData groupitem : nodeDataList) {
            if(groupitem.getKey().startsWith("S3")){
                Pattern pattern = Pattern.compile("^S3(\\d*)");
                Matcher matcher = pattern.matcher(groupitem.getKey());
                if (matcher.find()) {
                    String numberStr = matcher.group(1); // Region 다음의 숫자 부분
                    int tempnum = 1; // 기본값을 1로 설정
                    // 숫자가 있으면 그 숫자를 사용, 없으면 기본값 사용
                    if (!numberStr.isEmpty()) {
                        tempnum = Integer.parseInt(numberStr)+1;
                    }
                    if(number<tempnum) number=tempnum;
                }

            }
        }

        NodeData S3= addResourceService.addSimpleStorageServiceS3();

        S3.setKey("S3" + number);
        S3.setGroup("AWS Cloud");
        S3.setLoc(""+(location.getX()+600)+" "+(location.getY()+200));

//        NodeData newNode=new NodeData();
//        newNode.setKey("S3" + number);
//        newNode.setType("Storage");
//        newNode.setText("S3"+number);
//        newNode.setSource("/img/AWS_icon/Arch_Storage/Res_Amazon-Simple-Storage-Service_S3-Standard_48.svg");
//        newNode.setLoc(""+(location.getX()+600)+" "+(location.getY()+200));

        nodeDataList.add(S3);
    }

}
