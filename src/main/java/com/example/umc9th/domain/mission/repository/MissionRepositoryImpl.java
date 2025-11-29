package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.QMission;
import com.example.umc9th.domain.store.entity.QStore;
import com.example.umc9th.domain.store.entity.Store;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class MissionRepositoryImpl  implements MissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Mission> findAllByStore(Store store, Pageable pageable) {
        QMission mission = QMission.mission;

        // content 조회
        List<Mission> content = queryFactory
                .selectFrom(mission)
                .where(mission.store.eq(store))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        // total count 조회
        Long total = queryFactory
                .select(mission.count())
                .from(mission)
                .where(mission.store.eq(store))
                .fetchOne();

        return new PageImpl<>(content, pageable, total == null ? 0 : total);
    }

    @Override
    public List<Mission> searchMissionByStore(Predicate predicate) {
        QMission mission = QMission.mission;
        QStore store = QStore.store;

        return queryFactory
                .selectFrom(mission)
                .where(predicate)
                .fetch();
    }

}
