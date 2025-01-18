package org.example.Model.Persistence;

import org.example.Model.Currency;
import org.example.Model.exchangeRate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONObject;

public class ExchangeRateLoader implements ExchangeRateMethods {

    @Override
    public exchangeRate load(Currency from, Currency to) {
        try {
            double rate = read(from.getCode(), to.getCode());
            return new exchangeRate(from, to, rate);
        } catch (IOException ex) {
            System.err.println("Error al obtener la tasa de cambio: " + ex.getMessage());
            return null;
        }
    }

    /**
     * Obtiene la tasa de cambio entre dos divisas utilizando la API.
     */
    private double read(String from, String to) throws IOException {
        String url = buildUrl(from);
        return parseRateFromJson(url, to);
    }

    /**
     * Construye la URL para obtener los datos de la tasa de cambio entre dos divisas.
     */
    private String buildUrl(String from) throws IOException {
        // Usamos una API gratuita para tasas de cambio sin necesidad de clave
        String urlString = "https://api.exchangerate-api.com/v4/latest/" + from;
        return urlString;
    }

    /**
     * Extrae la tasa de cambio del JSON.
     * @param url la URL desde donde obtenemos los datos
     * @param to la divisa de destino
     */
    private double parseRateFromJson(String url, String to) throws IOException {
        // Conectar con la API
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Imprimir la respuesta para depuración
            System.out.println("Respuesta de la API: " + response.toString());

            // Procesar el JSON
            JSONObject jsonObject = new JSONObject(response.toString());

            // Comprobar si el campo "rates" existe en la respuesta
            if (!jsonObject.has("rates")) {
                System.err.println("El campo 'rates' no se encuentra en la respuesta.");
                return 0;  // Valor por defecto en caso de error
            }

            // Obtener las tasas de cambio y devolver la tasa de la divisa "to"
            JSONObject rates = jsonObject.getJSONObject("rates");
            return rates.getDouble(to);  // Obtenemos la tasa de cambio para la divisa "to"
        } catch (IOException e) {
            System.err.println("Error al obtener la tasa de cambio: " + e.getMessage());
            return 0;  // Valor por defecto en caso de error
        } catch (org.json.JSONException e) {
            System.err.println("Error al analizar el JSON: " + e.getMessage());
            return 0;  // Valor por defecto en caso de error al analizar
        }
    }
}
