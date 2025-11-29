package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import com.example.umc9th.domain.mission.enums.MissionState;
import com.example.umc9th.domain.mission.repository.MemberMissionRepository;
import com.example.umc9th.domain.mission.dto.MemberMissionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionStatusService {

    private final MemberMissionRepository memberMissionRepository;

    @Transactional
    public MemberMissionResponse completeMission(Long memberMissionId) {

        MemberMission mm = memberMissionRepository.findById(memberMissionId)
                .orElseThrow(() -> new RuntimeException("미션을 찾을 수 없습니다."));

        mm.setMissionState(MissionState.COMPLETED);

        return new MemberMissionResponse(
                mm.getMemberMissionId(),
                mm.getMission().getMissionId(),
                mm.getMission().getTodo(),
                mm.getMission().getReward(),
                mm.getMission().getDueDate(),
                mm.getMissionState(),
                mm.getCreatedAt()
        );
    }

    @Transactional
    public MemberMissionResponse completedMission(Long memberMissionId) {

        MemberMission mm = memberMissionRepository.findById(memberMissionId)
                .orElseThrow(() -> new RuntimeException("미션을 찾을 수 없습니다."));

        mm.setMissionState(MissionState.COMPLETED);

        return new MemberMissionResponse(
                mm.getMemberMissionId(),
                mm.getMission().getMissionId(),
                mm.getMission().getTodo(),
                mm.getMission().getReward(),
                mm.getMission().getDueDate(),
                mm.getMissionState(),
                mm.getCreatedAt()
        );
    }
}
