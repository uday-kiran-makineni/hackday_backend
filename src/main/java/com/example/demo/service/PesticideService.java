package com.example.demo.service;

import com.example.demo.model.Pesticides;
import com.example.demo.repository.PesticideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PesticideService {

    @Autowired
    private PesticideRepository pesticideRepository;

    public List<Pesticides> getAllPesticides() {
        return pesticideRepository.findAll();
    }

    public List<Pesticides> getPesticidesByFarmerId(Long farmerId) {
        return pesticideRepository.findByFarmerId(farmerId);
    }

    public Pesticides addPesticide(Pesticides pesticide) {
        return pesticideRepository.save(pesticide);
    }

    public Optional<Pesticides> updatePesticideStatus(Long id, String status) {
        return pesticideRepository.findById(id).map(existingPesticide -> {
            existingPesticide.setPesticideStatus(status); // Assuming you add a status field
            return pesticideRepository.save(existingPesticide);
        });
    }

    public boolean deletePesticide(Long id) {
        if (pesticideRepository.existsById(id)) {
            pesticideRepository.deleteById(id);
            return true;
        }
        return false;
    }
}