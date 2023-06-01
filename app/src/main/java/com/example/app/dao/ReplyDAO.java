package com.example.app.dao;

import com.example.app.domain.dto.Pagination;
import com.example.app.domain.dto.ReplyDTO;
import com.example.app.domain.vo.ReplyVO;
import com.example.app.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyDAO {
    private final ReplyMapper replyMapper;

    //    댓글 목록
    public List<ReplyDTO> findAll(Long id, Pagination pagination){
        return replyMapper.selectAll(id, pagination);
    }

    //    댓글 작성
    public void save(ReplyVO replyVO){
        replyMapper.insert(replyVO);
    }

    //    댓글 수정
    public void setReply(ReplyDTO replyDTO){
        replyMapper.update(replyDTO);
    }

    //    댓글 삭제
    public void delete(Long id){
        replyMapper.delete(id);
    }

    //    게시글의 댓글 전체 삭제
    public void deleteAll(Long postId){
        replyMapper.deleteAll(postId);
    }
}
