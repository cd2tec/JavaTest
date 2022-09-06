package com.testInstivo.demo.utils;

import com.testInstivo.demo.entites.ResponseDispatch;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class Utils {

    protected String setDateTime(Long d) {
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("d/MM/yyyy");
        return LocalDate.now().plusDays(d).format(formatterDate);

    }

    public ResponseDispatch discountDDD(ResponseDispatch responseDispatch) {
        var freight = responseDispatch.getCost_freight() / 2;

        responseDispatch.setCost_freight(freight);
        responseDispatch.setExpected_delivery_date(this.setDateTime(1l));

        return responseDispatch;


    }


    public ResponseDispatch discountLocation(ResponseDispatch responseDispatch) {
        var freight = responseDispatch.getCost_freight() / 4;

        responseDispatch.setCost_freight(freight);
        responseDispatch.setExpected_delivery_date(this.setDateTime(3l));

        return responseDispatch;

    }

    public ResponseDispatch noDiscount(ResponseDispatch responseDispatch) {
        responseDispatch.setExpected_delivery_date(this.setDateTime(10l));
        return responseDispatch;

    }
}
