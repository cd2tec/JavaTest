package com.testInstivo.demo.service.dispatchService;

import com.testInstivo.demo.DTO.DispatchDTO;
import com.testInstivo.demo.entites.ResponseDispatch;

public class DispatchDiscountService {

    public void discount(DispatchDTO dispatchSender, DispatchDTO dispatchDestiny) {
        var responseDispatch = new ResponseDispatch();

        if(dispatchSender.getLocalidade() != dispatchDestiny.getLocalidade()) {
            return;
        }

        responseDispatch.setExpected_delivery_date(10);
//
//        if (dispatchSender.getDdd().equals(dispatchDestiny.getDdd())) {
//            var freight = Math.round(request.getWeight()) / 2;
//
//            responseDispatch.setCost_freight(freight);
//            responseDispatch.setExpected_delivery_date(1);
//        }
//
//
//        if (dispatchSender.getLocalidade().equals(dispatchDestiny.getLocalidade())) {
//            var freight = Math.round(request.getWeight()) / 4;
//
//            responseDispatch.setCost_freight(freight);
//            responseDispatch.setExpected_delivery_date(3);
//        }
//

    }
}
