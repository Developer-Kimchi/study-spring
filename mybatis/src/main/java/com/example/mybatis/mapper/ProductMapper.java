package com.example.mybatis.mapper;

import com.example.mybatis.domain.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
//    상품 조회
    public Product select(Long id);
}
