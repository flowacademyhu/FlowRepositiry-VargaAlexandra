package hu.flowacademy.second_spring.repository;

import hu.flowacademy.second_spring.domain.Badge;
import hu.flowacademy.second_spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, String> {

    public void deleteById(String id);

}
