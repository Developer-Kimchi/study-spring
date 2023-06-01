package com.example.app.mapper;

import com.example.app.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void insertTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberId("hds1234");
        memberVO.setMemberPassword("1234");
        memberVO.setMemberName("한동석");
        memberVO.setMemberBirth("2000-12-04");
        memberVO.setMemberEmail("hds1234@gmail.com");
        memberVO.setMemberPhone("01012341234");
        memberMapper.insert(memberVO);
    }

    @Test
    public void selectByMemberIdTest(){
        Optional<MemberVO> foundMember = memberMapper.selectByMemberId("lss1234");
        assertThat(foundMember.isPresent()).isEqualTo(false);
    }

    @Test
    public void selectByMemberIdAndMemberPasswordTest(){
        Optional<Long> foundId = memberMapper.selectByMemberIdAndMemberPassword("lss1234", "1234");
        assertThat(foundId.isPresent()).isEqualTo(true);
    }
}


















