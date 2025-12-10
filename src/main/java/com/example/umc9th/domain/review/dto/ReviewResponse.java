package com.example.umc9th.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ReviewResponse {
    private Long reviewId;
    private Long storeId;
    private Long memberId;
    private Float score;
    private String content;
    private LocalDateTime createdAt;

}
