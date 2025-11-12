package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.mission.enums.MissionState;
import com.example.umc9th.domain.review.enums.ReviewState;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MemberMissionResponse {

    private Long memberMissionId;
    private Long missionId;
    private String todo;
    private Integer reward;
    private LocalDateTime dueDate;
    private MissionState missionState;
    private ReviewState reviewState;
    private LocalDateTime createdAt;
}
