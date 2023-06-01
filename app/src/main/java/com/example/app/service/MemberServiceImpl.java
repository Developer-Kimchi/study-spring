package com.example.app.service;

import com.example.app.dao.MemberDAO;
import com.example.app.domain.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;

    @Override
    public Optional<MemberVO> checkId(String memberId) {
        return memberDAO.findByMemberId(memberId);
    }

    @Override
    public void join(MemberVO memberVO) {
        memberDAO.save(memberVO);
    }

    @Override
    public Optional<Long> login(String memberId, String memberPassword) {
        return memberDAO.findByMemberIdAndMemberPassword(memberId, memberPassword);
    }

    @Override
    public Optional<MemberVO> getMember(Long id) {
        return memberDAO.findById(id);
    }
}
