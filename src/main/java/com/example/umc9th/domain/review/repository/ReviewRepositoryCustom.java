package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ReviewRepositoryCustom {
    Page<Review> findAllByCondition(BooleanBuilder builder, PageRequest pageable);
    List<Review> searchReview(com.querydsl.core.types.Predicate predicate);
}
