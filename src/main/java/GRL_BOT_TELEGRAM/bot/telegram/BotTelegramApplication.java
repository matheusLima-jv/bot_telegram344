package GRL_BOT_TELEGRAM.bot.telegram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class BotTelegramApplication {

	public static void main(String[] args) {
		SpringApplication.run(BotTelegramApplication.class, args);

		try {
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
			telegramBotsApi.registerBot(new EchoBot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

}

