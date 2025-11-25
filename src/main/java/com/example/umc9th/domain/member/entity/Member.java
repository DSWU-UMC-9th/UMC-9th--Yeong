package com.example.umc9th.domain.member.entity;

import com.example.umc9th.domain.location.entity.Location;
import com.example.umc9th.domain.member.entity.mapping.MemberFood;
import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import com.example.umc9th.domain.member.enums.Address;
import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.term.entity.mapping.TermMember;
import com.example.umc9th.global.entity.BaseEntity;
import com.example.umc9th.global.entity.auth.enums.SocialType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "member")
public class Member extends BaseEntity { //created_at, deleted_at 포함

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(name = "name" ,length = 3, nullable = false )
    private String name;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Gender gender = Gender.NONE;

    @Column(name = "birth", nullable = false)
    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    @Column(name = "adress" ,nullable = false)
    private Address address;

    @Column(name = "detail_address"  , nullable = false)
    private String detailAddress;

    @Column(name= "email", nullable = false)
    private String email;

    @Column(name = "point" , nullable = false)
    private Integer point=0;

    @Column(name = "phone_num")
    private String phoneNum;

    @Column(name= "social_uid" ,nullable = false)
    private int socialUid;

    @Column(name = "social_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private SocialType socialType = SocialType.LOCAL;

    // 연관관계

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @OneToMany(mappedBy = "member")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberMission> memberMissions = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberFood> memberFoods = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<TermMember> termMembers = new ArrayList<>();
}
