package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.review.dto.ReviewRequest;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.dto.ReviewResponse;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static Review toEntity(Member member, Store store, ReviewRequest reviewRequest) {
        return Review.builder()
                .member(member)
                .store(store)
                .score(reviewRequest.getScore())
                .content(reviewRequest.getContent())
                .build();
    }


    public static ReviewResponse toResponse(Review review) {
        return ReviewResponse.builder()
                .reviewId(review.getReviewId())
                .storeId(review.getStore().getStoreId())
                .memberId(review.getMember().getMemberId())
                .score(review.getScore())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static ReviewResponse toReviewResponse(Review review) {
        return new ReviewResponse(
                review.getReviewId(),
                review.getStore().getStoreId(),
                review.getMember().getMemberId(),
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

    // result -> DTO
    public static ReviewResDTO.ReviewPreViewListDTO toReviewPreviewListDTO(
            Page<Review> result
    ){
        return ReviewResDTO.ReviewPreViewListDTO.builder()
                .reviewList(result.getContent().stream()
                        .map(ReviewConverter::toReviewPreviewDTO)
                        .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static ReviewResDTO.ReviewPreViewDTO toReviewPreviewDTO(
            Review review
    ){
        return ReviewResDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .body(review.getContent())
                .createdAt(LocalDate.from(review.getCreatedAt()))
                .build();
}}
