package com.testInstivo.demo.utils;

import com.testInstivo.demo.DTO.DispatchDTO;
import com.testInstivo.demo.entites.ResponseDispatch;
import org.springframework.stereotype.Service;

@Service
public class Utils {

    public ResponseDispatch discountDDD( ResponseDispatch responseDispatch) {
        var freight = responseDispatch.getCost_freight() / 2;
        responseDispatch.setCost_freight(freight);
        responseDispatch.setExpected_delivery_date(1);
        return responseDispatch;


    }


    public ResponseDispatch discountLocation(ResponseDispatch responseDispatch) {
        var freight = responseDispatch.getCost_freight() / 4;
        responseDispatch.setCost_freight(freight);
        responseDispatch.setExpected_delivery_date(3);
        return responseDispatch;

    }

    public ResponseDispatch noDiscount(ResponseDispatch responseDispatch) {
        responseDispatch.setExpected_delivery_date(10);
        return responseDispatch;

    }
}
