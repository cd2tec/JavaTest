package com.testInstivo.demo.entites;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class ZipCode {
    String weight;
    String zip_code;
    String zip_code_destination;
    String addressee;
}
