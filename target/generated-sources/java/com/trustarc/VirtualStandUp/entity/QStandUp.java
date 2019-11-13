package com.trustarc.VirtualStandUp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStandUp is a Querydsl query type for StandUp
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStandUp extends EntityPathBase<StandUp> {

    private static final long serialVersionUID = 310266951L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStandUp standUp = new QStandUp("standUp");

    public final StringPath blockers = createString("blockers");

    public final QMeeting meeting;

    public final QTeamMembers member;

    public final ComparablePath<java.util.UUID> standupID = createComparable("standupID", java.util.UUID.class);

    public final StringPath today = createString("today");

    public final StringPath yesterday = createString("yesterday");

    public QStandUp(String variable) {
        this(StandUp.class, forVariable(variable), INITS);
    }

    public QStandUp(Path<? extends StandUp> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStandUp(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStandUp(PathMetadata metadata, PathInits inits) {
        this(StandUp.class, metadata, inits);
    }

    public QStandUp(Class<? extends StandUp> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.meeting = inits.isInitialized("meeting") ? new QMeeting(forProperty("meeting"), inits.get("meeting")) : null;
        this.member = inits.isInitialized("member") ? new QTeamMembers(forProperty("member"), inits.get("member")) : null;
    }

}

