package com.trustarc.VirtualStandUp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Table( name = "team" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Type(type = "pg-uuid")
    @Column(name="team_id")
    private UUID teamId;

    @Column(name="team_name")
    private String teamName;

    @Column(name="team_desc")
    private String teamDesc;

    @Column(name = "team_image")
    private String teamImage;

    @Column(name = "standup_start")
    @Temporal(TemporalType.TIME)
    private Date standupTime;

    @OneToMany(mappedBy = "team")

    Set<TeamMembers> members;

    @OneToMany(mappedBy = "team")
    Set<Meeting> meetings;





}
