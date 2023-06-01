package com.app.dependency.dependency.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@RequiredArgsConstructor
public class Student {
    private final Class aClass;
    private final Teacher teacher;
    private final School school;
}
