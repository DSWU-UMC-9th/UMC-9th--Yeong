package com.example.umc9th.domain.member.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class MemberProfileResponse {
    private String nickname;           // m.name
    private String email;              // m.email
    private String phoneNum;           // m.phoneNum
    private String phoneVerifiedStatus;// "인증 완료"/"미인증"
    private Integer point;             // m.point
}
