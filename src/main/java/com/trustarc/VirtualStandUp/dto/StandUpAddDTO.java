package com.trustarc.VirtualStandUp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class StandUpAddDTO {
    private String yesterday;
    private String blockers;
    private String today;
    private UUID meeting_id;
    private UUID member_id;
}
