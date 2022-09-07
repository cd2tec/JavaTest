package com.testInstivo.demo.entites;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Dispatch {
    @DecimalMin(value = "0.1", message = "Peso não pode estar vazio")
    private Double weight;
    @Size(min = 8, message = "Cep deve ter 8 digitos")
    private String zip_code_origin;
    @Size(min = 8, message = "Cep deve ter 8 digitos")
    private String zip_code_destination;
    @NotBlank(message = "Nome do destinatário não pode estar vazio")
    private String recipient_name;
}
