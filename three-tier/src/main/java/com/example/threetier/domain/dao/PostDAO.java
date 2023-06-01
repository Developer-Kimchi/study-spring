package com.example.threetier.domain.dao;

import com.example.threetier.domain.vo.PostVO;
import com.example.threetier.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

//    게시글 추가
    public void save(PostVO postVO){
        postMapper.insert(postVO);
    }

//    게시글 목록
    public List<PostVO> findAll(){
        return postMapper.selectAll();
    }

//    게시글 조회
    public Optional<PostVO> findById(Long id){
        return postMapper.select(id);
    }

//    게시글 수정
    public void setPostVO(PostVO postVO){
        postMapper.update(postVO);
    }

//    게시글 삭제
    public void delete(Long id){
        postMapper.delete(id);
    }
}
