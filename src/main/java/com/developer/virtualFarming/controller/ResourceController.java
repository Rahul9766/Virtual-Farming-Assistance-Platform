package com.developer.virtualFarming.controller;



import com.developer.virtualFarming.model.Resource;
import com.developer.virtualFarming.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping("/add")
    public ResponseEntity<String> addResource(@RequestBody Resource resource) {
        resourceService.saveResource(resource);
        return ResponseEntity.ok("Resource added successfully!");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Resource>> listResources() {
        List<Resource> resources = resourceService.getAllResources();
        return ResponseEntity.ok(resources);
    }
}
