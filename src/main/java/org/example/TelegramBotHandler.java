package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBotHandler extends TelegramLongPollingBot {
    private String botUsername = "firsttgbot1323D_bot";
    private String botToken = "6712589648:AAFTLCwSG3Hqcvb-Rv7lmQWeadzvtLocF2A";

    private BotLogic botLogic = new BotLogic();

    @Override
    public void onUpdateReceived(Update update) {
        long chatId = 0;
        String textFromUser = "";

        SendMessage messageToUser = new SendMessage();
        ;

        if (update.hasMessage()) {
            chatId = update.getMessage().getChatId();
            textFromUser = update.getMessage().getText();

            botLogic.processTextMessageFromUser(textFromUser, messageToUser);

        } else if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getMessage().getChatId();
            textFromUser = update.getCallbackQuery().getData();

            botLogic.processInlineButtonClickFromUser(textFromUser, messageToUser);
        }

        messageToUser.setChatId(chatId);

        try {
            execute(messageToUser);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
