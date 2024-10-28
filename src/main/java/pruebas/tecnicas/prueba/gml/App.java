package pruebas.tecnicas.prueba.gml;

import pruebas.tecnicas.prueba.gml.soap.PokemonSOAPService;
import pruebas.tecnicas.prueba.gml.soap.PokemonSOAPServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class App {
    public static void main(String[] args) {
        try {
            JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
            factory.setServiceClass(PokemonSOAPService.class);
            factory.setAddress("http://localhost:8080/pokemon");
            factory.setServiceBean(new PokemonSOAPServiceImpl());

            factory.create();
            System.out.println("Pokemon SOAP Service is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

