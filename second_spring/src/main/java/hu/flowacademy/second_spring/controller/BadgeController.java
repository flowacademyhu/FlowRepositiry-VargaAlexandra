package hu.flowacademy.second_spring.controller;

import hu.flowacademy.second_spring.domain.Badge;
import hu.flowacademy.second_spring.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BadgeController {

    @Autowired
    private BadgeService badgeService;

    @PostMapping("/add")
    public ResponseEntity<Badge> addBadge(@RequestBody Badge badge) {
        return ResponseEntity.ok(badgeService.save(badge));
    }

    @PutMapping("/update")
    public ResponseEntity<Badge> updateBadge(@RequestBody Badge badge) {
        return ResponseEntity.ok(badgeService.save(badge));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBadge(@PathVariable String id) {
        badgeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/badge/{id}")
    public ResponseEntity<Badge> listOneBadge(@PathVariable String id) {
        return ResponseEntity.ok(badgeService.listOneBadge(id));
    }

    @GetMapping("/badges")
    public ResponseEntity<List<Badge>> listAllBadges() {
        return ResponseEntity.ok(badgeService.listBadges());
    }

}
