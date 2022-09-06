package com.testInstivo.demo.entites;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
public class ZipCode {
    String weight;
    String zip_code;
    String zip_code_destination;
    String addressee;

    public ZipCode(String weight, String zip_code, String zip_code_destination, String addressee) {
        this.weight = weight;
        this.zip_code = zip_code;
        this.zip_code_destination = zip_code_destination;
        this.addressee = addressee;
    }
}
