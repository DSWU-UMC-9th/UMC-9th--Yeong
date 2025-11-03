package com.example.umc9th.domain.member.repository;


import com.example.umc9th.domain.member.dto.MemberProfileResponse;
import com.example.umc9th.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    List<Member> findByNameAndDeletedAtIsNull(String name);
    //SELECT * FROM `user` WHERE name = '마크' AND deleted_at is null;

    @Query(value =
            "SELECT " +
                    "m.name AS nickname, " +
                    "m.email, " +
                    "m.phone_num AS phoneNum, " +
                    "CASE WHEN u.phone_verified = 1 THEN '인증 완료' ELSE '미인증' END AS phoneVerifiedStatus, " +
                    "m.point " +
                    "FROM member m " +
                    "WHERE m.member_id = :loginMemberId",
            nativeQuery = true)
    MemberProfileResponse findMemberProfile(@Param("loginMemberId") Long loginMemberId);
}
