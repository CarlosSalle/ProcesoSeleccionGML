package pruebas.tecnicas.prueba.gml.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import pruebas.tecnicas.prueba.gml.service.PokemonService;

/*
@WebService(endpointInterface = "pruebas.tecnicas.prueba.gml.soap.PokemonSOAPService")
public class PokemonSOAPServiceImpl implements PokemonSOAPService {
    private PokemonService pokemonService = new PokemonService();

    @Override
    public String getPokemonList(int limit, int offset) {
        return pokemonService.getPagedPokemons(limit, offset);
    }
}*/
@WebService(endpointInterface = "pruebas.tecnicas.prueba.gml.soap.PokemonSOAPService", targetNamespace = "http://gml.prueba.tecnicas.pruebas/")
public class PokemonSOAPServiceImpl implements PokemonSOAPService {

	@Override
	@WebMethod
	public String getPokemonList(@WebParam(name = "limit") int limit, @WebParam(name = "offset") int offset) {
		PokemonService pokemonService = new PokemonService();
		return pokemonService.getPagedPokemons(limit, offset);
	}
}
