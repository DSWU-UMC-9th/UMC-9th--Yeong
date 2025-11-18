package com.example.umc9th.domain.member.entity.mapping;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.enums.MissionState;
import com.example.umc9th.domain.review.enums.ReviewState;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberMission extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_mission_id;

    @Column(nullable = false)
    private MissionState mission_state;

    @Column(nullable = false)
    private ReviewState review_state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission_id;
}

