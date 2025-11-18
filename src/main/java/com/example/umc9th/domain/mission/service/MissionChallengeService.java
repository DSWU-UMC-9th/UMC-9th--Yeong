//package com.example.umc9th.domain.mission.service;
//
//import com.example.umc9th.domain.member.entity.Member;
//import com.example.umc9th.domain.member.entity.mapping.MemberMission;
//import com.example.umc9th.domain.member.repository.MemberRepository;
//import com.example.umc9th.domain.mission.converter.MissionChallengeConverter;
//import com.example.umc9th.domain.mission.dto.MissionChallengeRequest;
//import com.example.umc9th.domain.mission.dto.MissionChallengeResponse;
//import com.example.umc9th.domain.mission.entity.Mission;
//import com.example.umc9th.domain.mission.repository.MissionChallengeRepository;
//import com.example.umc9th.domain.mission.repository.MissionRepository;
//import com.example.umc9th.domain.review.dto.ReviewRequest;
//import com.example.umc9th.domain.review.entity.Review;
//import com.example.umc9th.domain.store.repository.StoreRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RequiredArgsConstructor
//public class MissionChallengeService {
//
//    private final MissionChallengeRepository missionChallengeRepository;
//    private final MemberRepository memberRepository;
//    private final MissionRepository missionRepository;
//
//    public MissionChallengeResponse challengeMission(
//            Long memberId,
//            MissionChallengeRequest request
//    ) {
//        // 이미 도전 중인 미션인지 체크
//        if (missionChallengeRepository.existsByMemberIdAndMissionId(memberId, request.getMissionId())) {
//            throw new RuntimeException("이미 도전 중인 미션입니다.");
//        }
//
//        Member member = memberRepository.findById(memberId).orElse(null);
//        Mission mission = missionRepository.findById(request.getMissionId()).orElse(null);
//
//
//        // Request → Entity
//        MemberMission missionChallenge =
//                MissionChallengeConverter.toEntity(member, mission, request);
//
//        // 저장
//        missionChallengeRepository.save(missionChallenge);
//
//        // Entity → Response
//        return MissionChallengeConverter.toResponse(missionChallenge);
//    }
//}
