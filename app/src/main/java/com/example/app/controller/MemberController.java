package com.example.app.controller;

import com.example.app.domain.vo.MemberVO;
import com.example.app.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member/*")
public class MemberController {
    private final MemberService memberService;
    
//    아이디 중복검사
    @GetMapping("check-id/{memberId}")
    @ResponseBody
    public boolean checkId(@PathVariable String memberId){
        return memberService.checkId(memberId).isPresent();
    }

//    회원가입
    @GetMapping("join")
    public void goToJoinForm(MemberVO memberVO){;}

    @PostMapping("join")
    public RedirectView join(MemberVO memberVO){
        memberService.join(memberVO);
        return new RedirectView("/member/login");
    }

//    로그인
    @GetMapping("login")
    public void goToLoginForm(MemberVO memberVO){;}

    @PostMapping("login")
    public RedirectView login(String memberId, String memberPassword, HttpSession session, RedirectAttributes redirectAttributes){
        final Optional<Long> foundMember = memberService.login(memberId, memberPassword);
        if(foundMember.isPresent()){
            session.setAttribute("id", foundMember.get());
            return new RedirectView("/post/list");
        }
        redirectAttributes.addFlashAttribute("login", "fail");
        return new RedirectView("/member/login");
    }

//    로그아웃
    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/member/login");
    }

}





















