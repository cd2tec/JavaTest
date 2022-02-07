package teste.sigabem.services;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import teste.sigabem.dto.CepDTO;
import teste.sigabem.dto.FreteDTO;
import teste.sigabem.entities.CalculoFrete;
import teste.sigabem.repositories.CalculoFreteRepository;
import teste.sigabem.utills.CalculoFreteUtil;

@Service
public class FreteServiceImpl implements FreteService{
    private static final Logger log = LoggerFactory.getLogger(FreteServiceImpl.class);

    private static final String viaCepUrl = "https://viacep.com.br/ws/";
    private final Gson gson;
    private final CalculoFreteRepository repository;

    public FreteServiceImpl(Gson gson, CalculoFreteRepository repository){
        this.gson = gson;
        this.repository = repository;
    }

    @Override
    public CepDTO findCep(String cep) {
        CalculoFreteUtil.validaCep(cep);
        try {
            HttpClient httpClient = HttpClient.newBuilder()
                    .connectTimeout(Duration.of(1, MINUTES))
                    .build();

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(viaCepUrl+cep+"/json"))
                    .build();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            log.info("[VIA CEP API] - [RESULTADO DA BUSCA: {}]", httpResponse.body());

            return gson.fromJson(httpResponse.body(), CepDTO.class);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public CalculoFrete calcularFrete(FreteDTO freteDTO) {
        LocalDate dataPrevista = LocalDate.now();

        CepDTO cepOrigem = findCep(freteDTO.getCepOrigem());
        CepDTO cepDestino = findCep(freteDTO.getCepDestino());

        BigDecimal valorFrete = BigDecimal.valueOf(freteDTO.getPeso());

        if (cepOrigem.getDdd().equals(cepDestino.getDdd())) {
            if (cepOrigem.getUf().equals(cepDestino.getUf())) {
                valorFrete = valorFrete.multiply(BigDecimal.valueOf(0.25));
                dataPrevista = dataPrevista.plusDays(3);
            }else {
                valorFrete = valorFrete.divide(BigDecimal.valueOf(2));
                dataPrevista = dataPrevista.plusDays(1);
            }
        } else {
            dataPrevista = dataPrevista.plusDays(10);
        }
        CalculoFrete calculo = new CalculoFrete(
                freteDTO.getPeso(),
                cepOrigem.getCep(),
                cepDestino.getCep(),
                freteDTO.getDestinatario(),
                valorFrete,
                dataPrevista,
                LocalDate.now());

        repository.save(calculo);

        return calculo;
    }
}
