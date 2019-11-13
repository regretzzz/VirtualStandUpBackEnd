package com.trustarc.VirtualStandUp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTeamMembers is a Querydsl query type for TeamMembers
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTeamMembers extends EntityPathBase<TeamMembers> {

    private static final long serialVersionUID = 230210610L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTeamMembers teamMembers = new QTeamMembers("teamMembers");

    public final SetPath<StandUp, QStandUp> comments = this.<StandUp, QStandUp>createSet("comments", StandUp.class, QStandUp.class, PathInits.DIRECT2);

    public final EnumPath<Role> member_role = createEnum("member_role", Role.class);

    public final ComparablePath<java.util.UUID> memberID = createComparable("memberID", java.util.UUID.class);

    public final QTeam team;

    public final QUser user;

    public QTeamMembers(String variable) {
        this(TeamMembers.class, forVariable(variable), INITS);
    }

    public QTeamMembers(Path<? extends TeamMembers> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTeamMembers(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTeamMembers(PathMetadata metadata, PathInits inits) {
        this(TeamMembers.class, metadata, inits);
    }

    public QTeamMembers(Class<? extends TeamMembers> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.team = inits.isInitialized("team") ? new QTeam(forProperty("team")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

