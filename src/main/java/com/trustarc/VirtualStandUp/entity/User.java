package com.trustarc.VirtualStandUp.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Type(type = "pg-uuid")
    @Column(name="users_id")
    private UUID userID;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user")
    Set<TeamMembers> teams;

    public User(String userName, String password, String name, String email, Set<TeamMembers> teams) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.email = email;
        this.teams = teams;
    }
}
