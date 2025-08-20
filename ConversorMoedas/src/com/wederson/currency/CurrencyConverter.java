package com.wederson.currency;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter {

    // Coloque aqui a sua chave da API
    private static final String API_KEY = "1bc0e5b81cd4ac2915897b97";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/1bc0e5b81cd4ac2915897b97/latest/";

    // Busca a taxa de câmbio entre duas moedas
    public static double getExchangeRate(String from, String to) {
        try {
            URL url = new URL(API_URL + from);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            JsonObject jsonResponse = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();

            JsonObject rates = jsonResponse.getAsJsonObject("conversion_rates");
            return rates.get(to).getAsDouble();
        } catch (Exception e) {
            System.out.println("Erro ao obter taxa de câmbio: " + e.getMessage());
            return -1;
        }
    }

    // Converte valor entre duas moedas
    public static double convert(String from, String to, double amount) {
        double rate = getExchangeRate(from, to);
        if (rate == -1) return -1;
        return amount * rate;
    }
}
