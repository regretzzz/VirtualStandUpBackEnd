package com.trustarc.VirtualStandUp.dto;

import com.trustarc.VirtualStandUp.entity.MeetingStatus;
import com.trustarc.VirtualStandUp.entity.StandUp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class MeetingListDTO {
    private UUID meetingID;

    private String meetingSubject;

    private String  meetingDescription;

    private MeetingStatus status;

    private long startDate;

    private long endDate;

    private Set<StandUp> standUps;

}
