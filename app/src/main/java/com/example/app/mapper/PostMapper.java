package com.example.app.mapper;

import com.example.app.domain.dto.Pagination;
import com.example.app.domain.dto.PostDTO;
import com.example.app.domain.dto.Search;
import com.example.app.domain.vo.MemberVO;
import com.example.app.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
    //    게시글 목록
    public List<PostDTO> selectAll(@Param("pagination") Pagination pagination, @Param("search")Search search);

    //    게시글 추가
    public void insert(PostDTO postDTO);

    //    게시글 조회
    public Optional<PostDTO> select(Long id);

    //    게시글 수정
    public void update(PostDTO postDTO);

    //    게시글 삭제
    public void delete(Long id);

    //    게시글 총 개수
    public int selectCountOfPost(@Param("search") Search search);

//    조회수
    public void updateReadCount(Long id);
}
