package org.example;

import java.net.http.*;
import java.net.URI;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la moneda de origen (por ejemplo, USD): ");
        String monedaOrigen = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese la moneda de destino (por ejemplo, ARS): ");
        String monedaDestino = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese el monto a convertir: ");
        double monto = scanner.nextDouble();

        // Construir URL con moneda origen
        String url = "https://v6.exchangerate-api.com/v6/79041a848623d77af6d0dab4/latest/" + monedaOrigen;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Parsear JSON
        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        if (conversionRates.has(monedaDestino)) {
            double tasa = conversionRates.get(monedaDestino).getAsDouble();
            double resultado = monto * tasa;

            System.out.println("\n" + monto + " " + monedaOrigen + " equivalen a " + resultado + " " + monedaDestino);
        } else {
            System.out.println("Moneda destino no encontrada en la API.");
        }

        scanner.close();
    }
}
