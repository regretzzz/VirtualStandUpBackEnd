package com.trustarc.VirtualStandUp.dto;

import com.trustarc.VirtualStandUp.entity.Role;
import com.trustarc.VirtualStandUp.entity.StandUp;
import com.trustarc.VirtualStandUp.entity.Team;
import com.trustarc.VirtualStandUp.entity.User;

import java.util.Set;
import java.util.UUID;

public class TeamMemberDTO {
    private UUID memberID;
    private Role member_role;
    private User user;

    public TeamMemberDTO(UUID memberID, Role member_role, User user) {
        this.memberID = memberID;
        this.member_role = member_role;
        this.user = user;
    }

    public UUID getMemberID() {
        return memberID;
    }

    public void setMemberID(UUID memberID) {
        this.memberID = memberID;
    }

    public Role getMember_role() {
        return member_role;
    }

    public void setMember_role(Role member_role) {
        this.member_role = member_role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
