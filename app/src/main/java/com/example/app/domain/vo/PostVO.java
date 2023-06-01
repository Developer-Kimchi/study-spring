package com.example.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
@NoArgsConstructor
public class PostVO {
    private Long id;
    private String postTitle;
    private String postContent;
    private String postRegisterDate;
    private String postUpdateDate;
    private Long postReadCount;
    private Long memberId;
}
