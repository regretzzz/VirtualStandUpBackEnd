package com.trustarc.VirtualStandUp.controllers;

import com.trustarc.VirtualStandUp.dto.MeetingListDTO;
import com.trustarc.VirtualStandUp.dto.TeamMemberDTO;
import com.trustarc.VirtualStandUp.entity.Meeting;
import com.trustarc.VirtualStandUp.entity.Team;
import com.trustarc.VirtualStandUp.entity.TeamMembers;
import com.trustarc.VirtualStandUp.entity.User;
import com.trustarc.VirtualStandUp.service.MeetingService;
import com.trustarc.VirtualStandUp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @Autowired
    private MeetingService meetingService;

//    @GetMapping
//    public Page<Team> findAll(
//            @RequestParam(required = false)  final UUID id,
//            @PageableDefault(size = 10, page = 0, sort = "team_id") Pageable pageable) {
//
//        Page<Team> page = teamService.GetAllTeamId(id, pageable);
//        return page;
//    }

    @GetMapping("/")
    public List<Team> getAll(){
        return teamService.GetAll();
    }

    @GetMapping("member/{teamID}")
    public List<TeamMemberDTO>  getTeamMembers(@PathVariable UUID teamID){

        Optional<Team> team = teamService.GetTeam(teamID);
        List<TeamMemberDTO> users = new ArrayList<>();
        team.get().getMembers().forEach(t ->{
            User user = t.getUser();
           users.add(new TeamMemberDTO(t.getMemberID(),t.getMember_role(),user));
        });
        return users;
    }

    @GetMapping("member/{teamID}/{userID}")
    public List<TeamMembers> getMemberID(@PathVariable UUID teamID, @PathVariable UUID userID){

        Optional<Team> team = teamService.GetTeam(teamID);
        List<TeamMembers> member = new ArrayList<>();

        team.get().getMembers().forEach(t ->{
             User user = t.getUser();
             if(user.getUserID().equals(userID)){
                 member.add(t);
             }
        });
        return member;
    }


    @GetMapping("meetings/{teamID}")
    public List<MeetingListDTO> getCurrentTeam(@PathVariable UUID teamID){
        Optional<Team> team = teamService.GetTeam(teamID);
        List<MeetingListDTO> list = new ArrayList<>();

        meetingService.GetMeetingsByTeam(team).forEach(meeting -> {
            MeetingListDTO temp = new MeetingListDTO();
            temp.setMeetingID(meeting.getMeetingID());
            temp.setMeetingDescription(meeting.getMeetingDescription());
            temp.setMeetingSubject(meeting.getMeetingSubject());
            temp.setStatus(meeting.getStatus());
            temp.setEndDate(meeting.getEndDate().getTime());
            temp.setStartDate(meeting.getStartDate().getTime());
            temp.setStandUps(meeting.getStandUps());
            list.add(temp);
        });

        return list;
    }
}
