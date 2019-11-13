package com.trustarc.VirtualStandUp.service;

import com.trustarc.VirtualStandUp.entity.User;
import com.trustarc.VirtualStandUp.repository.UsersJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    UsersJpaRepository userRepo;

    public User FindUser(String username, String password){
        User user = new User();
        return userRepo.findByUserNameAndPassword(username,password);

    }

}
