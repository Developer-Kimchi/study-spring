package com.example.controller.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class StudentVO {
    private int number;
    private int kor;
    private int eng;
    private int math;

    public int getTotal(){
        return kor + eng + math;
    }

    public double getAverage(){
        return getTotal() / 3.0;
    }
}
