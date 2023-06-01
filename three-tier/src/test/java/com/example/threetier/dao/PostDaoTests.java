package com.example.threetier.dao;

import com.example.threetier.domain.dao.PostDAO;
import com.example.threetier.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class PostDaoTests {
    @Autowired
    private PostDAO postDAO;
    
    @Test
    public void saveTest(){
        PostVO postVO = new PostVO();
        postVO.setMemberName("한동석");
        postVO.setPostTitle("책 소개");
        postVO.setPostContent("재밌는 책 소개해요!");
        postDAO.save(postVO);
    }

    @Test
    public void findAllTest(){
        assertThat(postDAO.findAll()).hasSize(2);
    }

    @Test
    public void findByIdTest(){
        final Optional<PostVO> foundPost = postDAO.findById(2L);
        foundPost.ifPresent(postVO -> assertThat(postVO.getMemberName()).isEqualTo("한동석"));
//        foundPost.ifPresentOrElse(
//                postVO -> assertThat(postVO.getMemberName()).isEqualTo("한동석")
//                , () -> {log.error("회원 조회 실패");});
//        PostVO post = foundPost.orElseThrow(() -> {throw new RuntimeException();});

//        if(foundPost.isPresent()){
//            foundPost.get();
//        }
//
//        foundPost.ifPresent();
    }

    @Test
    public void setPostVOTest(){
        Optional<PostVO> foundPost = postDAO.findById(2L);
        foundPost.ifPresent(post -> post.setPostContent("수정된 내용"));
        PostVO postVO = foundPost.orElseThrow();
        postDAO.setPostVO(postVO);
        foundPost = postDAO.findById(2L);
        foundPost.ifPresent(post -> assertThat(post.getPostContent()).isEqualTo("수정된 내용"));
    }

    @Test
    public void deleteTest(){
        postDAO.delete(2L);
        assertThat(postDAO.findAll()).hasSize(0);
    }
}
