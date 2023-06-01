package com.app.dependency.dependency.task;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@Component
@RequiredArgsConstructor
public class Food {
    private final Knife knife;
}
