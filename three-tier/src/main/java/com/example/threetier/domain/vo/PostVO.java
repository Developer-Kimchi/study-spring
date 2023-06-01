package com.example.threetier.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PostVO {
    private Long id;
    private String postTitle;
    private String postContent;
    private String postRegisterDate;
    private String postUpdateDate;
    private String memberName;
}
