package com.example.app.mapper;

import com.example.app.domain.dto.Pagination;
import com.example.app.domain.dto.ReplyDTO;
import com.example.app.domain.vo.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class ReplyMapperTests {
    @Autowired
    private ReplyMapper replyMapper;

    @Test
    public void insertTest(){
        ReplyVO replyVO = new ReplyVO();
        replyVO.setReplyContent("댓글 내용 테스트2");
        replyVO.setMemberId(21L);
        replyVO.setPostId(1L);
        replyMapper.insert(replyVO);
    }

    @Test
    public void selectAllTest(){
        Pagination pagination = new Pagination();
        pagination.setPage(1);
//        assertThat(replyMapper.selectAll(22L, pagination)).hasSize(1);
        replyMapper.selectAll(22L, pagination).stream().map(ReplyDTO::toString).forEach(log::info);
    }

    @Test
    public void updateTest(){
        Pagination pagination = new Pagination();
        pagination.setPage(1);
        final ReplyDTO replyDTO = replyMapper.selectAll(1L, pagination).get(0);
        replyDTO.setReplyContent("수정된 내용");
        replyMapper.update(replyDTO);

        assertThat(replyMapper.selectAll(1L, pagination).get(0).getReplyContent()).isEqualTo("수정된 내용");
    }

    @Test
    public void deleteTest(){
        IntStream.rangeClosed(2, 3).forEach(i -> replyMapper.delete(Long.valueOf(i)));
    }

    @Test
    public void deleteAllTest(){
        replyMapper.deleteAll(1L);
    }

}
