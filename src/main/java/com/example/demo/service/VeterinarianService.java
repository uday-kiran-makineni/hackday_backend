package com.example.demo.service;


import com.example.demo.model.Veterinarian;
import com.example.demo.repository.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarianService {

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    public List<Veterinarian> getAllVeterinarians() {
        return veterinarianRepository.findAll();
    }

    public Optional<Veterinarian> getVeterinarianById(Long id) {
        return veterinarianRepository.findById(id);
    }

    public Veterinarian addVeterinarian(Veterinarian veterinarian) {
        return veterinarianRepository.save(veterinarian);
    }

    public Optional<Veterinarian> updateVeterinarian(Long id, Veterinarian updatedVeterinarian) {
        return veterinarianRepository.findById(id).map(existingVeterinarian -> {
            existingVeterinarian.setUsername(updatedVeterinarian.getUsername());
            existingVeterinarian.setPosition(updatedVeterinarian.getPosition());
            existingVeterinarian.setExperience(updatedVeterinarian.getExperience());
            existingVeterinarian.setAbout(updatedVeterinarian.getAbout());
            existingVeterinarian.setSpeciality(updatedVeterinarian.getSpeciality());
            existingVeterinarian.setEmail(updatedVeterinarian.getEmail());
            existingVeterinarian.setPhone(updatedVeterinarian.getPhone());
            existingVeterinarian.setPassword(updatedVeterinarian.getPassword());
            return veterinarianRepository.save(existingVeterinarian);
        });
    }

    public boolean deleteVeterinarian(Long id) {
        if (veterinarianRepository.existsById(id)) {
            veterinarianRepository.deleteById(id);
            return true;
        }
        return false;
    }
}