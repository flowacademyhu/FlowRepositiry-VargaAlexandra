package hu.flowacademy.carsharing.controller;


import hu.flowacademy.carsharing.service.CarsharingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/carsharing")
public class CarsharingController {

    @Autowired
    private CarsharingService carsharingService;

    @PostMapping("/add")


}
