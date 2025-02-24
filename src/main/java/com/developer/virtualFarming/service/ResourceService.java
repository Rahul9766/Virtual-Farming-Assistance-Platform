package com.developer.virtualFarming.service;



import com.developer.virtualFarming.model.Resource;
import java.util.List;

public interface ResourceService {
    void saveResource(Resource resource);
    List<Resource> getAllResources();
}

