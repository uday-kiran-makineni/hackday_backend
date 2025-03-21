package com.example.demo.service;


import com.example.demo.model.Codeathon;
import com.example.demo.repository.CodeathonRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CodeathonService {

    private final CodeathonRepository codeathonRepository;

    public CodeathonService(CodeathonRepository codeathonRepository) {
        this.codeathonRepository = codeathonRepository;
    }

    public List<Codeathon> getAllCodeathons() {
        return codeathonRepository.findAll();
    }

    public Codeathon getCodeathonById(Long id) {
        return codeathonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Codeathon not found"));
    }

    public Codeathon createCodeathon(Codeathon codeathon) {
        return codeathonRepository.save(codeathon);
    }

    public Codeathon updateCodeathon(Long id, Codeathon codeathonDetails) {
        Codeathon codeathon = getCodeathonById(id);
        codeathon.setName(codeathonDetails.getName());
        codeathon.setFee(codeathonDetails.getFee());
        codeathon.setOrganization(codeathonDetails.getOrganization());
        codeathon.setDate(codeathonDetails.getDate());
        codeathon.setEndDate(codeathonDetails.getEndDate());
        codeathon.setTime(codeathonDetails.getTime());
        codeathon.setVenue(codeathonDetails.getVenue());
        codeathon.setPrize(codeathonDetails.getPrize());
        codeathon.setDescription(codeathonDetails.getDescription());
        codeathon.setObjectives(codeathonDetails.getObjectives());
        codeathon.setEligibility(codeathonDetails.getEligibility());
        codeathon.setTags(codeathonDetails.getTags());
        codeathon.setTimeline(codeathonDetails.getTimeline());
        return codeathonRepository.save(codeathon);
    }

    public void deleteCodeathon(Long id) {
        codeathonRepository.deleteById(id);
    }

    public List<String> parseCommaSeparatedValues(String values) {
        if (values == null || values.isEmpty()) {
            return List.of();
        }
        return Arrays.asList(values.split(",\\s*"));
    }
}
