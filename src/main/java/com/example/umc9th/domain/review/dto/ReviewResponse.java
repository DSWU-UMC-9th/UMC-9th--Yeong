package com.example.umc9th.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ReviewResponse {
    private Long reviewId;
    private String storeName;
    private String memberName;
    private Integer score;
    private String content;
    private LocalDateTime createdAt;

    public ReviewResponse(Long reviewId, String storeName, String content, Integer rating) {
        this.reviewId = reviewId;
        this.storeName = storeName;
        this.content = content;
        this.score = rating;
    }
}