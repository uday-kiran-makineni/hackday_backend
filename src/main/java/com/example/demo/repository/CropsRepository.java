package com.example.demo.repository;

import com.example.demo.model.Crops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CropsRepository extends JpaRepository<Crops, Long> {
    List<Crops> findByFarmerId(Long farmerId);
}