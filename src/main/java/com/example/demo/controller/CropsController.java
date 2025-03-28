package com.example.demo.controller;

import com.example.demo.model.Crops;
import com.example.demo.service.CropsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CropsController {

    private final CropsService cropsService;

    public CropsController(CropsService cropsService) {
        this.cropsService = cropsService;
    }

    @GetMapping("/crops")
    public ResponseEntity<List<Crops>> getCropsByFarmerId(@RequestParam Long farmerId) {
        List<Crops> crops = cropsService.getCropsByFarmerId(farmerId);
        return ResponseEntity.ok(crops);
    }
}