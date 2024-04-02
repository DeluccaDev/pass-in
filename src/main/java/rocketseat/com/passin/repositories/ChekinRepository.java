package rocketseat.com.passin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rocketseat.com.passin.domain.checkin.Chekin;

public interface ChekinRepository extends JpaRepository<Chekin, Integer> {
}
