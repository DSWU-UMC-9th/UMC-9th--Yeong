package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MemberMissionResponse;
import com.example.umc9th.domain.mission.service.MissionStatusService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionStatusController {

    private final MissionStatusService missionStatusService;

    /**
     * 미션 완료로 변경 API
     */
    @PostMapping("/complete")
    public ApiResponse<MemberMissionResponse> completeMission(
            @RequestParam Long memberMissionId
    ) {
        MemberMissionResponse result =
                missionStatusService.completeMission(memberMissionId);

        return ApiResponse.onSuccess(GeneralSuccessCode.OK, result);
    }

    /**
     * 완료된 미션 조회
     */
    @GetMapping("/completed")
    public ApiResponse<MemberMissionResponse> completedMission(
            @RequestParam Long memberMissionId
    ) {
        MemberMissionResponse result =
                missionStatusService.completeMission(memberMissionId);

        return ApiResponse.onSuccess(GeneralSuccessCode.OK, result);
    }
}
