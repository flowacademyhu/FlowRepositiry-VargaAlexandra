package hu.flowacademy.carsharing.domain;

import javax.persistence.*;
import java.util.List;
import java.time.LocalDate;

@Entity
@Table(name="drivers")
public class Driver {

    @Id
    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String fullname;

    @Column
    private LocalDate licenceExpireDate;

    @Column
    private boolean isActive;

    @Transient
    @OneToMany(mappedBy = "driver")
    private List<Reservation> reservation;

    public Driver() {
    }

    public Driver(String login, String password, String fullname, LocalDate licenceExpireDate, boolean isActiven) {
        this.login = login;
        this.password = password;
        this.fullname = fullname;
        this.licenceExpireDate = licenceExpireDate;
        this.isActive = isActive;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getLicenceExpireDate() {
        return licenceExpireDate;
    }

    public void setLicenceExpireDate(LocalDate licenceExpireDate) {
        this.licenceExpireDate = licenceExpireDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
