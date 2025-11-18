//package com.example.umc9th.domain.mission.repository;
//
//import com.example.umc9th.domain.member.entity.mapping.MemberMission;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface MissionChallengeRepository extends JpaRepository<MemberMission, Long> {
//
//    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);
//
//    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);
//}
