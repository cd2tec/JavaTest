package com.testInstivo.demo.utils;

import com.testInstivo.demo.entites.Dispatch;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class Utils {

    protected String setDateTime(Long d) {
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("d/MM/yyyy");

        return LocalDate.now().plusDays(d).format(formatterDate);

    }

    public Dispatch discountDDD(Dispatch request) {
        var freight = Math.toIntExact(Math.round(request.getWeight() / 2));

        request.setCostFreight(freight);
        request.setExpectedDeliveryDate(this.setDateTime(1l));

        return request;


    }


    public Dispatch discountLocation(Dispatch request) {
        var freight = Math.toIntExact(Math.round(request.getWeight() / 4));

        request.setCostFreight(freight);
        request.setExpectedDeliveryDate(this.setDateTime(3l));

        return request;

    }

    public Dispatch noDiscount(Dispatch request) {
        request.setExpectedDeliveryDate(this.setDateTime(10l));
        return request;

    }
}
