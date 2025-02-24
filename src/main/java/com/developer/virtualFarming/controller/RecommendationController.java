package com.developer.virtualFarming.controller;



import com.developer.virtualFarming.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/recommendation")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/{input}")
    public Map<String, Object> getRecommendation(@PathVariable String input) {
        return recommendationService.getRecommendation(input);
    }
}
