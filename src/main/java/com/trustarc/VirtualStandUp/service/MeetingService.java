package com.trustarc.VirtualStandUp.service;

import com.trustarc.VirtualStandUp.components.EntityToDTOConverter;
import com.trustarc.VirtualStandUp.dto.MeetingDTO;
import com.trustarc.VirtualStandUp.dto.UpdateCardDTO;
import com.trustarc.VirtualStandUp.entity.Meeting;
import com.trustarc.VirtualStandUp.entity.Team;
import com.trustarc.VirtualStandUp.repository.MeetingJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class MeetingService {
    @Autowired
    MeetingJpaRepository meetingRepository;

    @Autowired
    EntityToDTOConverter entityToDTOConverter;


    public Optional<Meeting> GetMeetingById(UUID meetingID) {

        return meetingRepository.findById(meetingID);
    }

    public Optional<MeetingDTO> GetListOfCards(UUID meetingID){
        Optional<Meeting> meeting = meetingRepository.findById(meetingID);
        Optional<MeetingDTO> meetingDTO = Optional.of(new MeetingDTO());
        if(meeting.get() != null) {

            MeetingDTO toSend = new MeetingDTO();

            toSend.setCards(new ArrayList<>());

            meeting.get().getStandUps().forEach(item-> {
                UpdateCardDTO entry = new UpdateCardDTO();
                entry.setStandUp(entityToDTOConverter.EntityToStandUpDTO(item));
                entry.setUser(entityToDTOConverter.EntitytoUserDTO(item.getMember().getUser()));
                toSend.getCards().add(entry);
            });
            toSend.setMeetingSubject(meeting.get().getMeetingSubject());
            toSend.setMeetingDescription(meeting.get().getMeetingDescription());
            meetingDTO = Optional.of(toSend);
        }
        return meetingDTO;
    }

    public List<Meeting> GetMeetingsByTeam(Optional<Team> team ) {
        return meetingRepository.findAllByTeamOrderByStartDateDesc(team.get());
    }
}
