package hu.flowacademy.carsharing;

import hu.flowacademy.carsharing.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsharingRepository extends JpaRepository<Reservation, String> {
    
}
