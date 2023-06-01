package com.example.mybatis.mapper;

import com.example.mybatis.domain.Pay;
import com.example.mybatis.domain.PayDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayMapper {
//    결제 내역
    public List<PayDTO> selectAll(Long memberId);
}
