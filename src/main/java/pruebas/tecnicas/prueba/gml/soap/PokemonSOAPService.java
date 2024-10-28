package pruebas.tecnicas.prueba.gml.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace = "http://gml.prueba.tecnicas.pruebas/")
public interface PokemonSOAPService {
    @WebMethod
    String getPokemonList(int limit, int offset);
}

