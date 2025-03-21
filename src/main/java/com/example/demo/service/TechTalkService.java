package com.example.demo.service;


import com.example.demo.model.TechTalk;
import com.example.demo.repository.TechTalkRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TechTalkService {

    private final TechTalkRepository techTalkRepository;

    public TechTalkService(TechTalkRepository techTalkRepository) {
        this.techTalkRepository = techTalkRepository;
    }

    public List<TechTalk> getAllTechTalks() {
        return techTalkRepository.findAll();
    }

    public TechTalk getTechTalkById(Long id) {
        return techTalkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tech Talk not found"));
    }

    public TechTalk createTechTalk(TechTalk techTalk) {
        return techTalkRepository.save(techTalk);
    }

    public TechTalk updateTechTalk(Long id, TechTalk techTalkDetails) {
        TechTalk techTalk = getTechTalkById(id);
        techTalk.setName(techTalkDetails.getName());
        techTalk.setSpeaker(techTalkDetails.getSpeaker());
        techTalk.setFee(techTalkDetails.getFee());
        techTalk.setOrganization(techTalkDetails.getOrganization());
        techTalk.setDate(techTalkDetails.getDate());
        techTalk.setDescription(techTalkDetails.getDescription());
        techTalk.setDuration(techTalkDetails.getDuration());
        techTalk.setImageUrl(techTalkDetails.getImageUrl());
        techTalk.setRegistrationStart(techTalkDetails.getRegistrationStart());
        techTalk.setRegistrationEnd(techTalkDetails.getRegistrationEnd());
        techTalk.setTime(techTalkDetails.getTime());
        techTalk.setTopic(techTalkDetails.getTopic());
        techTalk.setVenue(techTalkDetails.getVenue());
        return techTalkRepository.save(techTalk);
    }

    public void deleteTechTalk(Long id) {
        techTalkRepository.deleteById(id);
    }

    public List<String> parseCommaSeparatedValues(String values) {
        if (values == null || values.isEmpty()) {
            return List.of();
        }
        return Arrays.asList(values.split(",\\s*"));
    }
}
