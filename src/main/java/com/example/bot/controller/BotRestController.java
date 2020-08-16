package com.example.bot.controller;

import com.example.bot.domain.BotEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public BotApiMethod<?> onUpdate(@RequestBody Update update){
        return botEntity.onWebhookUpdateReceived(update);
    }

    @GetMapping("/")
    public String get(){
        return "hello";
    }

}
