package com.example.demo.controller;


import com.example.demo.model.Pesticides;
import com.example.demo.service.PesticideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://hackday-sepia.vercel.app")
@RestController
@RequestMapping("/api/pesticides")
public class PesticideController {

    @Autowired
    private PesticideService pesticideService;

    @GetMapping
    public ResponseEntity<List<Pesticides>> getAllPesticides() {
        List<Pesticides> pesticides = pesticideService.getAllPesticides();
        return new ResponseEntity<>(pesticides, HttpStatus.OK);
    }

    @GetMapping("/farmer/{farmerId}")
    public ResponseEntity<List<Pesticides>> getPesticidesByFarmerId(@PathVariable Long farmerId) {
        List<Pesticides> pesticides = pesticideService.getPesticidesByFarmerId(farmerId);
        return new ResponseEntity<>(pesticides, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pesticides> addPesticide(@RequestBody Pesticides pesticide) {
        Pesticides newPesticide = pesticideService.addPesticide(pesticide);
        return new ResponseEntity<>(newPesticide, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Pesticides> updatePesticideStatus(@PathVariable Long id, @RequestBody String status) {
        Optional<Pesticides> updatedPesticide = pesticideService.updatePesticideStatus(id, status);
        return updatedPesticide.map(pesticide -> new ResponseEntity<>(pesticide, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePesticide(@PathVariable Long id) {
        boolean isDeleted = pesticideService.deletePesticide(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}