package com.example.umc9th.domain.mission.dto;

public interface MissionListResponse {

    Long getMissionId();          // m.mission_id
    String getMissionName();      // m.todo
    Integer getRewardPoint();     // m.reward
    String getDeadline();         // m.due_date
    Integer getDDay();            // DATEDIFF(m.due_date, CURDATE())
    String getStoreName();        // s.name
    Long getFoodName();           // s.food_id (※ 실제는 Food 엔티티 조인 시 이름으로 바꿔도 가능)
    String getStoreLocation();    // s.location_id
    String getCursorValue();      // cursor_value
}
