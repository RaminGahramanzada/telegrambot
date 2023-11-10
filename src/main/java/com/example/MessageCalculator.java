package com.example;

import io.quarkus.scheduler.Scheduled;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalTime;
import java.util.UUID;

@ApplicationScoped
public class MessageCalculator {

    @Inject
    TelegramBot bot;

    @Scheduled(every = "2s")
    public void message() {
        String message = "Now it is " + LocalTime.now().withNano(0) + ": " + UUID.randomUUID();
        bot.sendMessage(message);
    }

}