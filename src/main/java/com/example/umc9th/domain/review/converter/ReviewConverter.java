package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.review.dto.ReviewResponse;
import com.example.umc9th.domain.review.entity.Review;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static ReviewResponse toReviewResponse(Review review) {
        return new ReviewResponse(
                review.getReview_id(),
                review.getStore_id().getName(),
                review.getMember_id().getName(),
                review.getScore(),
                review.getContent(),
                review.getCreatedAt()
        );
    }

    public static List<ReviewResponse> toReviewResponseList(List<Review> reviews) {
        return reviews.stream()
                .map(ReviewConverter::toReviewResponse)
                .collect(Collectors.toList());
    }
}
