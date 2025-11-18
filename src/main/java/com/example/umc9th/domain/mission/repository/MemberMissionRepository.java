//package com.example.umc9th.domain.mission.repository;
//
//import com.example.umc9th.domain.mission.dto.MemberMissionResponse;
//import com.example.umc9th.domain.member.entity.mapping.MemberMission;
//import com.example.umc9th.domain.mission.enums.MissionState;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import java.time.LocalDateTime;
//
//import java.util.List;

//@Repository
//public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
//    @Query("""
//    SELECT new com.example.umc9th.domain.mission.dto.MemberMissionResponse(
//        mm.member_mission_id,
//        m.mission_id,
//        m.todo,
//        CAST(m.reward AS integer),
//        CAST(m.due_date AS date),
//        mm.mission_state,
//        CASE
//            WHEN mm.review_state = com.example.umc9th.domain.review.enums.ReviewState.NOT_WRITTEN THEN 0
//            WHEN mm.review_state = com.example.umc9th.domain.review.enums.ReviewState.WRITTEN THEN 1
//            ELSE 2
//        END,
//        mm.createdAt
//    )
//    FROM MemberMission mm
//    JOIN mm.mission_id m
//    WHERE mm.member_id.member_id = :loginMemberId
//      AND mm.mission_state IN :states
//    ORDER BY mm.createdAt DESC
//""")
//    Page<MemberMissionResponse> findMemberMissions(
//            @Param("loginMemberId") Long loginMemberId,
//            @Param("states") List<MissionState> states,
//            Pageable pageable
//    );
//
//}
