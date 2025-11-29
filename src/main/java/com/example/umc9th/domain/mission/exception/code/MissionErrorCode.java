package com.example.umc9th.domain.mission.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@Getter
@RequiredArgsConstructor
public enum MissionErrorCode implements BaseErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND,
            "REVIEW404_1",
            "해당 리뷰를 찾을 수 없습니다."),

    INVALID_REQUEST(HttpStatus.BAD_REQUEST,
            "REVIEW400_1",
            "잘못된 요청입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
