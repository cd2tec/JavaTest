package com.testInstivo.demo.entites;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Getter
@Setter
public class Dispatch {
    Double weight;
    Number zip_code_origin;
    Number zip_code_destination;
    String recipient_name;
}
