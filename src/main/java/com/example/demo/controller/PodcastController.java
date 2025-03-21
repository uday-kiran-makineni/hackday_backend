package com.example.demo.controller;

import com.example.demo.model.Podcasts;
import com.example.demo.service.PodcastService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/podcasts")
public class PodcastController {

    private final PodcastService podcastService;

    public PodcastController(PodcastService podcastService) {
        this.podcastService = podcastService;
    }

    @GetMapping
    public List<Podcasts> getAllPodcasts() {
        return podcastService.getAllPodcasts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Podcasts> getPodcastById(@PathVariable Long id) {
        return ResponseEntity.ok(podcastService.getPodcastById(id));
    }

    @PostMapping
    public ResponseEntity<Podcasts> createPodcast(@RequestBody Podcasts podcasts) {
        return ResponseEntity.ok(podcastService.createPodcast(podcasts));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Podcasts> updatePodcast(@PathVariable Long id, @RequestBody Podcasts podcasts) {
        return ResponseEntity.ok(podcastService.updatePodcast(id, podcasts));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePodcast(@PathVariable Long id) {
        podcastService.deletePodcast(id);
        return ResponseEntity.noContent().build();
    }
}
