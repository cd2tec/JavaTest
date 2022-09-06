package com.testInstivo.demo.service.dispatchService;

import com.testInstivo.demo.DTO.DispatchDTO;
import com.testInstivo.demo.entites.Dispatch;
import com.testInstivo.demo.entites.ResponseDispatch;
import com.testInstivo.demo.exception.ApiRequestException;
import com.testInstivo.demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispatchDiscountService {
    @Autowired
    Utils utils;

    public ResponseDispatch discount(DispatchDTO dispatchSender, DispatchDTO dispatchDestiny, ResponseDispatch responseDispatch) {

        if (dispatchSender.getLocalidade().equals(dispatchDestiny.getLocalidade())) {
            return this.utils.discountLocation(responseDispatch);
        }

        if (dispatchSender.getDdd().equals(dispatchDestiny.getDdd())) {

            return this.utils.discountDDD(responseDispatch);
        }

        if (dispatchSender.getLocalidade() != dispatchDestiny.getLocalidade()) {
            return this.utils.noDiscount(responseDispatch);
        }

        throw new ApiRequestException("Parece que temos uma falha interna :(");

    }
}
