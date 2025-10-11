package com.example.umc9th.domain.member.entity;

import com.example.umc9th.domain.location.entity.Location;
import com.example.umc9th.domain.term.entity.mapping.TermUser;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.domain.member.entity.mapping.UserFood;
import com.example.umc9th.domain.member.entity.mapping.UserMission;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.member.enums.Address;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "member")
public class Member extends BaseEntity {

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

    @Column(nullable = false, length = 255)
    private String addressDetail;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Integer point;

    @Column(nullable = false, length = 20)
    private String phoneNum;

    @Column(nullable = false)
    private Byte state;

    private LocalDateTime delDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    // 연관관계
    @OneToMany(mappedBy = "member")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<UserMission> userMissions = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<UserFood> userFoods = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<TermUser> termUsers = new ArrayList<>();
}
