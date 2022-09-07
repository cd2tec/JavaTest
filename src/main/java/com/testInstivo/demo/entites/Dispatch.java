package com.testInstivo.demo.entites;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "tb_dispatch")
public class Dispatch {
    @Id
    @SequenceGenerator(name = "dispatch_sequence", sequenceName = "dispatch_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dispatch_sequence")
    private Long id;

    @DecimalMin(value = "0.1", message = "Peso não pode estar vazio")
    private Double weight;
    @Size(min = 8, message = "Cep deve ter 8 digitos")
    private String zipCodeOrigin;
    @Size(min = 8, message = "Cep deve ter 8 digitos")
    private String zipCodeDestination;
    @NotBlank(message = "Nome do destinatário não pode estar vazio")
    private String recipientName;

    private int costFreight;

    private String expectedDeliveryDate;



}
