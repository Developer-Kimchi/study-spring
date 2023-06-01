package com.example.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MemberVO {
    private Long id;
    private String memberId;
    private String memberPassword;
    private String memberName;
    private String memberBirth;
    private String memberPhone;
    private String memberEmail;
}
