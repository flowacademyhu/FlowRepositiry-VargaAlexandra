package hu.flowacademy.carsharing.controller;

import hu.flowacademy.carsharing.domain.Driver;
import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/add-driver")
    public ResponseEntity<Driver> addDriver(@RequestBody Driver driver) {
        return ResponseEntity.ok(driverService.save(driver));
    }

    @PutMapping("/update-driver")
    public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver) {
        return ResponseEntity.ok(driverService.save(driver));
    }

    @GetMapping("/list-drivers")
    public ResponseEntity<List<Driver>> listDriver() {
        return ResponseEntity.ok(driverService.listItems());
    }
    @DeleteMapping("/delete-driver/{id}")
    public void deleteDriver(@PathVariable String id) {
        driverService.delete(id);
    }
}


