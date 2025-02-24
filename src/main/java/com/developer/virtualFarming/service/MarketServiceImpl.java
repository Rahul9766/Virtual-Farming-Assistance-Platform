package com.developer.virtualFarming.service;





import com.developer.virtualFarming.utils.JsonReader;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class MarketServiceImpl implements MarketService{
    private static final String FILE_NAME = "market_prices.json";

    public Map<String, Double> getMarketPrices() {
        return JsonReader.readJsonFile(FILE_NAME, Map.class);
    }
}

