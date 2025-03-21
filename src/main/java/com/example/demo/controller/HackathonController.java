package com.example.demo.controller;

import com.example.demo.model.Hackathon;
import com.example.demo.service.HackathonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/hackathons")
public class HackathonController {
    private final HackathonService hackathonService;

    public HackathonController(HackathonService hackathonService) {
        this.hackathonService = hackathonService;
    }

    @GetMapping
    public List<Hackathon> getAllHackathons() {
        return hackathonService.getAllHackathons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hackathon> getHackathonById(@PathVariable Long id) {
        return ResponseEntity.ok(hackathonService.getHackathonById(id));
    }

    @PostMapping
    public ResponseEntity<Hackathon> createHackathon(@RequestBody Hackathon hackathon) {
        return ResponseEntity.ok(hackathonService.createHackathon(hackathon));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hackathon> updateHackathon(@PathVariable Long id, @RequestBody Hackathon hackathonDetails) {
        return ResponseEntity.ok(hackathonService.updateHackathon(id, hackathonDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHackathon(@PathVariable Long id) {
        hackathonService.deleteHackathon(id);
        return ResponseEntity.noContent().build();
    }
}
