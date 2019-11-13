package com.trustarc.VirtualStandUp.service;

import com.trustarc.VirtualStandUp.entity.StandUp;
import com.trustarc.VirtualStandUp.repository.StandUpJpaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StandUpService {

    @Autowired
    StandUpJpaRespository standupRepository;


    public StandUp AddStandUp(StandUp s){
        return standupRepository.save(s);
    }

}
