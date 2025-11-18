//package com.example.umc9th.domain.review.service;
//
//import com.example.umc9th.domain.location.entity.QLocation;
//import com.example.umc9th.domain.member.entity.QMember;
//import com.example.umc9th.domain.review.dto.ReviewResponse;
//import com.example.umc9th.domain.review.entity.QReview;
//import com.example.umc9th.domain.review.entity.Review;
//import com.example.umc9th.domain.review.repository.ReviewRepository;
//import com.example.umc9th.domain.store.entity.QStore;
//import com.querydsl.core.BooleanBuilder;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//@Service
//@RequiredArgsConstructor
//public class ReviewQueryService {
//
//    private final ReviewRepository reviewRepository;
//
//
//    public List<ReviewResponse> findMyReviews(Long memberId, Long storeId, Integer ratingGroup){
//
//        QReview review = QReview.review;
//        QStore store = QStore.store;
//
//
//        BooleanBuilder builder = new BooleanBuilder();
//
//        if (memberId != null) {
//            builder.and(review.member_id.member_id.eq(memberId));
//        }
//
//        if (storeId != null) {
//            builder.and(review.store_id.store_id.eq(storeId));
//        }
//
//        if (ratingGroup != null) {
//            double lower = ratingGroup;
//            double upper = ratingGroup + 0.9;
//            builder.and(review.score.between(lower, upper));
//        }
//        return reviewRepository.findMyReviews(builder);
//    }
//
//    public List<Review> searchReview(String query, String type) {
//        QReview review = QReview.review;
//        QLocation location = QLocation.location;
//
//        BooleanBuilder builder = new BooleanBuilder();
//
//        if(type.equals("location")){
//            builder.and(location.name.contains(query));
//        }
//        if(type.equals("score")){
//            builder.and(review.score.goe(Float.parseFloat(query)));
//        }
//        if(type.equals("both")){
//            String firstQuery = query.split("&")[0];
//            String secondQuery = query.split("&")[1];
//
//            builder.and(location.name.contains(firstQuery));
//            builder.and(review.score.goe(Float.parseFloat(secondQuery)));
//        }
//
//        // List<Review> reviewList = reviewRepository.searchReview(builder);
//        return reviewRepository.searchReview(builder);
//    }
//}
