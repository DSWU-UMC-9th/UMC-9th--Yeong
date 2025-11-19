//// com/example/umc9th/domain/mission/service/MemberMissionQueryService.java
//package com.example.umc9th.domain.mission.service;
//
//import com.example.umc9th.domain.mission.dto.MemberMissionResponse;
//import com.example.umc9th.domain.mission.enums.MissionState;
//import com.example.umc9th.domain.mission.repository.MemberMissionRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class MemberMissionService {
//
//    private final MemberMissionRepository memberMissionRepository;
//
//    public Page<MemberMissionResponse> getMyMissions(Long loginMemberId, int page, int size) {
//        return memberMissionRepository.findMemberMissions(
//                loginMemberId,
//                List.of(MissionState.IN_PROGRESS, MissionState.COMPLETED),
//                PageRequest.of(page, size)
//        );
//    }
//}
//
