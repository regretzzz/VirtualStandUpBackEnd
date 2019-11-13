package com.trustarc.VirtualStandUp.controllers;


import com.trustarc.VirtualStandUp.dto.StandUpAddDTO;
import com.trustarc.VirtualStandUp.dto.StandUpDTO;
import com.trustarc.VirtualStandUp.entity.StandUp;
import com.trustarc.VirtualStandUp.service.MeetingService;
import com.trustarc.VirtualStandUp.service.StandUpService;
import com.trustarc.VirtualStandUp.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("standup")
public class StandUpController {
    @Autowired
    StandUpService standupService;

    @Autowired
    MeetingService meetingService;

    @Autowired
    TeamMemberService teamMemberService;

    @PostMapping("/")
    public StandUp addUpdate(@RequestBody StandUpAddDTO udto){
        StandUp toSave = new StandUp();
        System.out.println(udto);
        toSave.setBlockers(udto.getBlockers());
        toSave.setYesterday(udto.getYesterday());
        toSave.setToday(udto.getToday());
        toSave.setMeeting(meetingService.GetMeetingById(udto.getMeeting_id()).get());
        toSave.setMember(teamMemberService.GetTeamMemberByID(udto.getMember_id()).get());
        return standupService.AddStandUp(toSave) ;
    }
}
