package com.example.demo.controller;


import com.example.demo.model.Codeathon;
import com.example.demo.model.Contest;
import com.example.demo.service.CodeathonService;
import com.example.demo.service.ContestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/contests")
public class ContestController {

    private final ContestService contestService;

    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    @GetMapping
    public List<Contest> getAllContests() {
        return contestService.getAllContests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contest> getContestById(@PathVariable Long id) {
        return ResponseEntity.ok(contestService.getContestById(id));
    }

    @PostMapping
    public ResponseEntity<Contest> createContest(@RequestBody Contest contest) {
        return ResponseEntity.ok(contestService.createContest(contest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contest> updateContest(@PathVariable Long id, @RequestBody Contest contest) {
        return ResponseEntity.ok(contestService.updateContest(id, contest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContest(@PathVariable Long id) {
        contestService.deleteContest(id);
        return ResponseEntity.noContent().build();
    }
}
