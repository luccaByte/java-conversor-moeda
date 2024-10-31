package com.conversor;

import com.conversor.services.ExchangeRateClient;

import java.util.Scanner;

public class ConversorApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExchangeRateClient exchangeRateClient = new ExchangeRateClient();

        try {
            String resultado = String.valueOf(exchangeRateClient.exchangeRequisicao("BRL"));
            System.out.println("Resultado da API: " + resultado);
        } catch (Exception e) {
            System.err.println("Erro ao chamar a API: " + e.getMessage());
        }

        sc.close();
    }
}
