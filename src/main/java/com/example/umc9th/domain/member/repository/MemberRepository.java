//package com.example.umc9th.domain.member.repository;
//
//import com.example.umc9th.domain.member.dto.MemberProfileResponse;
//import com.example.umc9th.domain.member.entity.Member;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface MemberRepository extends JpaRepository<Member,Long> {
//
//    List<Member> findByName(String name);
//
//    @Query("""
//        SELECT new com.example.umc9th.domain.member.dto.MemberProfileResponse(
//            m.name,
//            m.email,
//            m.phone_num,
//            CASE WHEN m.phone_num = null THEN '미인증' ELSE '인증 완료' END,
//            m.point
//        )
//        FROM Member m
//        WHERE m.member_id = :loginMemberId
//    """)
//    MemberProfileResponse findMemberProfile(@Param("loginMemberId") Long loginMemberId);
//}
//
