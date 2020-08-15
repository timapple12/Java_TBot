package com.example.bot.config;

import com.example.bot.domain.BotEntity;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;

@Data
@Configuration
@ConfigurationProperties(prefix = "bot")
public class BotConfig {
    private String webHookPath;
    private String botUserName;
    private String botToken;

    private DefaultBotOptions.ProxyType proxyType;
    private String proxyHost;
    private int proxyPort;

    @Bean
    public BotEntity MySuperTelegramBot() {
        DefaultBotOptions options = ApiContext
                .getInstance(DefaultBotOptions.class);


        BotEntity mySuperTelegramBot = new BotEntity();
        mySuperTelegramBot.setBotName(botUserName);
        mySuperTelegramBot.setBotToken(botToken);
        mySuperTelegramBot.setWebHookPath(webHookPath);

        return mySuperTelegramBot;
    }
}