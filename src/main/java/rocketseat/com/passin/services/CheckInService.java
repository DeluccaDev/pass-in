package rocketseat.com.passin.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.com.passin.repositories.ChekinRepository;

@Service
@RequiredArgsConstructor
public class CheckInService {

    private final ChekinRepository chekinRepository;

    public void checkInAttendee(String attendeeId) {

    }
}
