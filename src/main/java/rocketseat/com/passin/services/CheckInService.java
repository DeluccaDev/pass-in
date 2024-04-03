package rocketseat.com.passin.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.com.passin.domain.attendee.Attendee;
import rocketseat.com.passin.domain.checkin.Chekin;
import rocketseat.com.passin.domain.checkin.exceptions.CheckInAlreadyExistException;
import rocketseat.com.passin.repositories.ChekinRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckInService {

    private final ChekinRepository chekinRepository;

    public void registerCheckIn(Attendee attendee) {
        this.verifyCheckInExists(attendee.getId());

        Chekin newCheckIn = new Chekin();
        newCheckIn.setAttendee(attendee);
        newCheckIn.setCreatedAt(LocalDateTime.now());

        this.chekinRepository.save(newCheckIn);
    }

    private void verifyCheckInExists(String attendeeId) {
        Optional<Chekin> isCheckIn = this.getCheckIn(attendeeId);
        if (isCheckIn.isPresent()) throw new CheckInAlreadyExistException("Attendee already checked in");
    }

    public Optional<Chekin>getCheckIn(String attendeeId) {
        return this.chekinRepository.findByAttendeeId(attendeeId);
    }
}
