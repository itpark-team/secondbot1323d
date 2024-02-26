package org.example;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class BotLogic {
    public void processTextMessageFromUser(String textFromUser, SendMessage messageToUser) {
        if (textFromUser.equals("/start")) {
            String textToUser = "На связи бот утреннего шоу. Выбери на кнопку что вы хотите";

            messageToUser.setText(textToUser);

            List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

            List<InlineKeyboardButton> row;
            InlineKeyboardButton button;

            row = new ArrayList<>();
            button = new InlineKeyboardButton();
            button.setText("Рассказать шутку");
            button.setCallbackData("Joke");
            row.add(button);
            keyboard.add(row);

            row = new ArrayList<>();
            button = new InlineKeyboardButton();
            button.setText("Прочитать прогноз погоды");
            button.setCallbackData("Weather");
            row.add(button);
            keyboard.add(row);

            row = new ArrayList<>();
            button = new InlineKeyboardButton();
            button.setText("Поставить любимую музыку");
            button.setCallbackData("Music");
            row.add(button);
            keyboard.add(row);

            InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
            inlineKeyboardMarkup.setKeyboard(keyboard);

            messageToUser.setReplyMarkup(inlineKeyboardMarkup);

        } else {
            String textToUser = "Ошибка запуска бота. Для старта введите /start";

            messageToUser.setText(textToUser);
        }
    }

    public void processInlineButtonClickFromUser(String textFromUser, SendMessage messageToUser) {
        String textToUser = "";

        if (textFromUser.equals("Joke")) {
            textToUser = "Типо смешная шутка";
        } else if (textFromUser.equals("Weather")) {
            textToUser = "Типо прогноз погоды";
        } else if (textFromUser.equals("Music")) {
            textToUser = "На слушай https://music.yandex.ru/home";
        }

        messageToUser.setText(textToUser);
    }
}
