package com.testInstivo.demo.service.dispatchService;

import com.testInstivo.demo.DTO.DispatchDTO;
import com.testInstivo.demo.exception.ApiRequestException;
import com.testInstivo.demo.repository.DispatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class DispatchFindService {
    @Autowired
    DispatchRepository dispatchRepository;

    public DispatchDTO findViaCep(String ZipCode) {
        try {
            final String uri = "https://viacep.com.br/ws/" + ZipCode + "/json/";

            RestTemplate restTemplate = new RestTemplate();

            return restTemplate.getForObject(uri, DispatchDTO.class);
        } catch (HttpStatusCodeException exception) {
            throw new ApiRequestException("cep não encontrado");
        }

    }

    public ResponseEntity findById(Long id) {
        var user = this.dispatchRepository.findById(id);

        if (user.isEmpty()) {
            throw new ApiRequestException("id não encontrado");
        }

        return new ResponseEntity<>(user.get(), HttpStatus.ACCEPTED);

    }
}
