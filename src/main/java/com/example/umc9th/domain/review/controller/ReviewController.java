//package com.example.umc9th.domain.review.controller;
//
//import com.example.umc9th.domain.review.converter.ReviewConverter;
//import com.example.umc9th.domain.review.dto.ReviewRequest;
//import com.example.umc9th.domain.review.dto.ReviewResponse;
//import com.example.umc9th.domain.review.entity.Review;
//import com.example.umc9th.domain.review.service.ReviewQueryService;
//import com.example.umc9th.domain.review.service.ReviewService;
//import com.example.umc9th.global.apiPayload.ApiResponse;
//import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/reviews")  // <- 공통 prefix
//public class ReviewController {
//
//    private final ReviewQueryService reviewQueryService;
//    private final ReviewService reviewService;
//
//    // 가게에 리뷰 추가하기 API
//    @PostMapping
//    public ApiResponse<ReviewResponse> addReview(
//            @RequestParam Long memberId,
//            @RequestBody ReviewRequest request
//            //@RequestHeader("Authorization") String token
//
//    ) {
//        //String accessToken = token.replace("Bearer ", "");
//
//        Review saved = reviewService.createReview(memberId, request);
//
//        return ApiResponse.onSuccess(
//                GeneralSuccessCode.OK,
//                ReviewConverter.toResponse(saved)
//        );
//    }
//
//
//    @GetMapping("/search")
//    public ApiResponse<List<ReviewResponse>> searchReview(
//            @RequestParam String query,
//            @RequestParam String type
//    ) {
//        List<Review> reviews = reviewQueryService.searchReview(query, type);
//        return ApiResponse.onSuccess(
//                GeneralSuccessCode.OK,
//                ReviewConverter.toReviewResponseList(reviews)
//        );
//    }
//
//    @GetMapping("/my")
//    public ApiResponse<List<ReviewResponse>> getMyReviews(
//            @RequestParam(required = false) Long memberId,
//            @RequestParam(required = false) Long storeId,
//            @RequestParam(required = false) Integer ratingGroup
//    ) {
//        List<ReviewResponse> reviews = reviewQueryService.findMyReviews(memberId, storeId, ratingGroup);
//        return ApiResponse.onSuccess(GeneralSuccessCode.OK, reviews);
//    }
//}
//
