package com.example.umc9th.domain.review.entity;


import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "review")
public class Review extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long review_id;

    @Column(nullable = false)
    private Float score;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    // 연관관계

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

//    @OneToMany(mappedBy = "review")
//    private List<ReviewPhoto> photos = new ArrayList<>();

    @OneToMany(mappedBy = "review")
    private List<Reply> replies = new ArrayList<>();
}
