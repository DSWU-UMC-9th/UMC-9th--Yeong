package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository //Repository 계층임을 스프링에게 알림
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Modifying //SELECT가 아닌 “데이터 변경 쿼리”임을 표시
    @Transactional //트랜잭션 단위로 실행 (성공 시 commit, 실패 시 rollback)
    @Query(value = "INSERT INTO review (score, content, create_date, user_id, store_id) " +
            "VALUES (:score, :content, NOW(), :loginUserId, :storeId)",
            nativeQuery = true)
    void insertReview(@Param("score") int score,
                      @Param("content") String content,
                      @Param("loginUserId") Long loginUserId,
                      @Param("storeId") Long storeId);
}
