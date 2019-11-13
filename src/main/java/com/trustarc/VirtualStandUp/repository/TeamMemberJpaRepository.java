package com.trustarc.VirtualStandUp.repository;

import com.trustarc.VirtualStandUp.entity.TeamMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeamMemberJpaRepository extends JpaRepository<TeamMembers, UUID>, QuerydslPredicateExecutor<TeamMembers> {
}
