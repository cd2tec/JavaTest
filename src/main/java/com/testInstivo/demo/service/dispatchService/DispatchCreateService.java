package com.testInstivo.demo.service.dispatchService;

import com.testInstivo.demo.DTO.DispatchDTO;
import com.testInstivo.demo.entites.Dispatch;
import com.testInstivo.demo.entites.ResponseDispatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DispatchCreateService {

    @Autowired
    DispatchFindService dispatchFindService;

    public ResponseEntity create(Dispatch request) {
        var dispatchSender = this.dispatchFindService.findViaCep(request.getZip_code_origin());

        var dispatchDestiny = this.dispatchFindService.findViaCep(request.getZip_code_destination());

       

    }
}
