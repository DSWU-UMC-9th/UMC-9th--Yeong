package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.store.entity.Store;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MissionRepositoryCustom {
    Page<Mission> findAllByStore(Store store, Pageable pageable);;

    List<Mission> searchMissionByStore(Predicate predicate);
}
