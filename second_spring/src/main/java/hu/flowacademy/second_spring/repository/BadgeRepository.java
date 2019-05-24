package hu.flowacademy.second_spring.repository;

import hu.flowacademy.second_spring.domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgeRepository extends JpaRepository<Badge, String> {

    public void deleteById(String id);
}
