package com.example.app.controller;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/files/*")
public class FileController {
//    파일 업로드
    @PostMapping("upload")
    @ResponseBody
    public List<String> upload(@RequestParam("uploadFile") List<MultipartFile> uploadFiles) throws IOException {
//        파일 경로 설정
        String path = "C:/upload/" + getPath();
//        파일 uuid 설정
        List<String> uuids = new ArrayList<>();
//        파일 객체 생성
        File file = new File(path);
//        파일이 존재한다면 경로를 만들어라
        if(!file.exists()){file.mkdirs();}

//        반복문으로 파일 만들기
        for (int i=0; i<uploadFiles.size(); i++){
//            uuid 생성
            uuids.add(UUID.randomUUID().toString());
//            파일 경로 및 이름 생성
            uploadFiles.get(i).transferTo(new File(path, uuids.get(i) + "_" + uploadFiles.get(i).getOriginalFilename()));
//            콘텐트 타입이 "image"로 시작한다면
            if(uploadFiles.get(i).getContentType().startsWith("image")){
//                썸네일용 파일 생성
                FileOutputStream out = new FileOutputStream(new File(path, "t_" + uuids.get(i) + "_" + uploadFiles.get(i).getOriginalFilename()));
                Thumbnailator.createThumbnail(uploadFiles.get(i).getInputStream(), out, 100, 100);
//                경로 닫아주기
                out.close();
            }
        }
        return uuids;
    }

//    파일 경로는 현재 날짜로 지정
    public String getPath(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

//    파일 불러오기
    @GetMapping("display")
    @ResponseBody
//    바이트 단위 리턴
    public byte[] display(String fileName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("C:/upload/", fileName));
    }

//    파일 다운로드
    @GetMapping
    public ResponseEntity<Resource> download(String fileName) throws UnsupportedEncodingException {
        Resource resource = new FileSystemResource("C:/upload/" + fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=" + new String(fileName.substring(fileName.indexOf("_") + 1).getBytes("UTF-8"), "ISO-8859"));
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }



}





















