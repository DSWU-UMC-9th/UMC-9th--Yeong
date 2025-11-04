package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewResponse;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.service.ReviewQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")  // <- 공통 prefix
public class ReviewController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/search")
    public List<Review> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ) {
        return reviewQueryService.searchReview(query, type);
    }

    @GetMapping("/my")
    public List<ReviewResponse> getMyReviews(
            @RequestParam(required = false) Long memberId,
            @RequestParam(required = false) String storeName,  // 가게명 필터
            @RequestParam(required = false) Integer ratingGroup // 5, 4, 3 ...
    ) {
        return reviewQueryService.findMyReviews(memberId, storeName, ratingGroup);
    }
}
