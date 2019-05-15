package hu.flowacademy.carsharing.repository;

import hu.flowacademy.carsharing.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
    public void deleteById(String id);
}
