package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonObject {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode getJsonObject(String filePath) {
        JsonNode jsonNode = null;

        try {
            Log.info(" Creating JSON object from file: " + filePath);
            jsonNode = objectMapper.readTree(new File(filePath));

            Log.info(" Returning created JSON object: " + jsonNode.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonNode;
    }

    private static String convertJsonObjectToString(JsonNode jsonObject) {
        String json = "";

        try {
            Log.info(" Converting JSON object to JSON string");
            json = objectMapper.writeValueAsString(jsonObject);
            Log.info(" Returning converted JSON string: " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static String convertJsonObjectToStringFromFile(String fileName) {
        return convertJsonObjectToString(getJsonObject(fileName));
    }
}
