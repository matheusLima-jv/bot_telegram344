package GRL_BOT_TELEGRAM.bot.telegram.interfacesbot;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public interface UrlCheck {

    static String checkURL(String urlString) {
        HttpURLConnection connection = null;
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000); // 5 segundos de timeout
            connection.setReadTimeout(5000); // 5 segundos de timeout

            long startTime = System.currentTimeMillis();
            connection.connect();
            long endTime = System.currentTimeMillis();

            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();
            long responseTime = endTime - startTime;

            response.append("URL: ").append(urlString).append("\n");
            response.append("Tempo de resposta: ").append(responseTime).append(" ms\n");
            response.append("Código de resposta: ").append(responseCode).append("\n");
            response.append("Mensagem de resposta: ").append(responseMessage).append("\n");

            if (responseCode == HttpURLConnection.HTTP_OK) {
                response.append("Status: Online");
            } else {
                response.append("Status: Offline ou com Problemas");
            }

        } catch (IOException e) {
            response.append("URL: ").append(urlString).append("\n");
            response.append("Status: Erro ao conectar\n");
            response.append("Mensagem de erro: ").append(e.getMessage());
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return response.toString();
    }
}
