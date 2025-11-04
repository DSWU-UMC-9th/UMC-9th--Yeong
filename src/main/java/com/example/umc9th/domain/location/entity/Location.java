package com.example.umc9th.domain.location.entity;

import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "location")
public class Location {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long location_id;

    @Column(nullable = false, length = 255)
    private String name;

    @OneToMany(mappedBy = "location")
    private List<Member> members = new ArrayList<>();

    @OneToMany(mappedBy = "location")
    private List<Store> stores = new ArrayList<>();
}
