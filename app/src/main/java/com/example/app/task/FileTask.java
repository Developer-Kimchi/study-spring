package com.example.app.task;

import com.example.app.domain.vo.FileVO;
import com.example.app.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class FileTask {
    private final FileMapper fileMapper;

    /*
     *   0 * * * * * : 매 분 0초마다
     *   0/1 * * * * : 매 1초 간격
     *   0 0/1 * * * : 매 1분 간격
     *   0 0/5 * ? : 매 5분 간격
     *   0 0 0/1 * * : 매 1시간 간격
     *   0 0 0 * * ? : 매일 0시 마다
     *   0 0 0 1 * ? : 매월 1일 마다
     *   * 10-13 * * * * : 매 10, 11, 12, 13분에 동작한다.
     * */

    @Scheduled(cron = "0 * * * * *")
    public void checkFiles(){
        final List<FileVO> files = fileMapper.selectYesterday();
        final File serverFile = Paths.get("C:/upload", getPathFromYesterday()).toFile();
        final List<Path> paths = files.stream().map(file -> Paths.get("C:/upload/" + file.getFilePath() + "/" + file.getFileUuid() + "_" + file.getFileName()))
                .collect(Collectors.toList());
//        files.stream().filter(FileVO::isImage).map(file -> Paths.get("C:/upload/" + file.getFilePath() + "/t_" + file.getFileUuid() + "_" + file.getFileName()))
//                .forEach(paths::add);

//        이미지 파일이라면(현재 App에서는 모두 이미지) 원본 경로 + 썸네일 경로까지 추가한다.
        files.stream().map(file -> Paths.get("C:/upload/" + file.getFilePath() + "/t_" + file.getFileUuid() + "_" + file.getFileName()))
                .forEach(paths::add);

        Arrays.stream(serverFile.listFiles(f -> !paths.contains(f.toPath()))).forEach(File::delete);
    }

    private String getPathFromYesterday(){
        LocalDate yesterday = LocalDate.now();
        yesterday = yesterday.minusDays(1);
        return DateTimeFormatter.ofPattern("yyyy/MM/dd").format(yesterday);
    }
}
















