package com.example.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReplyDTO {
    private Long id;
    private String replyContent;
    private String replyRegisterDate;
    private String replyUpdateDate;
    private Long memberId;
    private Long postId;
    private String memberName;
}
