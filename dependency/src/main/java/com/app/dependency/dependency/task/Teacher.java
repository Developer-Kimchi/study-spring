package com.app.dependency.dependency.task;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@RequiredArgsConstructor
public class Teacher {
    private final Class aClass;
    private final School school;
    private List<Student> students = new ArrayList<>();
}
