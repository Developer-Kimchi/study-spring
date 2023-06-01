package com.example.mybatis.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class OrderDTO {
    private Long id;
    private Long memberId;
    private String memberName;
    private List<Product> products = new ArrayList<>();
}
