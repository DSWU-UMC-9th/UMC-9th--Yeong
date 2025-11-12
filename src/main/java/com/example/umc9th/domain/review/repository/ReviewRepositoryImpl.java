package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.location.entity.QLocation;
import com.example.umc9th.domain.member.entity.QMember;
import com.example.umc9th.domain.review.dto.ReviewResponse;
import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.entity.QStore;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewQueryDsl {

    private final EntityManager em;



    @Override
    public List<ReviewResponse> findMyReviews(Predicate predicate) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QReview review = QReview.review;
        QStore store = QStore.store;
        QMember member = QMember.member;

        return queryFactory
                .select(Projections.constructor(ReviewResponse.class,
                        review.review_id,
                        store.name.as("storeName"),
                        review.content,
                        review.score))
                .from(review)
                .leftJoin(review.store_id, store)
                .leftJoin(review.member_id, member)
                .where(predicate)
                .fetch();
    }

    @Override
    public List<Review> searchReview(Predicate predicate) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QReview review = QReview.review;
        QStore store = QStore.store;
        QLocation location = QLocation.location;

        return queryFactory
                .selectFrom(review)
                .leftJoin(store).on(store.store_id.eq(review.store_id.store_id))
                .leftJoin(location).on(location.location_id.eq(store.location_id.location_id))
                .where(predicate)
                .fetch();
    }
}
