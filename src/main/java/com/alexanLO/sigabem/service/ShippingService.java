package com.sigabem.sigabem.service;

import com.sigabem.sigabem.dto.ShippingDTO;
import com.sigabem.sigabem.entity.Shipping;
import com.sigabem.sigabem.exception.ObjectNotFoundException;
import com.sigabem.sigabem.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;


    // GET
    public List<Shipping> findAll() {
        return shippingRepository.findAll();
    }

    // GET BY ID
    public Shipping findByID(Long id) {
        return shippingRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Id não encontrado!"));
    }

    // POST
    public Shipping create(Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    // DELETE
    public void delete(Long id){
        findByID(id);
        shippingRepository.deleteById(id);
    }

    // PUT
    public Shipping update(Shipping shipping){
        Shipping newShipping = shippingRepository.findById(shipping.getId()).orElseThrow(() -> new ObjectNotFoundException("Id não encontrado!"));
        updateData(newShipping, shipping);
        return shippingRepository.save(newShipping);
    }

    private void updateData(Shipping newShipping, Shipping shipping) {
        newShipping.setDestinationZipCode(shipping.getDestinationZipCode());
        newShipping.setOriginZipCode(shipping.getOriginZipCode());
        newShipping.setProductWeight(shipping.getProductWeight());
        newShipping.setRecipientName(shipping.getRecipientName());
    }

    // convert ShippingDTO em Shipping, a escolha em por essa function no ShippingService e não no ShippingDTO é porque
    // o ShippingService já tem a conexão com o banco de dados caso precise ultiliza-lo.
    public Shipping fromDTO(ShippingDTO shippingDTO) {
        return new Shipping(shippingDTO.getId(), shippingDTO.getProductWeight(), shippingDTO.getOriginZipCode(), shippingDTO.getDestinationZipCode(), shippingDTO.getRecipientName(), new Date());
    }

//    public Shipping calcShipping(Long id, Double weight, Integer zipOrigin, Integer zipDestination, String nameRecipient){
//
//        updateData();
//        // O valor do frete é cobrado pelo peso da encomenda, o valor para cada KG é R$1,00
//        Double feeByWeight = weight * 1.00;
//        Double discount;
//
//        /*Fiz a implementação do https://github.com/ThallesT/via-cep no maven, porem não consegui encontra a Class Cep
//        * continuarei a implementar o codigo e por ultimo tento resolver isso, caso eu não consiga criarei a lógica que acredito ser correta mesmo não conseguidno testar*/
//        Cep cepOrigin = ViaCepClient.findCep(zipOrigin);
//        Cep cepDestination = ViaCepClient.findCep(ZipDestination);
//
//        if (cepOrigin.getDDD == cepDestination.getDDD){
//        // CEPs com DDDs iguais tem 50% de desconto no valor do frete e entrega prevista de 1 dia
//            discount = (feeByWeight*100)/feeByWeight;
//            System.out.print("Valor do frete:" + discount + " Data prevista de entrega 1 dia util");
//        }
//        if(cepOrigin.getUf == cepDestination.getUf && cepOrigin.getDDD != cepDestination.getDDD){
//        // CEPs de estados iguais tem 75% de desconto no valor do frete e entrega prevista de 3 dias
//            discount = (feeByWeight*100)/feeByWeight;
//            System.out.print("Valor do frete:" + discount + " Data prevista de entrega 3 dias util");
//        }
//        if(cepOrigin.getUf != cepDestination.getUf){
//        // CEPs de estados diferentes não deve ser aplicado o desconto no valor do frete e entrega prevista de 10 dias
//            discount = feeByWeight;
//            System.out.print("Valor do frete:" + discount + " Data prevista de entrega 10 dias util");
//        }
//        Shipping newShipping = shippingRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Id não encontrado!"));
//        newShipping.updateInformation(id, weight, zipOrigin, zipDestination, nameRecipient);
//        return newShipping;
//    }


}
