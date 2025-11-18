//package com.example.umc9th.domain.review.converter;
//
//import com.example.umc9th.domain.member.entity.Member;
//import com.example.umc9th.domain.member.repository.MemberRepository;
//import com.example.umc9th.domain.review.dto.ReviewRequest;
//import com.example.umc9th.domain.review.dto.ReviewResponse;
//import com.example.umc9th.domain.review.entity.Review;
//import com.example.umc9th.domain.store.entity.Store;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class ReviewConverter {
//
//    public static Review toEntity(Member member, Store store, ReviewRequest reviewRequest) {
//        return Review.builder()
//                .member_id(member)
//                .store_id(store)
//                .score(reviewRequest.getScore())
//                .content(reviewRequest.getContent())
//                .build();
//    }
//
//
//    public static ReviewResponse toResponse(Review review) {
//        return ReviewResponse.builder()
//                .reviewId(review.getReview_id())
//                .storeId(review.getStore_id().getStore_id())
//                .memberId(review.getMember_id().getMember_id())
//                .score(review.getScore())
//                .content(review.getContent())
//                .createdAt(review.getCreatedAt())
//                .build();
//    }
//
//    public static ReviewResponse toReviewResponse(Review review) {
//        return new ReviewResponse(
//                review.getReview_id(),
//                review.getStore_id().getStore_id(),
//                review.getMember_id().getMember_id(),
//                review.getScore(),
//                review.getContent(),
//                review.getCreatedAt()
//        );
//    }
//
//    public static List<ReviewResponse> toReviewResponseList(List<Review> reviews) {
//        return reviews.stream()
//                .map(ReviewConverter::toReviewResponse)
//                .collect(Collectors.toList());
//    }
//}
