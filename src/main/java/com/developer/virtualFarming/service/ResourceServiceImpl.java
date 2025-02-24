package com.developer.virtualFarming.service;





import com.developer.virtualFarming.model.Resource;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.developer.virtualFarming.utils.JsonReader;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResourceServiceImpl implements ResourceService {
    private static final String FILE_NAME = "resources.json";

    public List<Resource> getAllResources() {
        return JsonReader.readJsonFile(FILE_NAME, List.class);
    }

    public void saveResource(Resource resource) {
        List<Resource> resources = getAllResources();
        resources.add(resource);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("src/main/resources/data/" + FILE_NAME), resources);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to JSON file", e);
        }
    }
}
