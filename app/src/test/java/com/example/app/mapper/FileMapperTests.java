package com.example.app.mapper;

import com.example.app.domain.type.FileType;
import com.example.app.domain.vo.FileVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class FileMapperTests {
    @Autowired
    private FileMapper fileMapper;

    @Test
    public void insertTest(){
        FileVO fileVO = new FileVO();
        fileVO.setFileName("김인진짱.png");
        fileVO.setFileSize(1231231L);
        fileVO.setFileUuid(UUID.randomUUID().toString());
        fileVO.setFilePath("2023/05/18");
        fileVO.setFileType(FileType.REPRESENTATIVE.name());
        fileVO.setPostId(22L);
        fileMapper.insert(fileVO);
    }

    @Test
    public void selectAllTest(){
        fileMapper.selectAll(22L).stream().map(FileVO::toString).forEach(log::info);
    }

    @Test
    public void deleteTest(){
        fileMapper.delete(1L);
        assertThat(fileMapper.selectAll(22L)).hasSize(0);
    }

    @Test
    public void deleteAllTest(){
        fileMapper.deleteAll(22L);
        assertThat(fileMapper.selectAll(22L)).hasSize(0);
    }

    @Test
    public void selectYesterdayTest(){
        final File file = Paths.get("C:/upload", "2023/05/31").toFile();

        Arrays.stream(file.listFiles()).forEach(f -> log.info(f.getAbsolutePath()));
        Arrays.stream(file.listFiles()).forEach(f -> log.info(f.getName()));

//        log.info(fileMapper.selectYesterday().toString());
    }
}
