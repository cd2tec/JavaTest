package com.testInstivo.demo.service.zipCodeService;

import com.testInstivo.demo.DTO.DispatchDTO;
import com.testInstivo.demo.entites.Dispatch;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DispatchCreateService {

    public ResponseEntity create(Dispatch request) {

        final String uri = "https://viacep.com.br/ws/" + request.getZip_code_origin() + "/json/";

        RestTemplate restTemplate = new RestTemplate();

        DispatchDTO sender = restTemplate.getForObject(uri, DispatchDTO.class);
        DispatchDTO destiny = restTemplate.getForObject(uri, DispatchDTO.class);


        if(sender.getDdd().equals(destiny.getCep())) {

        }


        return new ResponseEntity(sender, HttpStatus.ACCEPTED);

    }
}
