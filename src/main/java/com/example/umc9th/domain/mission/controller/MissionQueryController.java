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


    @GetMapping("/available")
    public ApiResponse<List<MissionListWithDDay>> getAvailableMissions(
            @RequestParam Long memberId,
            @RequestParam String storeName,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(required = false) LocalDate lastDueDate,
            @RequestParam(required = false) Long lastMissionId
    ) {
        List<MissionListWithDDay> missions =
                missionService.getAvailableMissions(
                        memberId,
                        storeName,
                        page,
                        lastDueDate,
                        lastMissionId
                );

        return ApiResponse.onSuccess(GeneralSuccessCode.OK, missions);
    }
}
