package com.trustarc.VirtualStandUp.service;

import com.trustarc.VirtualStandUp.entity.TeamMembers;
import com.trustarc.VirtualStandUp.repository.TeamMemberJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class TeamMemberService {

    @Autowired
    TeamMemberJpaRepository teammemberRepository;

    public Optional<TeamMembers> GetTeamMemberByID(UUID memnber_id) {
        return teammemberRepository.findById(memnber_id);

    }
}
