package com.developer.virtualFarming.controller;


import com.developer.virtualFarming.dto.CropRequest;
import com.developer.virtualFarming.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/crops")
public class CropController {
    @Autowired
    private CropService cropService;

    @PostMapping("/recommend")
    public ResponseEntity<List<String>> recommendCrops(@RequestBody CropRequest request) {
        return ResponseEntity.ok(cropService.getRecommendedCrops(request.getSoilType(), request.getSeason()));
    }
}
