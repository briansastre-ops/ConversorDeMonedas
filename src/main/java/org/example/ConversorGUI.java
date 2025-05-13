
package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Conversor de Monedas");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 250);
            frame.setLayout(new GridLayout(6, 1));

            String[] monedas = {"USD", "EUR", "ARS", "BRL", "CLP", "GBP", "MXN", "JPY"};

            JComboBox<String> comboOrigen = new JComboBox<>(monedas);
            JComboBox<String> comboDestino = new JComboBox<>(monedas);
            JTextField campoMonto = new JTextField();
            JButton botonConvertir = new JButton("Convertir");
            JLabel resultado = new JLabel("Resultado: ", SwingConstants.CENTER);

            frame.add(new JLabel("Moneda Origen:", SwingConstants.CENTER));
            frame.add(comboOrigen);
            frame.add(new JLabel("Moneda Destino:", SwingConstants.CENTER));
            frame.add(comboDestino);
            frame.add(new JLabel("Monto a Convertir:", SwingConstants.CENTER));
            frame.add(campoMonto);
            frame.add(botonConvertir);
            frame.add(resultado);

            botonConvertir.addActionListener((ActionEvent e) -> {
                try {
                    String origen = comboOrigen.getSelectedItem().toString();
                    String destino = comboDestino.getSelectedItem().toString();
                    double monto = Double.parseDouble(campoMonto.getText());

                    String url = "https://v6.exchangerate-api.com/v6/79041a848623d77af6d0dab4/latest/" + origen;

                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(url))
                            .build();
                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                    JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
                    JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

                    if (rates.has(destino)) {
                        double tasa = rates.get(destino).getAsDouble();
                        double convertido = monto * tasa;
                        resultado.setText("Resultado: " + convertido + " " + destino);
                    } else {
                        resultado.setText("Moneda destino no encontrada.");
                    }
                } catch (Exception ex) {
                    resultado.setText("Error: " + ex.getMessage());
                }
            });

            frame.setVisible(true);
        });
    }
}
