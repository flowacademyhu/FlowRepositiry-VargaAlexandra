package hu.flowacademy.carsharing;

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

    @OneToMany
    @JoinColumn(name="driver_id")
    private List<Reservation> reservation;

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
