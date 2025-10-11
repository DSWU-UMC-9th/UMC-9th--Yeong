package com.example.umc9th.domain.member.entity.mapping;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Getter @Setter
@NoArgsConstructor
public class UserMission {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userMissionId;

    @Column(nullable = false)
    private Byte missionState;

    @Column(nullable = false)
    private Byte reviewState;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;
}

