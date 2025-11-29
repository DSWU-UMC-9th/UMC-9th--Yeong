package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public interface ReviewQueryService {


    ReviewResDTO.ReviewPreViewListDTO findMyReviews(Long memberId,Integer page, Long storeId, Float ratingGroup);

    List<Review> searchReview(String query, String type);

    ReviewResDTO.ReviewPreViewListDTO findReview(String storeName, Integer page);
}
