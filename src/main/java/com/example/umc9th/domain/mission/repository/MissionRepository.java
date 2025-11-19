package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.dto.MissionListResponse;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    // 첫 페이지 (커서 없음)
    @Query("""
        SELECT new com.example.umc9th.domain.mission.dto.MissionListResponse(
            m.missionId, m.todo, m.reward, m.dueDate,
            s.name, f.name, l.name
        )
        FROM Mission m
        JOIN m.store s
        JOIN s.food f
        JOIN s.location l
        WHERE l.name = :location
          AND m.dueDate >= CURRENT_DATE
          AND NOT EXISTS (
              SELECT mm FROM MemberMission mm
              WHERE mm.member.memberId = :loginMemberId
                AND mm.mission = m
                AND mm.missionState = com.example.umc9th.domain.mission.enums.MissionState.COMPLETED
          )
        ORDER BY m.dueDate ASC, m.missionId ASC
    """)
    List<MissionListResponse> findAvailableMissionsFirstPage(
            @Param("loginMemberId") Long loginMemberId,
            @Param("location") String location,
            Pageable pageable
    );


    // 커서 이후 페이지 (복합 커서: dueDate, id)
    @Query("""
        SELECT new com.example.umc9th.domain.mission.dto.MissionListResponse(
            m.missionId, m.todo, m.reward, m.dueDate,
            s.name, f.name, l.name
        )
        FROM Mission m
        JOIN m.store s
        JOIN s.food f
        JOIN s.location l
        WHERE l.name = :location
          AND m.dueDate >= CURRENT_DATE
          AND (m.dueDate > :lastDueDate
               OR (m.dueDate = :lastDueDate AND m.missionId > :lastMissionId))
          AND NOT EXISTS (
              SELECT mm FROM MemberMission mm
              WHERE mm.member.memberId = :loginMemberId
                AND mm.mission = m
                AND mm.missionState = com.example.umc9th.domain.mission.enums.MissionState.COMPLETED
          )
        ORDER BY m.dueDate ASC, m.missionId ASC
    """)
    List<MissionListResponse> findAvailableMissionsAfterCursor(
            @Param("loginMemberId") Long loginMemberId,
            @Param("location") String location,
            @Param("lastDueDate") LocalDate lastDueDate,
            @Param("lastMissionId") Long lastMissionId,
            Pageable pageable
    );
}

