package com.trustarc.VirtualStandUp.dto;

import com.trustarc.VirtualStandUp.entity.Team;
import com.trustarc.VirtualStandUp.entity.TeamMembers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
public class UserDTO {

    private UUID userID;

    private String userName;

    private String name;

    private String email;

    private Set<TeamMembers> teams;
    private Set<Team> listofTeam;
}
