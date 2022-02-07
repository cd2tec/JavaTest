package teste.sigabem.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
@Getter
@Setter
public class CepDTO {
    private String cep;
    private String uf;
    private String ddd;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String ibge;
    private String gia;
    private String siafi;
}
