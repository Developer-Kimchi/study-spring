package com.example.app.dao;

import com.example.app.domain.vo.FileVO;
import com.example.app.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;

    //    파일 추가
    public void save(FileVO fileVO){
        fileMapper.insert(fileVO);
    }

    //    파일 삭제
    public void delete(Long id){
        fileMapper.delete(id);
    }

    //    게시글의 파일 전체 삭제
    public void deleteAll(Long postId){
        fileMapper.deleteAll(postId);
    }

    //    파일 조회
    public List<FileVO> findAll(Long postId){
        return fileMapper.selectAll(postId);
    }
}
