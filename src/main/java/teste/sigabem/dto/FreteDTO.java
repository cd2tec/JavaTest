package teste.sigabem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class FreteDTO {
    private Double peso;
    private String cepOrigem;
    private String cepDestino;
    private String destinatario;
}

