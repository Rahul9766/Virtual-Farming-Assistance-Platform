package com.developer.virtualFarming.service;





import com.developer.virtualFarming.utils.JsonReader;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class CropServiceImpl implements CropService {
    private static final String FILE_NAME = "crops.json";

    public List<String> getRecommendedCrops(String soilType, String season) {
        Map<String, Map<String, List<String>>> cropsData = JsonReader.readJsonFile(FILE_NAME, Map.class);
        return cropsData.getOrDefault(soilType, Map.of()).getOrDefault(season, List.of("No suitable crops found"));
    }
}
