package hu.flowacademy.carsharing.util;

import hu.flowacademy.carsharing.domain.Car;
import hu.flowacademy.carsharing.domain.Driver;
import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.repository.CarRepository;
import hu.flowacademy.carsharing.repository.CarsharingRepository;
import hu.flowacademy.carsharing.repository.DriverRepository;
import hu.flowacademy.carsharing.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CarsharingStartUpRunner implements CommandLineRunner {

    @Autowired
    private CarsharingRepository carsharingRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public void run(String... args) throws Exception {

        Car car1 = new Car("ABC123", "Toyota", "Yaris", 2010, LocalDate.of(2020, 02, 10));
        Car car2 = new Car("DFE123", "Suzuki", "Swift", 2010, LocalDate.of(2020, 02, 10));
        Car car3 = new Car("GHK345", "Ford", "Focus", 2010, LocalDate.of(2020, 02, 10));

        Driver driver1 = new Driver("driver1", "123", "Fullname Driver1", LocalDate.of(2020, 03, 30), true);
        Driver driver2 = new Driver("driver2", "456", "Fullname Driver2", LocalDate.of(2020, 03, 30), true);
        Driver driver3 = new Driver("driver3", "789", "Fullname Driver3", LocalDate.of(2020, 03, 30), true);

        Reservation reservation1 = new Reservation("RES1", LocalDate.of(2019, 04, 30), LocalDate.of(2019, 03, 15), LocalDate.of(2019, 04, 30), car1, driver2);
        Reservation reservation2 = new Reservation("RES2", LocalDate.of(2019, 04, 30), LocalDate.of(2019, 03, 15), LocalDate.of(2019, 04, 30), car1, driver2);
        Reservation reservation3 = new Reservation("RES3", LocalDate.of(2019, 04, 30), LocalDate.of(2019, 03, 15), LocalDate.of(2019, 04, 30), car2, driver3);
        Reservation reservation4 = new Reservation("RES4", LocalDate.of(2019, 04, 30), LocalDate.of(2019, 03, 15), LocalDate.of(2019, 04, 30), car3, driver1);
        Reservation reservation5 = new Reservation("RES5", LocalDate.of(2019, 04, 30), LocalDate.of(2019, 03, 15), LocalDate.of(2019, 04, 30), car3, driver1);


        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);

        driverRepository.save(driver1);
        driverRepository.save(driver2);
        driverRepository.save(driver3);


        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);
        reservationRepository.save(reservation3);
        reservationRepository.save(reservation4);
        reservationRepository.save(reservation5);

    }
}
