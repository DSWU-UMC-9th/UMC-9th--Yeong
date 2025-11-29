package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MissionResDTO;
import com.example.umc9th.domain.mission.service.MissionService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionQueryController {

    private final MissionService missionService;


    @GetMapping("/store")
    public ApiResponse<MissionResDTO.MissionPreViewListDTO> getMissionsByStore(
            @RequestParam String storeName,
            @RequestParam(defaultValue = "1") Integer page
    ) {
        MissionResDTO.MissionPreViewListDTO missions =
                missionService.getMissionsByStore(
                        storeName,
                        page
                );

        return ApiResponse.onSuccess(GeneralSuccessCode.OK, missions);
    }
}
