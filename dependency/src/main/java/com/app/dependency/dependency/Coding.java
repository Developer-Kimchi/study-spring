package com.app.dependency.dependency;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class Coding {
    private final Computer computer;

}
