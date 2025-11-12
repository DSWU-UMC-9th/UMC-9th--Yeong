package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewResponse;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.service.ReviewQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")  // <- 공통 prefix
public class ReviewController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/search")
    public ApiResponse<List<ReviewResponse>> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ) {
        List<Review> reviews = reviewQueryService.searchReview(query, type);
        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                ReviewConverter.toReviewResponseList(reviews)
        );
    }

    @GetMapping("/my")
    public ApiResponse<List<ReviewResponse>> getMyReviews(
            @RequestParam(required = false) Long memberId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Integer ratingGroup
    ) {
        List<ReviewResponse> reviews = reviewQueryService.findMyReviews(memberId, storeName, ratingGroup);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, reviews);
    }
}

