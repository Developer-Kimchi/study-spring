package com.example.threetier.controller;

import com.example.threetier.domain.service.PostService;
import com.example.threetier.domain.vo.PostVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequestMapping("/post/*")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

//    리스트를 모델객체를 통해 뿌려주기
    @GetMapping("list")
    public void showList(Model model){
        model.addAttribute("posts", postService.getList());
    }

//    게시글 상세
    @GetMapping(value = {"read", "modify"})
    public void read(Long id, Model model){
        model.addAttribute("post", postService.getPost(id));
    }

//    게시글 작성하러 가기
    @GetMapping("write")
    public void goToWriteForm(PostVO postVO){;}

//    게시글 작성 완료
    @PostMapping("write")
    public RedirectView write(PostVO postVO){
        postService.write(postVO);
//        화면으로 이동이 아닌 컨트롤러로 이동하고자 할 때
//        Redirect로 전송해야 한다.
        return new RedirectView("/post/list");
    }

    @PostMapping("modify")
//    수정 완료
    public RedirectView modify(PostVO postVO, RedirectAttributes redirectAttributes){
        postService.modify(postVO);
//        다음 컨트롤러에 전달할 데이터는 쿼리 스트링(addAttribute(key, value))을 사용한다.
//        화면에 바로 전달할 데이터는 세션의 플래시(addFlashAttribute(key, value))를 사용한다.
        redirectAttributes.addAttribute("id", postVO.getId());
        return new RedirectView("/post/read");
    }

//    삭제
    @GetMapping("remove")
    public RedirectView remove(Long id){
        postService.remove(id);
        return new RedirectView("/post/list");
    }
}



















