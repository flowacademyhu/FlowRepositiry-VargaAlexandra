package hu.flowacademy.carsharing.service;

import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.repository.CarsharingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarsharingService {

    @Autowired
    private CarsharingRepository carsharingRepository;

    public Reservation save(Reservation reservation) {
        return carsharingRepository.save(reservation);
    }

    public void delete(String id) {
        carsharingRepository.deleteById(id);

    }


}
