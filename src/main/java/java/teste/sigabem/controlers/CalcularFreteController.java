package java.teste.sigabem.controlers;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.teste.sigabem.entities.CepOrigem;
import java.teste.sigabem.repositories.CalcularFreteRepository;
import java.teste.sigabem.utills.CalcularFreteUtil;
import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;


public class CalcularFreteController {
	
	private CalcularFreteRepository repository;
	
	private static final String viaCepUrl = "https://viacep.com.br/ws/";
    private static final Gson gson = new Gson();
    
    private static final Logger log = LoggerFactory.getLogger(CalcularFreteController.class);

    public static CepOrigem findCep(String cepString) {
        CalcularFreteUtil.validaCep(cepString);
        try {
            HttpClient httpClient = HttpClient.newBuilder()
                    .connectTimeout(Duration.of(1, MINUTES))
                    .build();

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(viaCepUrl+cepString+"/json"))
                    .build();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            log.info("[VIA CEP API] - [RESULTADO DA BUSCA: {}]", httpResponse.body());

            return gson.fromJson(httpResponse.body(), CepOrigem.class);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

}
