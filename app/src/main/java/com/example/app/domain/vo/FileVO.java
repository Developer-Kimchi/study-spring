package com.example.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class FileVO {
    private Long id;
    private String filePath;
    private String fileUuid;
    private String fileName;
    private Long fileSize;
    private Long postId;
    private String fileType;

}
