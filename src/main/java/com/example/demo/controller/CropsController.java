package com.example.demo.controller;

import com.example.demo.model.Crops;
import com.example.demo.service.CropsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/crops")
public class CropsController {

    @Autowired
    private CropsService cropsService;

    @GetMapping
    public ResponseEntity<List<Crops>> getAllCrops() {
        List<Crops> crops = cropsService.getAllCrops();
        return new ResponseEntity<>(crops, HttpStatus.OK);
    }

    @GetMapping("/farmer/{farmerId}")
    public ResponseEntity<List<Crops>> getCropsByFarmerId(@PathVariable Long farmerId) {
        List<Crops> crops = cropsService.getCropsByFarmerId(farmerId);
        return new ResponseEntity<>(crops, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Crops> getCropById(@PathVariable Long id) {
        Optional<Crops> crop = cropsService.getCropById(id);
        return crop.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Crops> addCrop(@RequestBody Crops crop) {
        Crops newCrop = cropsService.addCrop(crop);
        return new ResponseEntity<>(newCrop, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Crops> updateCrop(@PathVariable Long id, @RequestBody Crops updatedCrop) {
        Optional<Crops> updated = cropsService.updateCrop(id, updatedCrop);
        return updated.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCrop(@PathVariable Long id) {
        boolean isDeleted = cropsService.deleteCrop(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}