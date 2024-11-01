package com.conversor;

import com.conversor.models.CurrencyConverter;
import com.conversor.services.ExchangeRateClient;

import java.util.Scanner;

public class ConversorApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExchangeRateClient exchangeRateClient = new ExchangeRateClient();

        int opcao1, opcao2;

        do {
            opcao1 = CurrencyConverter.exibirMenuMoedas(sc, "Converter de:");
            if (opcao1 == 0) {
                System.out.println("Saindo. . .");
                break;
            }

            opcao2 = CurrencyConverter.exibirMenuMoedas(sc, "Para:");
            if (opcao2 == 0) {
                System.out.println("Saindo. . .");
                break;
            }

            double valor = CurrencyConverter.solicitarValor(sc);

            String escolha1 = CurrencyConverter.codigoMoeda(opcao1);
            String escolha2 = CurrencyConverter.codigoMoeda(opcao2);

            CurrencyConverter.processarConversao(exchangeRateClient, escolha1, escolha2, valor);

        } while (true);

        sc.close();
    }
}
