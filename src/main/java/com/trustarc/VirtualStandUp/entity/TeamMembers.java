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
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name="team_members")
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
@Getter
@Setter
@NoArgsConstructor
public class TeamMembers {

    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Type(type = "pg-uuid")
    @Id
    @Column(name = "member_id")
    private UUID memberID;

    @Enumerated(EnumType.STRING)
    @Column(name = "mem_role")
    @Type(type = "pgsql_enum")
    private Role member_role;


    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    @JsonIgnore
    private Team team;


    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "member")
    private Set<StandUp> comments;

    public TeamMembers(Role member_role, Team team, User user, Set<StandUp> comments) {
        this.member_role = member_role;
        this.team = team;
        this.user = user;
        this.comments = comments;
    }



}
