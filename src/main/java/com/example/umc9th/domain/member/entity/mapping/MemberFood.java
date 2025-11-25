package com.example.umc9th.domain.member.entity.mapping;

import com.example.umc9th.domain.food.entity.Food;
import com.example.umc9th.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "member_food")
public class MemberFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 외래키: member_id
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    // 외래키: food_id
    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;
}
