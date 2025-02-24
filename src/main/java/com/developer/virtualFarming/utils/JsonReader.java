package com.developer.virtualFarming.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonReader {
    private static final String BASE_PATH = "src/main/resources/data/";

    public static <T> T readJsonFile(String fileName, Class<T> valueType) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(BASE_PATH + fileName), valueType);
        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON file: " + fileName, e);
        }
    }
}
