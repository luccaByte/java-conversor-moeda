package com.conversor.models;

import com.conversor.services.ExchangeRateClient;

import java.util.Scanner;

public class CurrencyConverter {
    public static int exibirMenuMoedas(Scanner sc, String titulo) {
        System.out.printf("""
        ------------------------------------
                Conversor de Moedas
        %s
        1. ARS - Peso argentino
        2. BOB - Boliviano boliviano            
        3. BRL - Real brasileiro         
        4. CLP - Peso chileno
        5. COP - Peso colombiano
        6. USD - Dólar americano
        0. Sair  
        ------------------------------------
        Escolha uma opção: """, titulo);
        return sc.nextInt();
    }

    public static double solicitarValor(Scanner sc) {
        System.out.print("Digite o valor: ");
        return sc.nextDouble();
    }

    public static void processarConversao(ExchangeRateClient exchangeRateClient, String escolha1, String escolha2, double valor) {
        try {
            ExchangeRateResponse response = exchangeRateClient.exchangeRequisicao(escolha1);
            double taxaConversao = response.conversion_rates().get(escolha2);

            double result = valor * taxaConversao;

            System.out.printf("""
            ------------------------------------
            Resultado da conversão:
            
            %s  =   $ %.2f 
            %s  =   $ %.2f
            
            Taxa de conversão:  %.2f
            ------------------------------------
            """, escolha1, valor, escolha2, result, taxaConversao);
        } catch (Exception e) {
            System.err.println("Erro ao converter: " + e.getMessage());
        }
    }

    public static String codigoMoeda(int opcao) {
        return switch (opcao) {
            case 1 -> "ARS";
            case 2 -> "BOB";
            case 3 -> "BRL";
            case 4 -> "CLP";
            case 5 -> "COP";
            case 6 -> "USD";
            default -> null;
        };
    }
}
