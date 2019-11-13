package com.trustarc.VirtualStandUp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trustarc.VirtualStandUp.entity.Meeting;
import com.trustarc.VirtualStandUp.entity.TeamMembers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class StandUpDTO {
    private String yesterday;
    private String blockers;
    private String today;
    private Meeting meeting;
    private TeamMembers member;
}
