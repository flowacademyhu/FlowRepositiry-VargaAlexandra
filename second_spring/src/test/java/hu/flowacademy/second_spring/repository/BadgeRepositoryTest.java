package hu.flowacademy.second_spring.repository;

import hu.flowacademy.second_spring.domain.Badge;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BadgeRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BadgeRepository badgeRepository;

//    @Test
//    public void whenFindName_thenReturnBadge() {
//        Badge badgeShouldBeFound = new Badge("alma", "alma");
//        testEntityManager.persist(badgeShouldBeFound);
//        testEntityManager.flush();
//        Badge badge = badgeRepository.findAll();
//        assert(badge.getName()).i;
//
//    }
}
