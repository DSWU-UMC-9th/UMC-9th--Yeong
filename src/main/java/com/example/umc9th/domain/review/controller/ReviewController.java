package com.example.umc9th.domain.review.controller;
import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewRequest;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.dto.ReviewResponse;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9th.domain.review.service.ReviewQueryService;
import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")   // 공통 URL prefix
public class ReviewController implements ReviewControllerDocs {

    private final ReviewQueryService reviewQueryService;
    private final ReviewService reviewService;

    // 리뷰 추가
    @PostMapping
    @Override
    @Valid
    public ApiResponse<ReviewResponse> addReview(
            @RequestParam Long memberId,
            @RequestBody ReviewRequest request
    ) {
        Review saved = reviewService.createReview(memberId, request);

        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                ReviewConverter.toResponse(saved)
        );
    }

    // 리뷰 목록 조회
    @GetMapping
    @Override
    @Valid
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getReviews(
            @RequestParam String storeName,
            @RequestParam(defaultValue = "1") Integer page

    ) {
        ReviewSuccessCode code = ReviewSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, reviewQueryService.findReview(storeName, page));

    }

    // 검색 API
    @GetMapping("/search")
    @Override
    @Valid
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

    // 내가 쓴 리뷰 조회
    @GetMapping("/my")
    @Override
    @Valid
    public ApiResponse<List<ReviewResponse>> getMyReviews(
            @RequestParam(required = false) Long memberId,
            @RequestParam(required = false) Long storeId,
            @RequestParam(required = false) Float ratingGroup
    ) {
        List<ReviewResponse> reviews = reviewQueryService.findMyReviews(memberId, storeId, ratingGroup);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, reviews);
    }
}
