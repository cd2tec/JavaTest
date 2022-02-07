package teste.sigabem.services;


import teste.sigabem.dto.CepDTO;
import teste.sigabem.dto.FreteDTO;
import teste.sigabem.entities.CalculoFrete;

public interface FreteService {

    CepDTO findCep(String cep);

    CalculoFrete calcularFrete(FreteDTO freteDTO);
}
