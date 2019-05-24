package hu.flowacademy.second_spring.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @Column
    private String username;

    @Column
    private String fullname;

    @Column
    private String password;

    @Column
    private String role;

    @OneToMany(mappedBy = "owner")
    private List<Badge> badges;

    @ManyToMany
    @JoinTable(
            name= "badge_users",
            joinColumns = @JoinColumn(name = "users_username"),
            inverseJoinColumns = @JoinColumn(name ="badge_id")
    )
    Set<Badge> badge;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Badge> getBadge() {
        return badge;
    }

    public void setBadge(Set<Badge> badge) {
        this.badge = badge;
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

    public User(String username, String fullname, String password, String role) {
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", badges=" + badges +
                ", badge=" + badge +
                '}';
    }
}
