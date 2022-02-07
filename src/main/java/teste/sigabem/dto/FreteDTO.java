package teste.sigabem.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class FreteDTO {

    @NotNull(message = "O peso deve ser preenchido. ")
    private Double peso;

    @NotEmpty(message = "O Cep de origem deve ser preenchido.")
    private String cepOrigem;

    @NotEmpty(message = "O Cep de destino deve ser preenchido.")
    private String cepDestino;

    @NotEmpty(message = "O destinario deve ser preenchido.")
    private String destinatario;
    
}