package com.example.umc9th.domain.mission.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MissionSuccessCode implements BaseSuccessCode {

    FOUND(HttpStatus.OK,
            "REVIEW200_1",
                    "성공적으로 리뷰를 조회했습니다."),
            ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
