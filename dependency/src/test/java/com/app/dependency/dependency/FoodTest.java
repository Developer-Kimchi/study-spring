package com.app.dependency.dependency;

import com.app.dependency.dependency.task.Food;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class FoodTest {

    @Autowired
    private Food food;

    @Test
    public void foodTest() {
        log.info(food.getKnife().toString());
    }

}
