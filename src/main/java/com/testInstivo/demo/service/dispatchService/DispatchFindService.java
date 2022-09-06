package com.testInstivo.demo.service.dispatchService;

import com.testInstivo.demo.DTO.DispatchDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DispatchFindService {
    public DispatchDTO findViaCep(String ZipCode) {
        final String uri = "https://viacep.com.br/ws/" + ZipCode + "/json/";

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(uri, DispatchDTO.class);

    }
}
