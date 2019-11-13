package com.trustarc.VirtualStandUp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTeam is a Querydsl query type for Team
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTeam extends EntityPathBase<Team> {

    private static final long serialVersionUID = 1132192487L;

    public static final QTeam team = new QTeam("team");

    public final SetPath<Meeting, QMeeting> meetings = this.<Meeting, QMeeting>createSet("meetings", Meeting.class, QMeeting.class, PathInits.DIRECT2);

    public final SetPath<TeamMembers, QTeamMembers> members = this.<TeamMembers, QTeamMembers>createSet("members", TeamMembers.class, QTeamMembers.class, PathInits.DIRECT2);

    public final StringPath teamDesc = createString("teamDesc");

    public final ComparablePath<java.util.UUID> teamId = createComparable("teamId", java.util.UUID.class);

    public final StringPath teamImage = createString("teamImage");

    public final StringPath teamName = createString("teamName");

    public QTeam(String variable) {
        super(Team.class, forVariable(variable));
    }

    public QTeam(Path<? extends Team> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTeam(PathMetadata metadata) {
        super(Team.class, metadata);
    }

}

