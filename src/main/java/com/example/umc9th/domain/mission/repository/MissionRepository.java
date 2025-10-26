package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.dto.MissionListResponse;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query(value =
            "SELECT " +
                    "m.mission_id AS missionId, " +
                    "m.todo AS missionName, " +
                    "m.reward AS rewardPoint, " +
                    "m.due_date AS deadline, " +
                    "DATEDIFF(m.due_date, CURDATE()) AS dDay, " +
                    "s.name AS storeName, " +
                    "s.food_id AS foodName, " +
                    "s.location_id AS storeLocation, " +
                    "CONCAT(LPAD(DATE_FORMAT(m.due_date, '%Y%m%d'), 8, '0'), LPAD(m.mission_id, 10, '0')) AS cursorValue " +
                    "FROM mission m " +
                    "JOIN store s ON m.store_id = s.store_id " +
                    "LEFT JOIN member_mission mm " +
                    "   ON m.mission_id = mm.mission_id " +
                    "  AND mm.member_id = :loginMemberId " +
                    "WHERE s.location_id = :location " +
                    "  AND m.due_date >= CURDATE() " +
                    "  AND (mm.mission_state IS NULL OR mm.mission_state != 1) " +
                    "  AND CONCAT(LPAD(DATE_FORMAT(m.due_date, '%Y%m%d'), 8, '0'), LPAD(m.mission_id, 10, '0')) > :lastCursor " +
                    "ORDER BY m.due_date ASC, m.mission_id ASC " +
                    "LIMIT :pageSize",
            nativeQuery = true)
    List<MissionListResponse> findAvailableMissions(
            @Param("loginMemberId") Long loginMemberId,
            @Param("location") String location,
            @Param("lastCursor") String lastCursor,
            @Param("pageSize") int pageSize
    );
}
