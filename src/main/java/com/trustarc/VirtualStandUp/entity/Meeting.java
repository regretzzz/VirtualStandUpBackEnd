package com.trustarc.VirtualStandUp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trustarc.VirtualStandUp.enums.PostgreSQLEnumType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "meeting")
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
@Getter
@Setter
@NoArgsConstructor
public class Meeting {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Type(type = "pg-uuid")
    @Column(name="meeting_id")
    private UUID meetingID;

    @Column(name = "meeting_subj")
    private String meetingSubject;

    @Column(name = "meeting_desc")
    private String  meetingDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "meeting_status")
    @Type(type="pgsql_enum")
    private MeetingStatus status;

    @Column(name = "meeting_start_date", columnDefinition= "TIMESTAMP WITHOUT ZONE")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "meeting_end_date", columnDefinition= "TIMESTAMP WITHOUT ZONE")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    @JsonIgnore
    private Team team;

    @OneToMany(mappedBy = "meeting")
    Set<StandUp> standUps;


    public Meeting(String meetingSubject, String meetingDescription, MeetingStatus status, @NotNull Date startDate, @NotNull Date endDate, Team team, Set<StandUp> standUps) {
        this.meetingSubject = meetingSubject;
        this.meetingDescription = meetingDescription;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.team = team;
        this.standUps = standUps;
    }


    @Override
    public String toString() {
        return "Meeting{" +
                "meetingID=" + meetingID +
                ", meetingSubject='" + meetingSubject + '\'' +
                ", meetingDescription='" + meetingDescription + '\'' +
                ", status=" + status +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", team=" + team +
                ", standUps=" + standUps +
                '}';
    }
}
