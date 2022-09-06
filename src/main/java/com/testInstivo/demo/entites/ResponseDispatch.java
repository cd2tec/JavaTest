package com.testInstivo.demo.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
public class ResponseDispatch {
    long cost_freight;
    Number expected_delivery_date;
    String zip_code_origin;
    String zip_code_destination;
}
