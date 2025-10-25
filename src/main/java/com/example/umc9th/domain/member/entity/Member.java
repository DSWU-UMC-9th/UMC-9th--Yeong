package com.example.umc9th.domain.member.entity;

import com.example.umc9th.domain.location.entity.Location;
import com.example.umc9th.domain.term.entity.mapping.TermMember;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.domain.member.entity.mapping.MemberFood;
import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.member.enums.Address;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "member")
public class Member extends BaseEntity { //created_at, deleted_at 포함

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    @Column(name = "name" ,length = 3, nullable = false )
    private String name;


    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Gender gender = Gender.FEMALE;

    @Column(name = "birth", nullable = false)
    private LocalDateTime birth;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Address address;

    @Column(nullable = false)
    private String detail_address;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Integer point;

    @Column(nullable = false, length = 20)
    private String phone_num;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location_id;



    @Column(nullable = false)
    private int social_uid;

    @Column(nullable = false)
    private int social_type;


    // 연관관계
    @OneToMany(mappedBy = "member_id")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "member_id")
    private List<MemberMission> member_missions = new ArrayList<>();

    @OneToMany(mappedBy = "member_id")
    private List<MemberFood> member_foods = new ArrayList<>();

    @OneToMany(mappedBy = "member_id")
    private List<TermMember> term_members = new ArrayList<>();
}
