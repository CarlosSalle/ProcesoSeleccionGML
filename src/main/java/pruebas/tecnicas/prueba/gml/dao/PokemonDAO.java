package pruebas.tecnicas.prueba.gml.dao;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class PokemonDAO {
    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon";

    public String getPokemons(int limit, int offset) throws IOException {
        String urlString = BASE_URL + "?limit=" + limit + "&offset=" + offset;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        Scanner scanner = new Scanner(url.openStream());
        StringBuilder jsonResponse = new StringBuilder();
        while (scanner.hasNext()) {
            jsonResponse.append(scanner.nextLine());
        }
        scanner.close();
        return jsonResponse.toString();
    }
}
