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
@Table(name = "user_food")
public class UserFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodUserId;

    // 외래키: user_id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Member member;

    // 외래키: food_id
    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;
}
