package com.testInstivo.demo.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_dispatch")
public class ResponseDispatch      {
    @Id
    @SequenceGenerator(name = "dispatch_sequence", sequenceName = "dispatch_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dispatch_sequence")
    private Long id;

    private Long cost_freight;
    private String expected_delivery_date;
    private String zip_code_origin;
    private String zip_code_destination;


}
