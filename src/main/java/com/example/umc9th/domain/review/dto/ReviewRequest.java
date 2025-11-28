package com.example.umc9th.domain.review.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewRequest {
    private Long storeId;
    private Float score;
    private String content;
}
