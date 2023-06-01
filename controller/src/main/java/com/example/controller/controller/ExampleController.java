package com.example.controller.controller;

import com.example.controller.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {
    @GetMapping("ex01")
    public void ex01(){
        log.info("ex01.................");
    }

    @GetMapping("ex02")
    public void ex02(@ModelAttribute("name") String name){
        log.info("ex02................. name: {}", name);
    }

    @GetMapping("ex03")
    public void ex03(@RequestParam("name") String data){
        log.info("ex03................. data: {}", data);
    }

    @GetMapping("ex04")
    public void ex04(String name, int age, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        log.info("ex04................. name: {}, age: {}", name, age);
    }

    @GetMapping("ex05")
//    사용자가 만든 객체는 클래스타입 앞 글자만 소문자로 변경하여
//    자동으로 KEY가 생성된다.
    public void ex05(MemberVO memberVO){
        log.info("ex05.................");
        log.info(memberVO.toString());
    }

    @GetMapping("ex06")
    public void ex06(MemberVO memberVO, @ModelAttribute("gender") String gender){
        log.info("ex06.................");
        log.info(memberVO.toString());
        log.info(gender);
    }

    @GetMapping("ex07")
    public void ex07(@RequestParam("data") List<String> datas, Model model){
        log.info("ex07.................");
        log.info(datas.toString());
        model.addAttribute("datas", datas);
    }
}












