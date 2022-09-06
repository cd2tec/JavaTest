package com.testInstivo.demo.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DispatchDTO {
    String cep;
    String logradouro;
    String complemento;
    String bairro;
    String localidade;
    String uf;
    Number ibge;
    Number gia;
    Number ddd;
    Number siafi;
}
