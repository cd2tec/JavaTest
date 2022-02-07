package teste.sigabem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import teste.sigabem.entities.CalculoFrete;

import java.math.BigDecimal;
import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@Setter
public class CalculoFreteDTO {
    private String cepOrigem;
    private String cepDestino;
    private BigDecimal valorTotalFrete;
    private LocalDate dataPrevistaEntrega;

    public CalculoFreteDTO(CalculoFrete calcularFrete) {
        this.cepOrigem = calcularFrete.getCepOrigem();
        this.cepDestino = calcularFrete.getCepDestino();
        this.valorTotalFrete = calcularFrete.getValorTotalFrete();
        this.dataPrevistaEntrega = calcularFrete.getDataPrevistaEntrega();
    }
}