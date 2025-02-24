package com.developer.virtualFarming.controller;

import com.developer.virtualFarming.service.PestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/api/pests")
public class PestController {

    @Autowired
    private PestService pestService;

    @PostMapping(value = "/analyze", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> analyzePest(@RequestParam("image") MultipartFile image) {
        if (image.isEmpty()) {
            return ResponseEntity.badRequest().body("Image file is missing.");
        }

        try {
            String pestInfo = pestService.identifyPest(image);
            return ResponseEntity.ok(pestInfo);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing image: " + e.getMessage());
        }
    }
}