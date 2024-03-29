package com.gae4coon.cloudmaestro.domain.file.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.GraphLinksModel;
import com.google.gson.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class FileService {

    public String convertFileFormat(MultipartFile file) throws Exception {
        String fileType = file.getContentType();

        // json 형태는 그대로 리턴
        if (fileType.equals("application/json")) {
            String content = new String(file.getBytes(), StandardCharsets.UTF_8);
            return content;
        }
        // excel to json
        List<Map<String, String>> data = excelToJson(file.getInputStream());

        // json to input data
        return dataToinput(data);
    }

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
        return jsonList;
    }

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
                }else{
                    break;
                }

                node.addProperty(newKey, newValue);
                if (!newKey.equals(key)) {
                    map.remove(key);
                }

            }
            if(node.size()==0) {
                count = 0;
            }
            for (int i = 0; i < count; i++) {
                JsonObject tempNode = node.deepCopy(); // 반복마다 새로운 JsonObject 인스턴스를 생성

                tempNode.addProperty("type", "Network_icon");
                if(tempNode.get("text")==null){
                }
                String textValue = tempNode.get("text").getAsString();
                String keyValue = null;

                switch (textValue){
                    case "FW": keyValue="Firewall"; break;
                    case "WAF": keyValue = "WAF"; break;
                    case "AD": keyValue = "Anti DDoS"; break;
                    case "DB": keyValue = "Database"; break;
                    case "IPS": keyValue = "IPS"; break;
                    case "IDS": keyValue = "IDS"; break;
                    case "SVR": keyValue = "Server"; break;
                    case "WS": keyValue = "Web Server"; break;
                }

                String imgFile=null;
                tempNode.addProperty("key", keyValue);
                tempNode.addProperty("text", keyValue);

                switch (textValue){
                    case "FW": imgFile="firewall"; break;
                    case "WAF": imgFile = "WAF"; break;
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
            groupNode.addProperty("stroke", "rgb(128,128,128)");

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

    public Map<String, Object> summaryFileParse(Map<String, Object> costMap){
            // 변환된 데이터를 담을 결과 맵
            Map<String, Object> response = new HashMap<>();

            // "compute" 부분 변환
            Map<String, Object> compute = new HashMap<>();
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

            Map<String, Object> waf = new HashMap<>();
            for (String key : costMap.keySet()) {
                if (key.startsWith("AWS_WAF")) {
                    waf.put(key, costMap.get(key));
                }
            }
            response.put("waf", waf);

            return response;
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


}
