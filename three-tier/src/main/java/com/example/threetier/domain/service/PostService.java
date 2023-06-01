package com.example.threetier.domain.service;

import com.example.threetier.domain.vo.PostVO;

import java.util.List;
import java.util.Optional;

public interface PostService {
//    게시글 추가
    public void write(PostVO postVO);

//    게시글 목록
    public List<PostVO> getList();

//    게시글 조회
    public Optional<PostVO> getPost(Long id);

//    게시글 수정
    public void modify(PostVO postVO);

//    게시글 삭제
    public void remove(Long id);
}
