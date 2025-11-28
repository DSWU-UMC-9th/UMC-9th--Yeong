package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.dto.ReviewResponse;
import com.example.umc9th.domain.review.entity.Review;

import com.querydsl.core.types.Predicate;


import java.util.List;

public interface ReviewQueryDsl {
    //검색 API
    List<Review> searchReview(Predicate predicate);
    List<ReviewResponse> findMyReviews(Predicate predicate);
    ReviewResDTO.ReviewPreViewListDTO findReview(Predicate predicate);
}
