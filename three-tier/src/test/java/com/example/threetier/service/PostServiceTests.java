package com.example.threetier.service;

import com.example.threetier.domain.service.PostService;
import com.example.threetier.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class PostServiceTests {
    @Autowired
    private PostService postService;

    @Test
    public void writeTest(){
        PostVO postVO = new PostVO();
        postVO.setMemberName("한동석");
        postVO.setPostTitle("책 소개");
        postVO.setPostContent("재밌는 책 소개해요!");
        postService.write(postVO);
    }

    @Test
    public void getListTest(){
        assertThat(postService.getList()).hasSize(1);
    }

    @Test
    public void getPostTest(){
        final Optional<PostVO> foundPost = postService.getPost(3L);
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
    public void modifyTest(){
        Optional<PostVO> foundPost = postService.getPost(3L);
        foundPost.ifPresent(post -> post.setPostContent("수정된 내용"));
        PostVO postVO = foundPost.orElseThrow();
        postService.modify(postVO);
        foundPost = postService.getPost(3L);
        foundPost.ifPresent(post -> assertThat(post.getPostContent()).isEqualTo("수정된 내용"));
    }

    @Test
    public void removeTest(){
        postService.remove(3L);
        assertThat(postService.getList()).hasSize(0);
    }
}
