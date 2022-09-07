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
    private DispatchRepository dispatchRepository;

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

    public ResponseEntity findByRecipientName(String name) {
        var user = this.dispatchRepository.findByRecipientName(name);

        if(user.isEmpty()) {
            throw new ApiRequestException("Nenhum item registrado com esse nome foi encontrado");
        }

        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    public ResponseEntity findByWeight(Double weight) {
        var listWeight = this.dispatchRepository.findByWeight(weight);

        if(listWeight.isEmpty()) {
            throw new ApiRequestException("Nenhum item foi encontrado com esse peso " + weight);
        }

        return new ResponseEntity<>(listWeight, HttpStatus.ACCEPTED);
    }

    public ResponseEntity findByZipCodeOrigin(String zip_code) {
        var list = this.dispatchRepository.findByZipCodeOrigin(zip_code);

        if(list.isEmpty()) {
            throw new ApiRequestException("Nenhum item foi encontrado com esse cep " + zip_code);
        }

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    public ResponseEntity findByZipCodeDestination(String zip_code) {
        var list = this.dispatchRepository.findByZipCodeDestination(zip_code);

        if(list.isEmpty()) {
            throw new ApiRequestException("Nenhum item foi encontrado com esse cep " + zip_code);
        }

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    public ResponseEntity findByFreight(int weight) {
        var list = this.dispatchRepository.findByCostFreight(weight);

        if(list.isEmpty()) {
            throw new ApiRequestException("Nenhum item com esse frete: " + weight+ " foi encontrado");
        }

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    public ResponseEntity findByDeliveryDate(String date) {

        var list = this.dispatchRepository.findByExpectedDeliveryDate(date);

        if(list.isEmpty()) {
            throw new ApiRequestException("Nenhum item foi encontrado nessa data: " + date);
        }

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }



}
