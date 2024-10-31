package com.conversor.services;

import com.google.gson.Gson;
import com.conversor.models.ExchangeRateResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ExchangeRateClient {
    private static final String apiKey;
    private static final String baseUrl = "https://v6.exchangerate-api.com/v6/";

    static {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("src/resources/config.properties")) {
            if (input == null) {
                throw new IOException("Configuração de arquivo não encontrada!");
            }
            properties.load(input);
            apiKey = properties.getProperty("EXCHANGE_API_KEY");
        } catch (IOException e) {
            throw new RuntimeException("Falha ao carregar a API key", e);
        }
    }

    public ExchangeRateResponse exchangeRequisicao(String moedaBase) {
        String endpoint = baseUrl + apiKey + "/latest/" + moedaBase;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                return gson.fromJson(response.body(), ExchangeRateResponse.class);
            } else {
                System.err.println("Erro na requisição: " + response.statusCode());
                return null;
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao enviar requisição para a API.", e);
        }
    }
}
