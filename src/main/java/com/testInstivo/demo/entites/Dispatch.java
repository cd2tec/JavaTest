package com.testInstivo.demo.entites;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
public class Dispatch {
    Double weight;
    String zip_code_origin;
    String zip_code_destination;
    String name_destinatio;
 }
