package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MissionChallengeRequest;
import com.example.umc9th.domain.mission.dto.MissionChallengeResponse;
import com.example.umc9th.domain.mission.service.MissionChallengeService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionChallengeController{

    private final MissionChallengeService missionChallengeService;


    @Operation(
            summary = " 미션 도전하기 ",
            description = "미션 상태를 도전중으로 바꿀 수 있습니다"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })

    //미션 도전하기 api
    @PostMapping
    public ApiResponse<MissionChallengeResponse> challengeMission(
            @RequestParam Long memberId,
            @RequestBody MissionChallengeRequest request
    ) {
        MissionChallengeResponse response =
                missionChallengeService.challengeMission(memberId, request);

        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                response
        );
    }
}
