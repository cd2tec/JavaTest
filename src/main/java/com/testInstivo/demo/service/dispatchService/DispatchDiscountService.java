package com.testInstivo.demo.service.dispatchService;

import com.testInstivo.demo.DTO.DispatchDTO;
import com.testInstivo.demo.entites.Dispatch;
import com.testInstivo.demo.exception.ApiRequestException;
import com.testInstivo.demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispatchDiscountService {
    @Autowired
    private Utils utils;

    public Dispatch discount(Dispatch request, DispatchDTO dispatchSender, DispatchDTO dispatchDestiny) {

        if (dispatchSender.getLocalidade().equals(dispatchDestiny.getLocalidade())) {
            return this.utils.discountLocation(request);
        }

        if (dispatchSender.getDdd().equals(dispatchDestiny.getDdd())) {
            return this.utils.discountDDD(request);
        }

        if (dispatchSender.getLocalidade() != dispatchDestiny.getLocalidade()) {
            return this.utils.noDiscount(request);
        }

        throw new ApiRequestException("Nenhuma condição do disconto foi atendida");

    }
}
