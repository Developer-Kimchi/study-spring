package com.example.threetier.mapper;

import com.example.threetier.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
//    게시글 추가
    public void insert(PostVO postVO);

//    게시글 목록
    public List<PostVO> selectAll();

//    게시글 조회
    public Optional<PostVO> select(Long id);

//    게시글 수정
    public void update(PostVO postVO);

//    게시글 삭제
    public void delete(Long id);
}
