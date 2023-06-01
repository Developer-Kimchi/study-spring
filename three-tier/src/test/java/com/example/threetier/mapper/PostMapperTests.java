package com.example.threetier.mapper;

import com.example.threetier.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class PostMapperTests {
    @Autowired
    private PostMapper postMapper;

    @Test
    public void insertTest(){
        PostVO postVO = new PostVO();
        postVO.setMemberName("한동석");
        postVO.setPostTitle("책 소개");
        postVO.setPostContent("재밌는 책 소개해요!");
        postMapper.insert(postVO);
    }

    @Test
//    assertThat -> 스테틱 메소드로, 선언 없이 바로 임포트해서 사용
    public void selectAllTest(){
        assertThat(postMapper.selectAll()).hasSize(2);
    }

    @Test
    public void selectTest(){
//        옵셔널 객체로 선언
        final Optional<PostVO> foundPost = postMapper.select(4L);
//        옵셔널 객체의 메소드를 통해 람다로 데이터 존재 유무 검증
        foundPost.ifPresent(postVO -> assertThat(postVO.getMemberName()).isEqualTo("한동석"));
        foundPost.ifPresentOrElse(
                postVO -> assertThat(postVO.getMemberName()).isEqualTo("한동석")
                , () -> {log.error("회원 조회 실패");});
//        PostVO post = foundPost.orElseThrow(() -> {throw new RuntimeException();});

//        if(foundPost.isPresent()){
//            foundPost.get();
//        }
//
//        foundPost.ifPresent();
    }

    @Test
    public void updateTest(){
//        게시글을 조회
        Optional<PostVO> foundPost = postMapper.select(1L);
//        게시글이 존재한다면, 해당 게시글에서 수정된 내용을 setter메소드를 통해 반영
        foundPost.ifPresent(post -> post.setPostContent("수정된 내용"));
//        VO객체에 수정된 내용 전달, 오류 발생시 Exception 실행
        PostVO postVO = foundPost.orElseThrow();
//       매퍼 업데이트 메소드 실행
        postMapper.update(postVO);
//        옵셔널 객체에 변경된 게시글을 전달
        foundPost = postMapper.select(1L);
//        검증
        foundPost.ifPresent(post -> assertThat(post.getPostContent()).isEqualTo("수정된 내용"));
    }

    @Test
    public void deleteTest(){
//        매퍼인터페이스에서 삭제 메소드 실행
        postMapper.delete(1L);
//        검증
        assertThat(postMapper.selectAll()).hasSize(1);
    }
}













