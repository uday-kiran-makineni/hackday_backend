package com.example.demo.service;


import com.example.demo.model.Codeathon;
import com.example.demo.model.Contest;
import com.example.demo.repository.CodeathonRepository;
import com.example.demo.repository.ContestRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ContestService {

    private final ContestRepository contestRepository;

    public ContestService(ContestRepository contestRepository) {
        this.contestRepository = contestRepository;
    }

    public List<Contest> getAllContests() {
        return contestRepository.findAll();
    }

    public Contest getContestById(Long id) {
        return contestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contest not found"));
    }

    public Contest createContest(Contest contest) {
        return contestRepository.save(contest);
    }

    public Contest updateContest(Long id, Contest contestDetails) {
        Contest contest = getContestById(id);
        contest.setName(contestDetails.getName());
        contest.setDate(contestDetails.getDate());
        contest.setTime(contestDetails.getTime());
        contest.setDuration(contestDetails.getDuration());
        contest.setPlatform(contestDetails.getPlatform());
        return contestRepository.save(contest);
    }

    public void deleteContest(Long id) {
        contestRepository.deleteById(id);
    }

    public List<String> parseCommaSeparatedValues(String values) {
        if (values == null || values.isEmpty()) {
            return List.of();
        }
        return Arrays.asList(values.split(",\\s*"));
    }
}
