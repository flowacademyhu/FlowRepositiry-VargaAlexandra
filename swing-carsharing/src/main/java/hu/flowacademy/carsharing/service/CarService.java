package hu.flowacademy.carsharing.service;

import hu.flowacademy.carsharing.domain.Car;
import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.repository.CarRepository;
import hu.flowacademy.carsharing.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public void delete(String id) {
        carRepository.deleteById(id);

    }
    public List<Car> listItems() {
        return carRepository.findAll();
    }


}
