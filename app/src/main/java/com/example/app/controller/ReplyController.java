package com.example.app.controller;

import com.example.app.domain.dto.Pagination;
import com.example.app.domain.dto.ReplyDTO;
import com.example.app.domain.vo.ReplyVO;
import com.example.app.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/replies/*")
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("write")
    public void write(@RequestBody ReplyVO replyVO){
        replyService.write(replyVO);
    }

    @GetMapping("list/{postId}/{page}")
    public List<ReplyDTO> getList(@PathVariable int page, @PathVariable Long postId){
        final Pagination pagination = new Pagination();
        pagination.setPage(page);
        pagination.progress();
        return replyService.getList(postId, pagination);
    }

    @PutMapping("modify")
//    @PatchMapping("modify")
    public void modify(@RequestBody ReplyVO replyVO){
        replyService.modify(replyVO);
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable Long id){
        replyService.remove(id);
    }
}






















