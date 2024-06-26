package rocketseat.com.passin.dto.Event;

import lombok.Getter;
import rocketseat.com.passin.domain.event.Event;

@Getter
public class EventRespondeDTO {

    EventDetailDTO event;

    public EventRespondeDTO(Event event, Integer numberOfAttendees) {
        this.event = new EventDetailDTO(event.getId(), event.getTitle(), event.getSlug(), event.getDetails(), event.getMaximumAttendees(), numberOfAttendees);
    }
}
