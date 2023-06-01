package com.example.app.mapper;

import com.example.app.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    //    아이디 중복검사
    public Optional<MemberVO> selectByMemberId(String memberId);

    //    회원가입
    public void insert(MemberVO memberVO);

    //    로그인
    @Select("SELECT ID FROM TBL_MEMBER WHERE MEMBER_ID = #{memberId} AND MEMBER_PASSWORD = #{memberPassword}")
    public Optional<Long> selectByMemberIdAndMemberPassword(@Param("memberId") String memberId, @Param("memberPassword") String memberPassword);

//    회원 조회
    public Optional<MemberVO> selectById(Long id);
}
