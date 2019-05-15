package hu.flowacademy.carsharing.controller;

import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/add")
    public ResponseEntity<Reservation> addReservatoon(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.save(reservation));
    }

    @PutMapping("/update")
        public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.save(reservation));
    }

    @GetMapping("/list-items")
    public ResponseEntity<List<Reservation>> listReservations() {
        return ResponseEntity.ok(reservationService.listItems());
    }
    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable String id) {
        reservationService.delete(id);
    }
}
