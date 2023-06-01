package com.app.dependency.dependency.qualifier.task;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Data
@Qualifier(value="vips")
public class Vips implements Restaurant {

    private int steak = Restaurant.steak - 10000;

    @Override
    public boolean isSalad() {
        return true;
    }
}
