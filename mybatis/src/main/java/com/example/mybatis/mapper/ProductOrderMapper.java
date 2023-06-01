package com.example.mybatis.mapper;

import com.example.mybatis.domain.OrderDTO;
import com.example.mybatis.domain.ProductOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductOrderMapper {
//    주문 내역
    public List<ProductOrder> selectProducts(Long orderId);
}
