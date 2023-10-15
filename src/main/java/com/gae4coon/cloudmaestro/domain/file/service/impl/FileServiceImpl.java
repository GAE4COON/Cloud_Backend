package com.gae4coon.cloudmaestro.domain.file.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gae4coon.cloudmaestro.domain.file.dto.InputData;
import com.gae4coon.cloudmaestro.domain.file.dto.NodeData;
import com.gae4coon.cloudmaestro.domain.file.dto.OutputData;
import com.gae4coon.cloudmaestro.domain.file.service.FileService;
import com.google.gson.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<Map<String, String>> excelToJson(InputStream excelStream) throws Exception {
        List<Map<String, String>> jsonList = new ArrayList<>();

        Workbook workbook = new XSSFWorkbook(excelStream);
        Sheet sheet = workbook.getSheetAt(0);

        Row headerRow = sheet.getRow(0);
        if (headerRow == null) {
            workbook.close();
            throw new Exception("No header row found.");
        }

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            Map<String, String> jsonMap = new LinkedHashMap<>();

            for (Cell cell : row) {
                String header;
                try {
                    header = headerRow.getCell(cell.getColumnIndex()).getStringCellValue();
                }catch (Exception ignored){continue;}
                if (isMergedRegion(sheet, cell)) {
                    CellAddress mergedAddress = getMergedAddress(sheet, cell);
                    cell = sheet.getRow(mergedAddress.getRow()).getCell(mergedAddress.getColumn());
                }
                jsonMap.put(header, getCellValue(cell));
            }
            jsonList.add(jsonMap);
        }

        workbook.close();
        System.out.println(jsonList);
        return jsonList;
    }

    @Override
    public String dataToinput(List<Map<String, String>> inputData) {
        JsonObject root = new JsonObject();
        JsonArray nodeDataArray = new JsonArray();
        Set<String> group = new HashSet<>();


        inputData.forEach(map -> {
            JsonObject node = new JsonObject();

            List<String> keys = new ArrayList<>(map.keySet());

            int count = 1; // Default count

            for (String key : keys) {
                String newKey = key;
                String newValue = map.get(key);

                if ("망".equals(newKey)) {
                    newKey = "group";
                    group.add(newValue);
                } else if ("장비명".equals(newKey)) {
                    newKey = "text";
                } else if ("개수".equals(newKey)) {
                    try {
                        count = (int) Double.parseDouble(newValue); // Convert the value to integer count

                    } catch (Exception e) {
                        count = 0;
                        map.remove(key); // Remove '개수' entry
                        continue;
                    }
                    map.remove(key); // Remove '개수' entry
                    continue; // Skip putting '개수' back into map
                }

                node.addProperty(newKey, newValue);
                if (!newKey.equals(key)) {
                    map.remove(key);
                }
            }

            // Add the transformed map 'count' number of times
            for (int i = 0; i < count; i++) {
                JsonObject tempNode = node.deepCopy(); // 반복마다 새로운 JsonObject 인스턴스를 생성
                tempNode.addProperty("type", "Network_icon");

                String textValue = tempNode.get("text").getAsString();
                String imgFile=null;
                tempNode.addProperty("key", textValue);

                switch (textValue){
                    case "FW": imgFile="firewall"; break;
                    case "WAF": imgFile = "firewall"; break;
                    case "AD": imgFile = "Anti_DDoS"; break;
                    case "DB": imgFile = "database"; break;
                    case "IPS": imgFile = "ips"; break;
                    case "IDS": imgFile = "ips"; break;
                    case "SVR": imgFile = "server"; break;
                    case "WS": imgFile = "server"; break;
                }

                tempNode.addProperty("source", "/img/Network_icon/" +imgFile+ ".png");
                nodeDataArray.add(tempNode);
            }
        });

        for(var g:group){
            JsonObject groupNode = new JsonObject();
            groupNode.addProperty("text", g);
            groupNode.addProperty("isGroup", true);
            groupNode.addProperty("type", "group");
            groupNode.addProperty("key", g);

            nodeDataArray.add(groupNode);
        }

        root.addProperty("class", "GraphLinksModel");
        root.addProperty("linkKeyProperty", "key");
        root.add("nodeDataArray", nodeDataArray);

        // put link
        JsonArray linkDataArray = new JsonArray();
        root.add("linkDataArray",linkDataArray);

        return root.toString();
    }

    public Map<String, Object> summaryFileParse(MultipartFile file){
        try {
            // Read the content of the uploaded file into a string
            String content = new String(file.getBytes(), StandardCharsets.UTF_8);

            // Parse the JSON string into a Map<String, Object>
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> jsonData = objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {
            });

            // 변환된 데이터를 담을 결과 맵
            Map<String, Object> response = new HashMap<>();
            Map<String, Object> costMap = (Map<String, Object>) jsonData.get("cost");

            // "compute" 부분 변환
            Map<String, Object> compute = new HashMap<>();
            System.out.println("key!!!!!!!!"+costMap.keySet());
            for (String key : costMap.keySet()) {
                if (key.startsWith("EC2")) {
                    compute.put(key, costMap.get(key));
                }
            }
            response.put("compute", compute);

            // "database" 부분 변환
            Map<String, Object> database = new HashMap<>();
            for (String key : costMap.keySet()) {
                if (key.startsWith("RDS")) {
                    database.put(key, costMap.get(key));
                }
            }
            response.put("database", database);

            // "storage" 부분 변환
            Map<String, Object> storage = new HashMap<>();
            for (String key : costMap.keySet()) {
                if (key.startsWith("Simple Storage Service")) {
                    storage.put(key, costMap.get(key));
                }
            }
            response.put("storage", storage);

            return response;

        } catch (IOException e) {
            return null;
            // Handle exceptions such as IO errors or JSON parsing errors
        }
    }


    public String getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return Double.toString(cell.getNumericCellValue());
            case BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            default:
                return "";
        }
    }

    public boolean isMergedRegion(Sheet sheet, Cell cell) {
        for (CellRangeAddress mergedRegion : sheet.getMergedRegions()) {
            if (mergedRegion.isInRange(cell.getRowIndex(), cell.getColumnIndex())) {
                return true;
            }
        }
        return false;
    }

    public CellAddress getMergedAddress(Sheet sheet, Cell cell) {
        for (CellRangeAddress mergedRegion : sheet.getMergedRegions()) {
            if (mergedRegion.isInRange(cell.getRowIndex(), cell.getColumnIndex())) {
                return new CellAddress(mergedRegion.getFirstRow(), mergedRegion.getFirstColumn());
            }
        }
        return null;
    }

    private OutputData transformData(InputData inputData) {
        // 변환 로직 구현
        Map<String, Object> compute = new HashMap<>();
        Map<String, Object> database = new HashMap<>();
        Map<String, Object> storage = new HashMap<>();

        for (NodeData nodeData : inputData.getNodeDataArray()) {
            Map<String, Object> matchedCost = null;
            for (Map<String, Object> costItem : inputData.getCost()) {
                if (costItem.containsKey(nodeData.getKey())) {
                    matchedCost = (Map<String, Object>) costItem.get(nodeData.getKey());
                    break;
                }
            }

            if (matchedCost == null) {
                continue;
            }

            if ("Compute".equals(nodeData.getType())) {
                Map<String, Object> comDetails = new HashMap<>();
                if (matchedCost.containsKey("platform")) {
                    comDetails.put("platform", matchedCost.get("platform"));
                }
                if (matchedCost.containsKey("instancetype")) {
                    comDetails.put("instancetype", matchedCost.get("instancetype"));
                }
                if (matchedCost.containsKey("size")) {
                    comDetails.put("size", matchedCost.get("size"));
                }
                if (matchedCost.containsKey("billing")) {
                    comDetails.put("billing", matchedCost.get("billing"));
                }
                if (matchedCost.containsKey("cost")) {
                    comDetails.put("cost", matchedCost.get("cost"));
                }
                compute.put(nodeData.getKey(), comDetails);

            } else if ("Database".equals(nodeData.getType())) {
                Map<String, Object> dbDetails = new HashMap<>();
                if (matchedCost.containsKey("engine")) {
                    dbDetails.put("engine", matchedCost.get("engine"));
                }
                if (matchedCost.containsKey("instancetype")) {
                    dbDetails.put("instancetype", matchedCost.get("instancetype"));
                }
                if (matchedCost.containsKey("size")) {
                    dbDetails.put("size", matchedCost.get("size"));
                }
                if (matchedCost.containsKey("cost")) {
                    dbDetails.put("cost", matchedCost.get("cost"));
                }
                // Add other attributes if needed...

                database.put(nodeData.getKey(), dbDetails);

            } else if ("Storage".equals(nodeData.getType())) {
                storage.put(nodeData.getKey(), matchedCost);
            }
        }

        OutputData outputData = new OutputData();
        outputData.setCompute(compute);
        outputData.setDatabase(database);
        outputData.setStorage(storage);

        return outputData;

    }



}
