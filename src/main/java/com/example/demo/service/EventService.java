package com.example.demo.service;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event eventDetails) {
        Event event = getEventById(id);
        event.setName(eventDetails.getName());
        event.setDate(eventDetails.getDate());
        event.setFee(eventDetails.getFee());
        event.setOrganization(eventDetails.getOrganization());
        event.setDescription(eventDetails.getDescription());
        event.setImageUrl(eventDetails.getImageUrl());
        event.setTime(eventDetails.getTime());
        event.setSlots(eventDetails.getSlots());
        event.setVenue(eventDetails.getVenue());
        event.setTargetAudience(eventDetails.getTargetAudience());
        event.setTheme(eventDetails.getTheme());
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public List<String> parseCommaSeparatedValues(String values) {
        if (values == null || values.isEmpty()) {
            return List.of();
        }
        return Arrays.asList(values.split(",\\s*"));
    }
}
