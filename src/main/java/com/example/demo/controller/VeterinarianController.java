package com.example.demo.controller;

import com.example.demo.model.Veterinarian;
import com.example.demo.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veterinarians")
public class VeterinarianController {

    @Autowired
    private VeterinarianService veterinarianService;

    // Get all veterinarians
    @GetMapping
    public ResponseEntity<List<Veterinarian>> getAllVeterinarians() {
        List<Veterinarian> veterinarians = veterinarianService.getAllVeterinarians();
        return new ResponseEntity<>(veterinarians, HttpStatus.OK);
    }

    // Get veterinarian by ID
    @GetMapping("/{id}")
    public ResponseEntity<Veterinarian> getVeterinarianById(@PathVariable Long id) {
        Optional<Veterinarian> veterinarian = veterinarianService.getVeterinarianById(id);
        return veterinarian.map(v -> new ResponseEntity<>(v, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Add a new veterinarian
    @PostMapping
    public ResponseEntity<Veterinarian> addVeterinarian(@RequestBody Veterinarian veterinarian) {
        Veterinarian newVeterinarian = veterinarianService.addVeterinarian(veterinarian);
        return new ResponseEntity<>(newVeterinarian, HttpStatus.CREATED);
    }

    // Update veterinarian details by ID
    @PutMapping("/{id}")
    public ResponseEntity<Veterinarian> updateVeterinarian(@PathVariable Long id, @RequestBody Veterinarian updatedVeterinarian) {
        Optional<Veterinarian> updated = veterinarianService.updateVeterinarian(id, updatedVeterinarian);
        return updated.map(v -> new ResponseEntity<>(v, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete veterinarian by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeterinarian(@PathVariable Long id) {
        boolean isDeleted = veterinarianService.deleteVeterinarian(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}