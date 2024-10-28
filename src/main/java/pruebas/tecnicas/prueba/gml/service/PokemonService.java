package pruebas.tecnicas.prueba.gml.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pruebas.tecnicas.prueba.gml.dao.PokemonDAO;

public class PokemonService {
    private PokemonDAO pokemonDAO = new PokemonDAO();

    public String getPagedPokemons(int limit, int offset) {
        try {
            String jsonData = pokemonDAO.getPokemons(limit, offset);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonData);


            JsonNode resultsNode = rootNode.path("results");
            StringBuilder result = new StringBuilder("Pokemons: ");
            resultsNode.forEach(pokemon -> result.append(pokemon.path("name").asText()).append(", "));
            
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching pokemons";
        }
    }
}
