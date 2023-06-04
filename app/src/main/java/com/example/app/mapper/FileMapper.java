package com.example.app.mapper;

import com.example.app.domain.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
//    파일 추가
    public void insert(FileVO fileVO);

//    파일 삭제
    public void delete(Long id);

//    게시글의 파일 전체 삭제
    public void deleteAll(Long postId);

//    파일 조회
    public List<FileVO> selectAll(Long postId);

//    어제 날짜 파일 조회
    public List<FileVO> selectYesterday();
}
