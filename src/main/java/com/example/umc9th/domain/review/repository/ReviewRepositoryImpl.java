package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.location.entity.QLocation;
import com.example.umc9th.domain.member.entity.QMember;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.dto.ReviewResponse;
import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.entity.QStore;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewQueryDsl {

    private final JPAQueryFactory queryFactory; // 스프링 빈으로 등록된 factory만 사용!

    @Override
    public List<ReviewResponse> findMyReviews(Predicate predicate) {

        QReview review = QReview.review;
        QStore store = QStore.store;
        QMember member = QMember.member;

        return queryFactory
                .select(Projections.constructor(ReviewResponse.class,
                        review.reviewId,
                        store.storeId,
                        review.content,
                        review.score))
                .from(review)
                .leftJoin(review.store, store)
                .leftJoin(review.member, member)
                .where(predicate)
                .fetch();
    }

    @Override
    public List<Review> searchReview(Predicate predicate) {

        QReview review = QReview.review;
        QStore store = QStore.store;
        QLocation location = QLocation.location;

        return queryFactory
                .selectFrom(review)
                .leftJoin(store).on(store.storeId.eq(review.store.storeId))
                .leftJoin(location).on(location.locationId.eq(store.location.locationId))
                .where(predicate)
                .fetch();
    }

    public ReviewResDTO.ReviewPreViewListDTO findReview() {
        return findReview(null);
    }

    @Override
    public ReviewResDTO.ReviewPreViewListDTO findReview(Predicate predicate) {

        QReview review = QReview.review;
        QStore store = QStore.store;
        QMember member = QMember.member;

        List<ReviewResDTO.ReviewPreViewDTO> list = queryFactory
                .select(Projections.constructor(
                        ReviewResDTO.ReviewPreViewDTO.class,
                        member.name,         // ownerNickname
                        review.score,            // score
                        review.content,          // body
                        review.createdAt         // createdAt
                ))
                .from(review)
                .leftJoin(review.member, member)
                .where(predicate)
                .fetch();

        return ReviewResDTO.ReviewPreViewListDTO.builder()
                .reviewList(list)
                .listSize(list.size())
                .totalPage(1)
                .totalElements((long) list.size())
                .isFirst(true)
                .isLast(true)
                .build();
    }

}
