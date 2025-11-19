package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MissionChallengeRepository extends JpaRepository<MemberMission, Long> {

    Optional<MemberMission> findByMember_MemberIdAndMission_MissionId(Long memberId, Long missionId);

    boolean existsByMember_MemberIdAndMission_MissionId(Long memberId, Long missionId);
}
