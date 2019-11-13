package com.trustarc.VirtualStandUp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class MeetingDTO {
    String meetingSubject;
    String meetingDescription;
    List<UpdateCardDTO> cards;
}
