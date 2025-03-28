package com.example.demo.service;

import com.example.demo.model.Crops;
import com.example.demo.repository.CropsRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CropsService {

    private final CropsRepository cropsRepository;

    public CropsService(CropsRepository cropsRepository) {
        this.cropsRepository = cropsRepository;
    }

    public List<Crops> getCropsByFarmerId(Long farmerId) {
        return cropsRepository.findByFarmerId(farmerId);
    }
}