package com.testInstivo.demo.service.dispatchService;

import com.testInstivo.demo.DTO.DispatchDTO;
import com.testInstivo.demo.entites.Dispatch;
import com.testInstivo.demo.entites.ResponseDispatch;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class DispatchStoreService {
    final DispatchFindService dispatchFindService;
    final DispatchDiscountService dispatchDiscountService;

    public ResponseEntity store(Dispatch request) {
        var dispatchSender = this.dispatchFindService.findViaCep(request.getZip_code_origin());
        var dispatchDestiny = this.dispatchFindService.findViaCep(request.getZip_code_destination());

        var responseDispatch = this.dispatchDiscountService.discount(dispatchSender, dispatchDestiny, this.setValues(request));

        return new ResponseEntity(responseDispatch, HttpStatus.ACCEPTED);
    }

    protected ResponseDispatch setValues(Dispatch request) {
        var responseDispatch = new ResponseDispatch();

        responseDispatch.setCost_freight(Math.round(request.getWeight()));
        responseDispatch.setZip_code_origin(request.getZip_code_origin());
        responseDispatch.setZip_code_destination(request.getZip_code_destination());


        return responseDispatch;

    }
}
