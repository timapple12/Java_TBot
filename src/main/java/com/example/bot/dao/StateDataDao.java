package com.example.bot.dao;

import com.example.bot.domain.UserData;
import com.example.bot.repo.UserDataRepository;
import com.example.bot.states.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StateDataDao implements StateMethods {

    private final UserDataRepository userDataRepository;

    @Autowired
    public StateDataDao(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    @Override
    public void setCurrentState(long userId, States states) {
        UserData userData = new UserData();
        userData.setStates(states);
        userDataRepository.save(userData);
    }

    @Override
    public States getCurrentState(long userId) {
        States state;
        Optional<UserData> userData= userDataRepository.findById(userId);
        if(userData.isEmpty()){
             state = States.ASK_CITY;
        }else {
            state = userData.get().getStates();
        }
        return state;
    }

    @Override
    public UserData getUserData(long userId) {
        UserData userData = userDataRepository.findById(userId).get();
        return userData;
    }
}
