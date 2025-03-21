package com.example.demo.controller;

import com.example.demo.model.TechTalk;
import com.example.demo.service.TechTalkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/techtalks")
public class TechTalkController {

    private final TechTalkService techTalkService;

    public TechTalkController(TechTalkService techTalkService) {
        this.techTalkService = techTalkService;
    }

    @GetMapping
    public List<TechTalk> getAllTechTalks() {
        return techTalkService.getAllTechTalks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechTalk> getTechTalkById(@PathVariable Long id) {
        return ResponseEntity.ok(techTalkService.getTechTalkById(id));
    }

    @PostMapping
    public ResponseEntity<TechTalk> createTechTalk(@RequestBody TechTalk techTalk) {
        return ResponseEntity.ok(techTalkService.createTechTalk(techTalk));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechTalk> updateTechTalk(@PathVariable Long id, @RequestBody TechTalk techTalk) {
        return ResponseEntity.ok(techTalkService.updateTechTalk(id, techTalk));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechTalk(@PathVariable Long id) {
        techTalkService.deleteTechTalk(id);
        return ResponseEntity.noContent().build();
    }
}
