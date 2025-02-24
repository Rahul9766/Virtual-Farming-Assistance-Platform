package com.developer.virtualFarming.service;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final Map<String, Object> recommendations;

    public RecommendationServiceImpl() {
        this.recommendations = loadRecommendations();
    }

    private Map<String, Object> loadRecommendations() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new ClassPathResource("data/recommendations.json").getInputStream());
            return objectMapper.convertValue(jsonNode, Map.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load recommendations data: " + e.getMessage());
        }
    }

    @Override
    public Map<String, Object> getRecommendation(String input) {
        return (Map<String, Object>) recommendations.getOrDefault(input.toLowerCase(), new HashMap<>());
    }
}
