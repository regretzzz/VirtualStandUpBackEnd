package com.trustarc.VirtualStandUp.service;

import com.trustarc.VirtualStandUp.entity.QTeam;
import com.trustarc.VirtualStandUp.entity.Team;
import com.trustarc.VirtualStandUp.entity.TeamMembers;
import com.trustarc.VirtualStandUp.repository.TeamJpaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.BooleanBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class TeamService {

    @Autowired
    private TeamJpaRespository teamRepository;


    public List<Team> GetAll() {

        Team t;

        return teamRepository.findAll();
    }

    public Optional<Team> GetTeam(UUID id){

        return teamRepository.findById(id);
    }
//    public Page<Team> GetAllTeamByUser(TeamMembers member, Pageable pageable) {
//        BooleanBuilder build = new BooleanBuilder();
//        QTeam qteam = QTeam.team;
//
//        if(member.getMemberID() != null) {
//            build.and();
//        }
//
//        return teamRepository.findAll(build,pageable);
//    }
}
