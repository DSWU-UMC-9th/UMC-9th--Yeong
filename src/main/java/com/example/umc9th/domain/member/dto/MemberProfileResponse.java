package com.example.umc9th.domain.member.dto;

public interface MemberProfileResponse {
    String getNickname();            // m.name AS nickname
    String getEmail();               // m.email
    String getPhoneNum();            // m.phone_num AS phoneNum
    String getPhoneVerifiedStatus(); // CASE WHEN ...
    Integer getPoint();              // m.point
}
