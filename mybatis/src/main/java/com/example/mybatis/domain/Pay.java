package com.example.mybatis.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class Pay {
    private Long id;
    private Long orderId;
}
