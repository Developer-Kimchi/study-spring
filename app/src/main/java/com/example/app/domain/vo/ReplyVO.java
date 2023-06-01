package com.example.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ReplyVO {
    private Long id;
    private String replyContent;
    private String replyRegisterDate;
    private String replyUpdateDate;
    private Long memberId;
    private Long postId;
}
