package hu.flowacademy.carsharing.service;

import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.repository.CarsharingRepository;
import hu.flowacademy.carsharing.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void delete(String id) {
        reservationRepository.deleteById(id);

    }
    public List<Reservation> listItems() {
        return reservationRepository.findAll();
    }



}
