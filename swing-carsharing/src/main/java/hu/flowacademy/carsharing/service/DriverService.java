package hu.flowacademy.carsharing.service;

import hu.flowacademy.carsharing.domain.Driver;
import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.repository.DriverRepository;
import hu.flowacademy.carsharing.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@Transactional
public class DriverService {


    @Autowired
    private DriverRepository driverRepositoryRepository;

    public Driver save(Driver driver) {
        return driverRepositoryRepository.save(driver);
    }

    public void delete(String id) {
        driverRepositoryRepository.deleteById(id);

    }
    public List<Driver> listItems() {
        return driverRepositoryRepository.findAll();
    }

}
