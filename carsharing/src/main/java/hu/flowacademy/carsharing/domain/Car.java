package hu.flowacademy.carsharing;

import javax.persistence.*;
import java.util.List;
import java.time.LocalDate;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @Column
    private String plateNumber;
    @Column
    private String brand;
    @Column
    private String type;
    @Column
    private int year;
    @Column
    private LocalDate technicalExam;

    @OneToMany
    @JoinColumn(name="car_id")
    private List<Reservation> reservation;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalDate getTechnicalExam() {
        return technicalExam;
    }

    public void setTechnicalExam(LocalDate technicalExam) {
        this.technicalExam = technicalExam;
    }
}
