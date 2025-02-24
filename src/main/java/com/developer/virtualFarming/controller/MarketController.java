package com.developer.virtualFarming.controller;



import com.developer.virtualFarming.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/market")
public class MarketController {
    @Autowired private MarketService marketService;

    @GetMapping("/prices")
    public ResponseEntity<Map<String, Double>> getMarketPrices() {
        return ResponseEntity.ok(marketService.getMarketPrices());
    }
}

