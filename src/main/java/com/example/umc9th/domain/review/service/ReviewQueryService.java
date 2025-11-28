package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.dto.ReviewResponse;
import com.example.umc9th.domain.review.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public interface ReviewQueryService {


    List<ReviewResponse> findMyReviews(Long memberId, Long storeId, Float ratingGroup);

    List<Review> searchReview(String query, String type);

    ReviewResDTO.ReviewPreViewListDTO findReview(String storeName, Integer page);
}
