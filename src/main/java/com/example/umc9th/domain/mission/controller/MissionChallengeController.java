package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MissionChallengeRequest;
import com.example.umc9th.domain.mission.dto.MissionChallengeResponse;
import com.example.umc9th.domain.mission.service.MissionChallengeService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionChallengeController {

    private final MissionChallengeService missionChallengeService;

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
