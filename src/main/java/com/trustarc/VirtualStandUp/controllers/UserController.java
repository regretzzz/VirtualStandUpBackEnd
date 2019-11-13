package com.trustarc.VirtualStandUp.controllers;


import com.trustarc.VirtualStandUp.components.EntityToDTOConverter;
import com.trustarc.VirtualStandUp.dto.UserDTO;
import com.trustarc.VirtualStandUp.entity.Team;
import com.trustarc.VirtualStandUp.entity.User;
import com.trustarc.VirtualStandUp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;


class LoginForm {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginForm() {
    }

    public LoginForm(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController  {

    @Autowired
    private UserService userService;

    @Autowired
    private EntityToDTOConverter entityToDTOConverter;

    @PostMapping("login")
    public UserDTO CheckUserExist(@RequestBody LoginForm  checkLogin ){
        User checkUser = userService.FindUser(checkLogin.getUsername(), checkLogin.getPassword());

        UserDTO userDTO = entityToDTOConverter.EntitytoUserDTO(checkUser);

        if(checkUser != null){
            return userDTO;
        }

        return null;
    }

}
