package com.example.umc9th.domain.term.entity;


import com.example.umc9th.domain.term.entity.mapping.TermMember;
import com.example.umc9th.domain.term.enums.TermName;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "term")


public class Term {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long term_id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TermName name;

    @OneToMany(mappedBy = "term_id")
    private List<TermMember> term_members = new ArrayList<>();
}


