package com.trustarc.VirtualStandUp.components;

import com.trustarc.VirtualStandUp.dto.StandUpDTO;
import com.trustarc.VirtualStandUp.dto.UserDTO;
import com.trustarc.VirtualStandUp.entity.StandUp;
import com.trustarc.VirtualStandUp.entity.Team;
import com.trustarc.VirtualStandUp.entity.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class EntityToDTOConverter {

    public UserDTO EntitytoUserDTO(User user) {
        Set<Team> teams = new HashSet<>();

        user.getTeams().forEach(t->{
            teams.add(t.getTeam());
        });
        return new UserDTO(user.getUserID(),user.getUserName(),user.getName(), user.getEmail(), user.getTeams(),teams);
    }

    public StandUpDTO EntityToStandUpDTO(StandUp standUp) {
        return new StandUpDTO(standUp.getYesterday(), standUp.getBlockers(),standUp.getToday(),standUp.getMeeting(),standUp.getMember());
    }
}
