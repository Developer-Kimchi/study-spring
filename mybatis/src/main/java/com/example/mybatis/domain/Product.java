package com.example.mybatis.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class Product {
    private Long id;
    private String productName;
    private Long productPrice;
    private Long productStock;
}
