package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;

public class MissionConverter {

    // result -> DTO
    public static MissionResDTO.MissionPreViewListDTO toMissionPreviewListDTO(
            Page<Mission> result
    ){
        return MissionResDTO.MissionPreViewListDTO.builder()
                .missionList(result.getContent().stream()
                        .map(MissionConverter::toMissionPreviewDTO)
                        .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static  MissionResDTO.MissionPreViewDTO toMissionPreviewDTO(
            Mission mission
    ){
        return MissionResDTO.MissionPreViewDTO.builder()
                .missionId(mission.getMissionId())
                .todo(mission.getTodo())
                .reward(mission.getReward())
                .dueDate(mission.getDueDate())
                .storeName(mission.getStore().getName())
                .locationName(mission.getStore().getLocation().getName())
                .build();
    }
}
