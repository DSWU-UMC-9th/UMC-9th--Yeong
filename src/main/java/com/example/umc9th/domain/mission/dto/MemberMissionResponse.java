package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.mission.enums.MissionState;
import com.example.umc9th.domain.review.enums.ReviewState;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class MemberMissionResponse {

    private Long memberMissionId;
    private Long missionId;
    private String todo;
    private Integer reward;
    private LocalDate dueDate;
    private MissionState missionState;
    private ReviewState reviewState;
    private LocalDateTime createdAt;

    public MemberMissionResponse(
            Long memberMissionId,
            Long missionId,
            String todo,
            Integer reward,
            LocalDate dueDate,
            MissionState missionState,
            LocalDateTime createdAt
    ) {
        this.memberMissionId = memberMissionId;
        this.missionId = missionId;
        this.todo = todo;
        this.reward = reward;
        this.dueDate = dueDate;
        this.missionState = missionState;
        this.reviewState = null; // 필요하면 추가
        this.createdAt = createdAt;
    }

}
