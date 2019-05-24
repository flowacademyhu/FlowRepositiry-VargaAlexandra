package hu.flowacademy.second_spring.controller;


import hu.flowacademy.second_spring.domain.Badge;
import hu.flowacademy.second_spring.service.BadgeService;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(BadgeController.class)

public class BadgeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private BadgeService badgeService;

//    public void givenBadge_whenBadges_thenReturnJsonArray() throws Exception {
//        Badge badgeShouldBeFound = new Badge("alma", "alma");
//
//        List<Badge> badgeList = Arrays.asList(badgeShouldBeFound);
//
//        given(badgeService.listBadges()).willReturn(badgeList);
//
//
//    }

}

