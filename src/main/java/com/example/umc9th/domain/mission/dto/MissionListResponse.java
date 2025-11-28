package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.food.enums.FoodType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class MissionListResponse {

    private Long missionId;
    private String todo;
    private Integer reward;
    private LocalDate dueDate;
    private String storeName;
    private FoodType foodName;
    private String locationName;
}
