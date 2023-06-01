package com.example.app.dao;

import com.example.app.domain.dto.Pagination;
import com.example.app.domain.dto.PostDTO;
import com.example.app.domain.dto.Search;
import com.example.app.domain.vo.PostVO;
import com.example.app.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

    //    게시글 목록
    public List<PostDTO> findAll(Pagination pagination, Search search){
        return postMapper.selectAll(pagination, search);
    }

    //    게시글 추가
    public void save(PostDTO postDTO){
        postMapper.insert(postDTO);
    }

    //    게시글 조회
    public Optional<PostDTO> findById(Long id){
        return postMapper.select(id);
    }

    //    게시글 수정
    public void setPostDTO(PostDTO postDTO){
        postMapper.update(postDTO);
    }

    //    게시글 삭제
    public void delete(Long id){
        postMapper.delete(id);
    }

    //    게시글 총 개수
    public int findCountOfPost(Search search){
        return postMapper.selectCountOfPost(search);
    }

    //    조회수
    public void updateReadCount(Long id){
        postMapper.updateReadCount(id);
    }
}
