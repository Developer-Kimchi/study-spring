package com.app.dependency.dependency.qualifier;

import com.app.dependency.dependency.qualifier.task.Restaurant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RestaurantTest {

    @Autowired
    @Qualifier(value="vips")
    private Restaurant restaurant;

    @Test
    public void restaurantTest(){
        log.info(restaurant.toString());
    }
}
