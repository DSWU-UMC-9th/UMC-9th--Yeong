package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import com.example.umc9th.domain.mission.dto.MissionChallengeRequest;
import com.example.umc9th.domain.mission.dto.MissionChallengeResponse;
import com.example.umc9th.domain.mission.entity.Mission;

public class MissionChallengeConverter {

    public static MemberMission toEntity(
            Member member,
            Mission mission,
            MissionChallengeRequest request
    ) {
        return MemberMission.builder()
                .mission_state(request.getMissionState())
                .review_state(request.getReviewState())
                .member_id(member)
                .mission_id(mission)
                .build();

    }



    public static MissionChallengeResponse toResponse(
            MemberMission entity
    ) {
        return MissionChallengeResponse.builder()
                .missionChallengeId(entity.getMember_mission_id())
                .missionId(entity.getMission_id().getMission_id())
                .storeId(entity.getMission_id().getStore_id().getStore_id())
                .missionState(entity.getMission_state())
                .reviewState(entity.getReview_state())
                .build();
    }
}
