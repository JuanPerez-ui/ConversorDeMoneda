package com.aluracursos.recursos;

import com.aluracursos.moneda.TasaDeCambio;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi{

    public TasaDeCambio obtieneTasaDeCambio () {
        String direccion = "https://v6.exchangerate-api.com/v6/34d845ec2a1f03e7a22f338c/latest/USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();


        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), TasaDeCambio.class);

        } catch (Exception e) {
            throw new RuntimeException("No encontre la ultima cotizacion de la moneda USD");
        }
    }


}
