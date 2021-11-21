package upc.edu.pe.FortlomBackend.backend.domain.service;

import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();
    Page<Event> getAllEvents(Pageable pageable);
    Event getEventById(Long eventId);
    Event createEvent(Long Artist,Event event);
    Event updateEvent(Long eventId, Event request);
    List<Event> getEventsByArtistId(Long artistId);
    ResponseEntity<?> deleteEvent(Long eventId);
}
