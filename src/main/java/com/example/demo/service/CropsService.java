package com.example.demo.service;

import com.example.demo.model.Crops;
import com.example.demo.repository.CropsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropsService {

    @Autowired
    private CropsRepository cropsRepository;

    public List<Crops> getAllCrops() {
        return cropsRepository.findAll();
    }

    public List<Crops> getCropsByFarmerId(Long farmerId) {
        return cropsRepository.findByFarmerId(farmerId);
    }

    public Optional<Crops> getCropById(Long id) {
        return cropsRepository.findById(id);
    }

    public Crops addCrop(Crops crop) {
        return cropsRepository.save(crop);
    }

    public Optional<Crops> updateCrop(Long id, Crops updatedCrop) {
        return cropsRepository.findById(id).map(existingCrop -> {
            existingCrop.setFarmerId(updatedCrop.getFarmerId());
            existingCrop.setCropName(updatedCrop.getCropName());
            existingCrop.setAcres(updatedCrop.getAcres());
            existingCrop.setLocation(updatedCrop.getLocation());
            existingCrop.setSoilType(updatedCrop.getSoilType());
            existingCrop.setStartMonth(updatedCrop.getStartMonth());
            existingCrop.setEndMonth(updatedCrop.getEndMonth());
            existingCrop.setManager(updatedCrop.getManager());
            existingCrop.setContact(updatedCrop.getContact());
            return cropsRepository.save(existingCrop);
        });
    }

    public boolean deleteCrop(Long id) {
        if (cropsRepository.existsById(id)) {
            cropsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}