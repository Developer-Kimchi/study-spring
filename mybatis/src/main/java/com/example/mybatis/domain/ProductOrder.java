package com.example.mybatis.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductOrder {
    private Long id;
    private Long productId;
    private Long orderId;
}
