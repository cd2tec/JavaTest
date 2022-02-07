package br.com.sigabem.ViaCep;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ViaCep {

   private String cep;
   private String logradouro;
   private String complemento;
   private String bairro;
   private String localidade;
   private String uf;
   private String ibge;
   private String gia;
   private String ddd;
   private String siafi;
}
