package teste.sigabem.utills;


import teste.sigabem.exceptions.CalculoFreteException;
import teste.sigabem.exceptions.CalculoFreteFormatException;
import java.util.Objects;

public class CalculoFreteUtil {
	
	public static void validaCep(String cep){
        if (Objects.isNull(cep) || cep.isEmpty() || cep.isBlank()) throw new CalculoFreteException("O cep informado não pode ser nulo ou vazio");
        if (cep.length() > 8) throw new CalculoFreteFormatException("CEP fora do formato, caso esteja com hifen, use o metodo de formatacao");
        if (cep.length() < 8) throw new CalculoFreteException("CEP faltando numeros");
    }

}
