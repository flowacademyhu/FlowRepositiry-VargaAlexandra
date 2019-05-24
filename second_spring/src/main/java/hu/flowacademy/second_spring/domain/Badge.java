package hu.flowacademy.second_spring.domain;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Set;

@Entity
@Table(name="badge")
public class Badge {

    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private byte[] content;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_badge_user_id"))
    private User owner;

    @ManyToMany(mappedBy = "badge")
    Set<User> users;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }


    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Badge() {
    }

    public Badge(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Badge{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", content=" + Arrays.toString(content) +
                ", owner=" + owner +
                ", users=" + users +
                '}';
    }
}
