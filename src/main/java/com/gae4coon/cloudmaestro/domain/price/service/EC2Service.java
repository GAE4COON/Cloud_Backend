package com.gae4coon.cloudmaestro.domain.price.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class EC2Service {
    public JsonNode getVantagePricing(String platform, String instance, String lifecycle) throws Exception {
        System.out.printf("api가 호출되긴 함 %s", instance);

        OkHttpClient client = new OkHttpClient();
        String formattedUrl = String.format("https://api.vantage.sh/v1/products/%s/prices", instance);

        Request request = new Request.Builder()
                .url(formattedUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", "Bearer vntg_tkn_0cd356dd118555b50423190498edbbd4ed67dcbe")
                .build();

        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(responseBody);
        ArrayNode pricesArray = (ArrayNode) rootNode.path("prices");

        ObjectNode resultNode = mapper.createObjectNode();
        String detailsPlatform = null;
        String detailsLifecycle = null;
        String detailsRegion = null;


        for (JsonNode priceNode : pricesArray) {
            detailsPlatform = priceNode.path("details").path("platform").asText();
            detailsLifecycle = priceNode.path("details").path("lifecycle").asText();
            detailsRegion = priceNode.path("region").asText();

            if (detailsPlatform.equalsIgnoreCase(platform) && detailsLifecycle.equalsIgnoreCase(lifecycle)
                    && detailsRegion.equalsIgnoreCase("ap-northeast-2")) {
                resultNode.put("currency", priceNode.path("currency").asText());
                resultNode.put("unit", priceNode.path("unit").asText());
                resultNode.put("amount", priceNode.path("amount").asText());
                resultNode.put("region", "ap-northeast-2");
                return resultNode;
            }
        }

        resultNode.put("message",detailsPlatform);
        resultNode.put("message1",detailsLifecycle);
        resultNode.put("message2",detailsRegion );
        resultNode.put("message3",platform);
        resultNode.put("message4",instance);
        resultNode.put("message5",lifecycle);
        return resultNode;
    }
}
