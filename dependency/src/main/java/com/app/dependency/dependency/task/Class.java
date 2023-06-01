package com.app.dependency.dependency.task;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@RequiredArgsConstructor
public class Class {
    private final School school;
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
}
