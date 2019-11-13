package com.trustarc.VirtualStandUp.repository;

import com.trustarc.VirtualStandUp.entity.Meeting;
import com.trustarc.VirtualStandUp.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface MeetingJpaRepository extends JpaRepository<Meeting, UUID>, QuerydslPredicateExecutor<Meeting> {
    List<Meeting> findAllByTeamOrderByStartDateDesc(Team team);

    List<Meeting> findAllByStartDate(Date date);
    List<Meeting> findAllByEndDate(Date date);


}
