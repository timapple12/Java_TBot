package com.example.bot.service;

import com.example.bot.dao.StateDataDao;
import com.example.bot.states.States;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class StateBotService {

    private SendMessage sendMessage;
    private StateDataDao stateDataDao;

    public StateBotService(StateDataDao stateDataDao) {
        this.stateDataDao = stateDataDao;
    }

    protected SendMessage proceedOperation(Message message, Update update){
        States states;
        String mess = message.getText();
        long id = message.getChatId();
        switch (mess){
            case "/start":
                states = States.START;
                break;
            case "fill":
                states = States.FILL_DATA;
                break;
            case "city":
                states = States.ASK_CITY;
                break;
            case "/help":
                states = States.HELP;
            default:
                states = States.HELP;
        }
        stateDataDao.setCurrentState(id, states);



    }
}
