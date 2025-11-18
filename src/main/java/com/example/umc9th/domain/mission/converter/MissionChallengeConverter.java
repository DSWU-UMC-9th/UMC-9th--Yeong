//package com.example.umc9th.domain.mission.converter;
//
//import com.example.umc9th.domain.member.entity.Member;
//import com.example.umc9th.domain.member.entity.mapping.MemberMission;
//import com.example.umc9th.domain.mission.dto.MissionChallengeRequest;
//import com.example.umc9th.domain.mission.dto.MissionChallengeResponse;
//import com.example.umc9th.domain.mission.entity.Mission;
//
//public class MissionChallengeConverter {
//
//    public static MemberMission toEntity(
//            Member member,
//            Mission mission,
//            MissionChallengeRequest request
//    ) {
//        return MemberMission.builder()
//                .missionState(request.getMissionState())
//                .reviewState(request.getReviewState())
//                .member(member)
//                .mission(mission)
//                .build();
//
//    }
//
//
//
//    public static MissionChallengeResponse toResponse(
//            MemberMission entity
//    ) {
//        return MissionChallengeResponse.builder()
//                .missionChallengeId(entity.getId())
//                .missionId(entity.getMission().getId())
////                .storeId()
//                .missionState(entity.getMissionState())
//                .reviewState(entity.getReviewState())
//                .build();
//    }
//}
