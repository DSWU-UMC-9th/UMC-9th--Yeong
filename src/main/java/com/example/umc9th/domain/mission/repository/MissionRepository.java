//package com.example.umc9th.domain.mission.repository;
//
//import com.example.umc9th.domain.mission.dto.MissionListResponse;
//import com.example.umc9th.domain.mission.entity.Mission;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.time.LocalDate;
//import java.util.List;
//
//public interface MissionRepository extends JpaRepository<Mission, Long> {
//
//    // 첫 페이지 (커서 없음)
//    @Query("""
//        SELECT new com.example.umc9th.domain.mission.dto.MissionListResponse(
//            m.mission_id, m.todo, m.reward, m.due_date,
//            s.name, f.name, l.name
//        )
//        FROM Mission m
//        JOIN m.store_id s
//        JOIN s.food_id f
//        JOIN s.location_id l
//        WHERE l.name = :location
//          AND m.due_date >= CURRENT_DATE
//          AND NOT EXISTS (
//              SELECT mm FROM MemberMission mm
//              WHERE mm.member_id = :loginMemberId
//                AND mm.mission_id = m
//                AND mm.mission_state = com.example.umc9th.domain.mission.enums.MissionState.COMPLETED
//          )
//        ORDER BY m.due_date ASC, m.mission_id ASC
//    """)
//    List<MissionListResponse> findAvailableMissionsFirstPage(
//            @Param("loginMemberId") Long loginMemberId,
//            @Param("location") String location,
//            Pageable pageable
//    );
//
//
//    // 커서 이후 페이지 (복합 커서: dueDate, id)
//    @Query("""
//        SELECT new com.example.umc9th.domain.mission.dto.MissionListResponse(
//            m.mission_id, m.todo, m.reward, m.due_date,
//            s.name, f.name, l.name
//        )
//        FROM Mission m
//        JOIN m.store_id s
//        JOIN s.food_id f
//        JOIN s.location_id l
//        WHERE l.name = :location
//          AND m.due_date >= CURRENT_DATE
//          AND (m.due_date > :lastDueDate
//               OR (m.due_date = :lastDueDate AND m.mission_id > :lastMissionId))
//          AND NOT EXISTS (
//              SELECT mm FROM MemberMission mm
//              WHERE mm.member_id = :loginMemberId
//                AND mm.mission_id = m
//                AND mm.mission_state = com.example.umc9th.domain.mission.enums.MissionState.COMPLETED
//          )
//        ORDER BY m.due_date ASC, m.mission_id ASC
//    """)
//    List<MissionListResponse> findAvailableMissionsAfterCursor(
//            @Param("loginMemberId") Long loginMemberId,
//            @Param("location") String location,
//            @Param("lastDueDate") LocalDate lastDueDate,
//            @Param("lastMissionId") Long lastMissionId,
//            Pageable pageable
//    );
//}
//
