package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.dto.MemberMissionResponse;
import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    @Query(value =
            "SELECT " +
                    "mm.user_mission_id AS memberMissionId, " +
                    "m.mission_id AS missionId, " +
                    "m.todo AS todo, " +
                    "m.reward AS reward, " +
                    "m.due_date AS dueDate, " +
                    "mm.mission_state AS missionState, " +
                    "mm.review_state AS reviewState, " +
                    "mm.created_at AS createdAt " +
                    "FROM member_mission mm " +
                    "JOIN mission m ON mm.mission_id = m.mission_id " +
                    "WHERE mm.member_id = :loginMemberId " +
                    "AND mm.mission_state IN (0, 1) " +
                    "ORDER BY mm.created_at DESC " +
                    "LIMIT :pageSize OFFSET :offset",
            nativeQuery = true)
    List<MemberMissionResponse> findMemberMissions(
            @Param("loginUserId") Long loginMemberId,
            @Param("pageSize") int pageSize,
            @Param("offset") int offset
    );
}
