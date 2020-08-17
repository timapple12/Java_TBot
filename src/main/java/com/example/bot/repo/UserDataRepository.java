package com.example.bot.repo;

import com.example.bot.domain.UserData;
import com.example.bot.states.States;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, Long> {

}
