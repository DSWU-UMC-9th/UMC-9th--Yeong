package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.service.MissionService;
import com.example.umc9th.domain.mission.service.MissionService.MissionListWithDDay;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionQueryController {

    private final MissionService missionService;

    /**
     * 특정 지역(가게 포함)의 진행 가능한 미션 목록 조회
     * - 로그인 사용자 ID
     * - location
     * - pageSize
     * - cursor 기반 (lastDueDate, lastMissionId)
     */
    @GetMapping("/available")
    public ApiResponse<List<MissionListWithDDay>> getAvailableMissions(
            @RequestParam Long memberId,
            @RequestParam String location,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) LocalDate lastDueDate,
            @RequestParam(required = false) Long lastMissionId
    ) {
        List<MissionListWithDDay> missions =
                missionService.getAvailableMissions(
                        memberId,
                        location,
                        pageSize,
                        lastDueDate,
                        lastMissionId
                );

        return ApiResponse.onSuccess(GeneralSuccessCode.OK, missions);
    }
}
