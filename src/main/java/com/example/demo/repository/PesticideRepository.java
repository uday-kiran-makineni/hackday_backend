package com.example.demo.repository;

import com.example.demo.model.Pesticides;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PesticideRepository extends JpaRepository<Pesticides, Long> {
    List<Pesticides> findByFarmerId(Long farmerId);
}