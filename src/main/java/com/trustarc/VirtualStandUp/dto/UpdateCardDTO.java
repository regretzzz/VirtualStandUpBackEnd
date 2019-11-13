package com.trustarc.VirtualStandUp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateCardDTO {
    UserDTO user;
    StandUpDTO standUp;

}
