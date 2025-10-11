package com.example.umc9th.domain.food.entity;

import com.example.umc9th.domain.food.enums.FoodType;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.member.entity.mapping.UserFood;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "food")
public class Food {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long food_id;

    @Enumerated(EnumType.STRING)
    private FoodType name;

    @OneToMany(mappedBy = "food")
    private List<Store> stores = new ArrayList<>();

    @OneToMany(mappedBy = "food")
    private List<UserFood> userFoods = new ArrayList<>();
}

