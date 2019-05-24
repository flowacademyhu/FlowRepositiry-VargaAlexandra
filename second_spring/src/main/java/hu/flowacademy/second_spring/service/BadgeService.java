package hu.flowacademy.second_spring.service;

import hu.flowacademy.second_spring.domain.Badge;
import hu.flowacademy.second_spring.exception.BadgeNotFoundException;
import hu.flowacademy.second_spring.repository.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class BadgeService<List> {

    @Autowired
    private BadgeRepository badgeRepository;

    public Badge save(Badge badge) {
        return badgeRepository.save(badge);
    }

    public void delete(String id) {
        try {
            badgeRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new BadgeNotFoundException(id);
        }
    }
    public java.util.List<Badge> listBadges() {
        return badgeRepository.findAll();
    }
    public Badge listOneBadge(String id) {
        if (badgeRepository.findById(id).isPresent()) {
            return badgeRepository.findById(id).get();
        } else {
            throw new BadgeNotFoundException(id);
        }
    }
}
