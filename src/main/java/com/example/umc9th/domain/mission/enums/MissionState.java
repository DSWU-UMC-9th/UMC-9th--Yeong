package com.example.umc9th.domain.mission.enums;

public enum MissionState {
    IN_PROGRESS, COMPLETED;

    public static MissionState fromKorean(String state) {
        return switch (state) {
            case "진행중" -> IN_PROGRESS;
            case "완료"   -> COMPLETED;
            default -> throw new IllegalArgumentException("지원하지 않는 상태입니다: " + state);
        };
    }
}
