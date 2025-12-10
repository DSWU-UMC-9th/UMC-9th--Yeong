package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MissionResDTO;
import com.example.umc9th.domain.mission.service.MissionService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionQueryController{

    private final MissionService missionService;

    @Operation(
            summary = "가게별 미션 조회",
            description = "가게 이름을 이용해서 미션 목록을 조회할 수 있습니다"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })


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
