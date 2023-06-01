package com.example.mybatis.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@NoArgsConstructor
public class PayDTO {
    private Long id;
    private Long orderId;
    private List<OrderDTO> orders = new ArrayList<>();
}
