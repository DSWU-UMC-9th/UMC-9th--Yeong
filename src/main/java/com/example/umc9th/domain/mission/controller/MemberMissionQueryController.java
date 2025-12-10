package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MemberMissionResponse;
import com.example.umc9th.domain.mission.enums.MissionState;
import com.example.umc9th.domain.mission.service.MemberMissionService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MemberMissionQueryController {

    private final MemberMissionService memberMissionService;

    /**
     * 내가 진행 중 또는 완료한 미션 목록 조회
     */

    @Operation(
            summary = "진행 중 또는 완료한 미션 조회",
            description = "MissionState.IN_PROGRESS, COMPLETED 상태를 선택해서 조회할 수 있습니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })

    @GetMapping("/my")
    public ApiResponse<Page<MemberMissionResponse>> getMyMissions(
            @RequestParam Long memberId,
            @RequestParam MissionState missionState, //진행중, 완료 조건
            @RequestParam(defaultValue = "1") Integer page
    ) {
        Page<MemberMissionResponse> response =
                memberMissionService.getMyMissions(memberId, missionState, page);

        return ApiResponse.onSuccess(GeneralSuccessCode.OK, response);
    }
}
