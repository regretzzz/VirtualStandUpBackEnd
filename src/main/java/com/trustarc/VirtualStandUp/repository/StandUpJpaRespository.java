package com.trustarc.VirtualStandUp.repository;

import com.trustarc.VirtualStandUp.entity.StandUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StandUpJpaRespository extends JpaRepository<StandUp, UUID>, QuerydslPredicateExecutor<StandUp> {

}
