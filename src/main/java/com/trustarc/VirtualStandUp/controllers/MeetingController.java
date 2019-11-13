package com.trustarc.VirtualStandUp.controllers;

import com.trustarc.VirtualStandUp.dto.MeetingDTO;
import com.trustarc.VirtualStandUp.dto.UpdateCardDTO;
import com.trustarc.VirtualStandUp.entity.Meeting;
import com.trustarc.VirtualStandUp.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@CrossOrigin
@RestController
@RequestMapping("meeting")
public class MeetingController {

    @Autowired
    MeetingService meetingService;

    @GetMapping("{meetingID}")
    public  Optional<MeetingDTO> GetMeetingViaID(@PathVariable UUID meetingID){
        return meetingService.GetListOfCards(meetingID);
    }

    @GetMapping("{meetingID}/{memberID}")
    public boolean IsDoneUpdate(@PathVariable UUID meetingID, @PathVariable UUID memberID){
        Optional<Meeting> meeting = meetingService.GetMeetingById(meetingID);
        AtomicReference<Boolean> isDone = new AtomicReference<>(false);
        meeting.get().getStandUps().forEach(standUp -> {
            if(standUp.getMember().getMemberID().equals(memberID)){
                isDone.set(true);

            }
        });
       return isDone.get();
    }
}
