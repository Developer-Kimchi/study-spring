package com.app.dependency.dependency.qualifier.task;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public interface Restaurant {
    public final int steak = 50000;
    public boolean isSalad();
}
