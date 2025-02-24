package com.developer.virtualFarming.service;



import com.developer.virtualFarming.dto.CropRequest;
import java.util.List;

public interface CropService {


    public List<String> getRecommendedCrops(String soilType, String season);
}
