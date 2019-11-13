package com.trustarc.VirtualStandUp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "standup")
@Getter
@Setter
@NoArgsConstructor
public class StandUp {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Type(type = "pg-uuid")
    @Column(name="standup_id")
    private UUID standupID;

    @Column(name = "yesterday")
    private String yesterday;

    @Column(name = "today")
    private String today;

    @Column(name = "blockers")
    private String blockers;

    @ManyToOne
    @JoinColumn(name = "meeting_id", nullable = false)
    @JsonIgnore
    private Meeting meeting;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    @JsonIgnore
    private TeamMembers member;

    public StandUp(String yesterday, String today, String blockers, Meeting meeting, TeamMembers member) {
        this.yesterday = yesterday;
        this.today = today;
        this.blockers = blockers;
        this.meeting = meeting;
        this.member = member;
    }

    @Override
    public String toString() {
        return "StandUp{" +
                "standupID=" + standupID +
                ", yesterday='" + yesterday + '\'' +
                ", today='" + today + '\'' +
                ", blockers='" + blockers + '\'' +
                ", meeting=" + meeting +
                ", member=" + member +
                '}';
    }
}
