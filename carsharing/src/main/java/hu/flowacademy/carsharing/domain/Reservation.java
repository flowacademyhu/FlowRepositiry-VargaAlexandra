package hu.flowacademy.carsharing;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Column
    @Id
    private String reservationId;

    @Column
    private LocalDate reservationEndDate;

    @Column
    private LocalDate reservationStartDate;

    @Column
    private LocalDate destination;

    @ManyToOne
    @JoinColumn(name="car_id",foreignKey = @ForeignKey(name = "fk_reservation_car"))
    private Car car;

    @ManyToOne
    @JoinColumn(name="driver_id",foreignKey = @ForeignKey(name = "fk_reservation_driver"))
    private Driver driver;

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDate getReservationEndDate() {
        return reservationEndDate;
    }

    public void setReservationEndDate(LocalDate reservationEndDate) {
        this.reservationEndDate = reservationEndDate;
    }

    public LocalDate getReservationStartDate() {
        return reservationStartDate;
    }

    public void setReservationStartDate(LocalDate reservationStartDate) {
        this.reservationStartDate = reservationStartDate;
    }

    public LocalDate getDestination() {
        return destination;
    }

    public void setDestination(LocalDate destination) {
        this.destination = destination;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
