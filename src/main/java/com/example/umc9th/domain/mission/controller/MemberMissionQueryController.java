package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MemberMissionResponse;
import com.example.umc9th.domain.mission.service.MemberMissionService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MemberMissionQueryController {

    private final MemberMissionService memberMissionService;

    /**
     * 내가 진행 중 또는 완료한 미션 목록 조회
     */
    @GetMapping("/my")
    public ApiResponse<Page<MemberMissionResponse>> getMyMissions(
            @RequestParam Long memberId,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        Page<MemberMissionResponse> response =
                memberMissionService.getMyMissions(memberId, page - 1, size);

        return ApiResponse.onSuccess(GeneralSuccessCode.OK, response);
    }
}
