package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MemberMissionResponse;
import com.example.umc9th.domain.mission.service.MissionStatusService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionStatusController{

    private final MissionStatusService missionStatusService;

    /**
     * 미션 완료로 변경 API
     */

    @Operation(
            summary = " 미션 완료로 변경하기 ",
            description = "memberMissionID를 넣어서 해당 미션을 완료상태로 바꿀 수 있습니다"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    @PostMapping("/complete")
    public ApiResponse<MemberMissionResponse> completeMission(
            @RequestParam Long memberMissionId
    ) {
        MemberMissionResponse result =
                missionStatusService.completeMission(memberMissionId);

        return ApiResponse.onSuccess(GeneralSuccessCode.OK, result);
    }
}
