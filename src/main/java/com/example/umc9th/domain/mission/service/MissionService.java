// com/example/umc9th/domain/mission/service/MissionQueryService.java
package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.dto.MissionListResponse;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;

    public List<MissionListWithDDay> getAvailableMissions(
            Long loginMemberId,
            String storeName,
            Integer page,
            LocalDate lastDueDate,
            Long lastMissionId
    ) {
        List<MissionListResponse> rows = (lastDueDate == null || lastMissionId == null)
                ? missionRepository.findAvailableMissionsFirstPage(
                loginMemberId, storeName, PageRequest.of(page, 10))
                : missionRepository.findAvailableMissionsAfterCursor(
                loginMemberId, storeName, lastDueDate, lastMissionId, PageRequest.of(page, 10));

        LocalDate today = LocalDate.now();

        return rows.stream()
                .map(r -> new MissionListWithDDay(
                        r.getMissionId(),
                        r.getTodo(),
                        r.getReward(),
                        r.getDueDate(),
                        (int) ChronoUnit.DAYS.between(today, r.getDueDate()), // D-Day 계산
                        r.getStoreName(),
                        r.getFoodName().toString(), // FoodType → String
                        r.getLocationName()
                ))
                .toList();
    }

    // API 응답 전용 뷰 모델 (dDay 포함)
    public record MissionListWithDDay(
            Long missionId,
            String missionName,
            Integer rewardPoint,
            LocalDate deadline,
            Integer dDay,
            String storeName,
            String foodName,
            String storeLocation
    ) {}
}
