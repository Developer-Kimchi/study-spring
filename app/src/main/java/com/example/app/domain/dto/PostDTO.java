package com.example.app.domain.dto;

import com.example.app.domain.vo.FileVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class PostDTO {
    private Long id;
    private String postTitle;
    private String postContent;
    private String postRegisterDate;
    private String postUpdateDate;
    private Long postReadCount;
    private Long memberId;
    private String memberName;
    private List<FileVO> files = new ArrayList<>();
    private List<Long> fileIdsForDelete = new ArrayList<>();
}
