package com.example.bot.dao;

import com.example.bot.domain.UserData;
import com.example.bot.states.States;

public interface StateMethods {
    void setCurrentState(long userId, States states);

    States getCurrentState(long userId);

    UserData getUserData(long userId);
}
