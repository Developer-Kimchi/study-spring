package com.example.app.controller;

import com.example.app.domain.dto.Pagination;
import com.example.app.domain.dto.PostDTO;
import com.example.app.domain.dto.Search;
import com.example.app.domain.vo.PostVO;
import com.example.app.service.MemberService;
import com.example.app.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/post/*")
public class PostController {
    private final PostService postService;
    private final MemberService memberService;
    private final HttpSession session;

    @GetMapping("list")
    public void list(Pagination pagination, Search search, Model model){
        pagination.setTotal(postService.getTotal(search));
        pagination.progress();
        model.addAttribute("posts", postService.getList(pagination, search));
    }

    @GetMapping("write")
    public void goToWriteForm(PostVO postVO, Model model){
        model.addAttribute("memberName", memberService.getMember((Long)session.getAttribute("id")).get().getMemberName());
    }

    @PostMapping("write")
    public RedirectView write(PostDTO postDTO){
        log.info(postDTO.toString());
        postDTO.setMemberId((Long)session.getAttribute("id"));
        postService.write(postDTO);
        return new RedirectView("/post/list");
    }

    @GetMapping(value = {"read", "modify"})
    public void read(Long id, Pagination pagination, Search search, Model model){
        model.addAttribute("post", postService.read(id).get());
    }

    @PostMapping("modify")
    public RedirectView modify(PostDTO postDTO, RedirectAttributes redirectAttributes){
        log.info(postDTO.toString());
        postService.modify(postDTO);
        redirectAttributes.addAttribute("id", postDTO.getId());
        return new RedirectView("/post/read");
    }

    @GetMapping("remove")
    public RedirectView remove(Long id){
        postService.remove(id);
        return new RedirectView("/post/list");
    }
}





















