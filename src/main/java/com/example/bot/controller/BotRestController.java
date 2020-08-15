package com.example.bot.controller;

import com.example.bot.domain.BotEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class BotRestController {
    private final BotEntity botEntity;

    @Autowired
    public BotRestController(BotEntity botEntity) {
        this.botEntity = botEntity;
    }
    @PostMapping("/")
    public BotApiMethod<?> onUpdate(@RequestParam Update update){
        return botEntity.onWebhookUpdateReceived(update);
    }

}
