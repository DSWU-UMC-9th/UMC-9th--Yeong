package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom{

    // 1. 가게로 조회 (기본 JPA)
    Page<Review> findAllByStore(Store store, Pageable pageable);

    // 2. 리뷰 검색 (QueryDSL → Custom)
    List<Review> searchReview(com.querydsl.core.types.Predicate predicate);

}
