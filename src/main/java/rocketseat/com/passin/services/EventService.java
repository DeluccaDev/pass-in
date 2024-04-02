package rocketseat.com.passin.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.com.passin.domain.attendee.Attendee;
import rocketseat.com.passin.domain.event.Event;
import rocketseat.com.passin.dto.Event.EventIdDTO;
import rocketseat.com.passin.dto.Event.EventRequestDTO;
import rocketseat.com.passin.dto.Event.EventRespondeDTO;
import rocketseat.com.passin.repositories.AttendeeRepository;
import rocketseat.com.passin.repositories.EventRepository;

import java.awt.font.TextHitInfo;
import java.text.Normalizer;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;

    public EventRespondeDTO getEventDetail(String eventId) {
        Event event = this.eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found whit ID:" + eventId));
        List<Attendee> attendeeList = this.attendeeRepository.findByEventId(eventId);
        return new EventRespondeDTO(event, attendeeList.size());
    }
    public EventIdDTO createEvent(EventRequestDTO eventDTO) {
        Event newEvent = new Event();
        newEvent.setTitle(eventDTO.title());
        newEvent.setDetails(eventDTO.details());
        newEvent.setMaximumAttendees(eventDTO.maximumAttendees());
        newEvent.setSlug(this.creatSlug(eventDTO.title()));

        this.eventRepository.save(newEvent);

        return new EventIdDTO(newEvent.getId());
    }

    private String creatSlug(String text) {
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{InCOMBINING_DIACRITICAL_MARKS}", "")
                .replaceAll("[^\\w\\s]", "")
                .replaceAll("[\\s+]", "-")
                .toLowerCase();
    }

}
