package com.example.umc9th.domain.mission.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

public class MissionResDTO {

    @Builder
    public record MissionPreViewListDTO(
            List<MissionResDTO.MissionPreViewDTO> missionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record MissionPreViewDTO(
            Long missionId,
            String todo,
            Integer reward,
            LocalDate dueDate,
            String storeName,
            String locationName
    ){}
}
