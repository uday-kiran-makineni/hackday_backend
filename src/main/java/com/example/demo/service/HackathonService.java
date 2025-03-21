package com.example.demo.service;


import com.example.demo.model.Hackathon;
import com.example.demo.repository.HackathonRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class HackathonService {
    private final HackathonRepository hackathonRepository;

    public HackathonService(HackathonRepository hackathonRepository) {
        this.hackathonRepository = hackathonRepository;
    }

    public List<Hackathon> getAllHackathons() {
        return hackathonRepository.findAll();
    }

    public Hackathon getHackathonById(Long id) {
        return hackathonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hackathon not found"));
    }

    public Hackathon createHackathon(Hackathon hackathon) {
        return hackathonRepository.save(hackathon);
    }

    public Hackathon updateHackathon(Long id, Hackathon hackathonDetails) {
        Hackathon hackathon = getHackathonById(id);
        hackathon.setName(hackathonDetails.getName());
        hackathon.setFee(hackathonDetails.getFee());
        hackathon.setOrganization(hackathonDetails.getOrganization());
        hackathon.setDate(hackathonDetails.getDate());
        hackathon.setEndDate(hackathonDetails.getEndDate());
        hackathon.setTime(hackathonDetails.getTime());
        hackathon.setVenue(hackathonDetails.getVenue());
        hackathon.setPrize(hackathonDetails.getPrize());
        hackathon.setDescription(hackathonDetails.getDescription());
        hackathon.setObjectives(hackathonDetails.getObjectives());
        hackathon.setEligibility(hackathonDetails.getEligibility());
        hackathon.setTags(hackathonDetails.getTags());
        hackathon.setTimeline(hackathonDetails.getTimeline());
        return hackathonRepository.save(hackathon);
    }

    public void deleteHackathon(Long id) {
        hackathonRepository.deleteById(id);
    }

    public List<String> parseCommaSeparatedValues(String values) {
        if (values == null || values.isEmpty()) {
            return List.of();
        }
        return Arrays.asList(values.split(",\\s*"));
    }
}
