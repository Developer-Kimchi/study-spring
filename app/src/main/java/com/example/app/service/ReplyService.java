package com.example.app.service;

import com.example.app.domain.dto.Pagination;
import com.example.app.domain.dto.ReplyDTO;
import com.example.app.domain.vo.ReplyVO;

import java.util.List;

public interface ReplyService {
    //    댓글 목록
    public List<ReplyDTO> getList(Long id, Pagination pagination);

    //    댓글 작성
    public void write(ReplyVO replyVO);

    //    댓글 수정
    public void modify(ReplyVO replyVO);

    //    댓글 삭제
    public void remove(Long id);

    //    게시글의 댓글 전체 삭제
    public void removeAll(Long postId);

    default ReplyDTO toDTO(ReplyVO replyVO){
        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setId(replyVO.getId());
        replyDTO.setMemberId(replyVO.getMemberId());
        replyDTO.setReplyContent(replyVO.getReplyContent());
        replyDTO.setPostId(replyVO.getPostId());
        replyDTO.setReplyRegisterDate(replyVO.getReplyRegisterDate());
        replyDTO.setReplyUpdateDate(replyVO.getReplyUpdateDate());
        return replyDTO;
    }
}
