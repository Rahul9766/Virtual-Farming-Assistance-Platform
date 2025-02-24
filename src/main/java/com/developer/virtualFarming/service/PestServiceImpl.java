package com.developer.virtualFarming.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;

@Service
public class PestServiceImpl implements PestService {

    private static final String JSON_FILE_PATH = "data/pests.json";

    @Override
    public String identifyPest(MultipartFile image) throws IOException {
        String fileName = image.getOriginalFilename();
        if (fileName == null || fileName.trim().isEmpty()) {
            return "Invalid image file.";
        }

        String pestName = fileName.toLowerCase().replaceAll("\\.(jpg|png|jpeg)$", "").trim();
        String remedy = getRemedyFromJson(pestName);

        return String.format("Pest detected: %s. Remedy: %s", pestName, remedy);
    }

    private String getRemedyFromJson(String pestName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        try (InputStream inputStream = new ClassPathResource(JSON_FILE_PATH).getInputStream()) {
            JsonNode rootNode = objectMapper.readTree(inputStream);
            JsonNode pestsArray = rootNode.path("pests");

            for (JsonNode pestNode : pestsArray) {
                if (pestNode.path("name").asText().equalsIgnoreCase(pestName)) {
                    return pestNode.path("remedy").asText();
                }
            }
        }

        return "No known remedy found.";
    }
}
