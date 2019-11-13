package com.trustarc.VirtualStandUp.repository;

import com.trustarc.VirtualStandUp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersJpaRepository extends JpaRepository<User, UUID> , QuerydslPredicateExecutor<User> {
    public User findByUserNameAndPassword(String user, String pass);
}
