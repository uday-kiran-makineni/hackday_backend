package com.example.demo.service;

import com.example.demo.model.Podcasts;
import com.example.demo.repository.PodcastRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PodcastService {

    private final PodcastRepository podcastRepository;

    public PodcastService(PodcastRepository podcastRepository) {
        this.podcastRepository = podcastRepository;
    }

    public List<Podcasts> getAllPodcasts() {
        return podcastRepository.findAll();
    }

    public Podcasts getPodcastById(Long id) {
        return podcastRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Podcast not found"));
    }

    public Podcasts createPodcast(Podcasts podcasts) {
        return podcastRepository.save(podcasts);
    }

    public Podcasts updatePodcast(Long id, Podcasts podcastDetails) {
        Podcasts podcast = getPodcastById(id);
        podcast.setName(podcastDetails.getName());
        podcast.setSpeaker(podcastDetails.getSpeaker());
        podcast.setFee(podcastDetails.getFee());
        podcast.setOrganization(podcastDetails.getOrganization());
        podcast.setDate(podcastDetails.getDate());
        podcast.setDescription(podcastDetails.getDescription());
        podcast.setDuration(podcastDetails.getDuration());
        podcast.setImageUrl(podcastDetails.getImageUrl());
        podcast.setRegistrationStart(podcastDetails.getRegistrationStart());
        podcast.setRegistrationEnd(podcastDetails.getRegistrationEnd());
        podcast.setTime(podcastDetails.getTime());
        podcast.setTopic(podcastDetails.getTopic());
        podcast.setVenue(podcastDetails.getVenue());
        return podcastRepository.save(podcast);
    }

    public void deletePodcast(Long id) {
        podcastRepository.deleteById(id);
    }

    public List<String> parseCommaSeparatedValues(String values) {
        if (values == null || values.isEmpty()) {
            return List.of();
        }
        return Arrays.asList(values.split(",\\s*"));
    }
}
