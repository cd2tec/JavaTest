package java.teste.sigabem.utills;

import java.teste.sigabem.exceptions.CalcularFreteException;
import java.teste.sigabem.exceptions.CalcularFreteFormatException;
import java.util.Objects;

public class CalcularFreteUtil {
	
	public static void validaCep(String cep){
        if (Objects.isNull(cep) || cep.isEmpty() || cep.isBlank()) throw new CalcularFreteException("O cep informado não pode ser nulo ou vazio");
        if (cep.length() > 8) throw new CalcularFreteFormatException("CEP fora do formato, caso esteja com hifen, use o metodo de formatacao");
        if (cep.length() < 8) throw new CalcularFreteException("CEP faltando numeros");
    }

}
