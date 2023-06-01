package com.example.app.mapper;

import com.example.app.domain.dto.Pagination;
import com.example.app.domain.dto.ReplyDTO;
import com.example.app.domain.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {
//    댓글 목록
    public List<ReplyDTO> selectAll(@Param("id") Long id, @Param("pagination") Pagination pagination);

//    댓글 작성
    public void insert(ReplyVO replyVO);

//    댓글 수정
    public void update(ReplyDTO replyDTO);

//    댓글 삭제
    public void delete(Long id);

//    게시글의 댓글 전체 삭제
    public void deleteAll(Long postId);
}
