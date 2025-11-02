package com.example.umc9th.domain.mission.dto;

import java.time.LocalDateTime;
import java.time.LocalDate;

public interface MemberMissionResponse {
    Long getMemberMissionId();  // um.user_mission_id
    Long getMissionId();      // m.mission_id
    String getTodo();         // m.todo
    Integer getReward();      // m.reward
    LocalDate getDueDate();   // m.due_date
    Integer getMissionState();// um.mission_state
    Integer getReviewState(); // um.review_state
    LocalDateTime getCreatedAt(); // um.create_date
}
