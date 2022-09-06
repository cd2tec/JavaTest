package com.testInstivo.demo.entites;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "tb_dispatch")
public class ResponseDispatch {
    @Id
    @SequenceGenerator(name = "tb_dispatch", sequenceName = "tb_dispatch", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_dispatch")
    private Long id;

    long cost_freight;
    String expected_delivery_date;
    Number zip_code_origin;
    Number zip_code_destination;


}
