package com.example.app.dao;

import com.example.app.domain.vo.MemberVO;
import com.example.app.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

    //    아이디 중복검사
    public Optional<MemberVO> findByMemberId(String memberId){
        return memberMapper.selectByMemberId(memberId);
    }

    //    회원가입
    public void save(MemberVO memberVO){
        memberMapper.insert(memberVO);
    }

    //    로그인
    public Optional<Long> findByMemberIdAndMemberPassword(String memberId, String memberPassword){
        return memberMapper.selectByMemberIdAndMemberPassword(memberId, memberPassword);
    }

    //    회원 조회
    public Optional<MemberVO> findById(Long id){
        return memberMapper.selectById(id);
    }
}





















