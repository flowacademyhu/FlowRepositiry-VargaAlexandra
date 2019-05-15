package hu.flowacademy.carsharing.controller;


import hu.flowacademy.carsharing.domain.Car;
import hu.flowacademy.carsharing.domain.Driver;
import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.service.CarService;
import hu.flowacademy.carsharing.service.DriverService;
import hu.flowacademy.carsharing.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/add-car")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.save(car));
    }

    @PutMapping("/update-car")
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.save(car));
    }

    @GetMapping("/list-cars")
    public ResponseEntity<List<Car>> listCar() {
        return ResponseEntity.ok(carService.listItems());
    }
    @DeleteMapping("/delete-car/{id}")
    public void deleteCar(@PathVariable String id) {
        carService.delete(id);
    }

}
