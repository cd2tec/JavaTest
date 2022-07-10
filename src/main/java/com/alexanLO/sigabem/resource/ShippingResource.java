package com.sigabem.sigabem.resource;

import com.sigabem.sigabem.dto.ShippingDTO;
import com.sigabem.sigabem.entity.Shipping;
import com.sigabem.sigabem.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/sigabem")
public class ShippingResource {

    @Autowired
    private ShippingService shippingService;

    // GET
    @GetMapping(value = "/shippings")
    public ResponseEntity<List<ShippingDTO>> findAll() {
        List<Shipping> shippingList = shippingService.findAll();
        List<ShippingDTO> shippingDTOList = shippingList.stream().map(ShippingDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(shippingDTOList);
    }

    // GET BY ID
    @GetMapping(value = "/shipping/{id}")
    public ResponseEntity<ShippingDTO> findByID(@PathVariable Long id) {
        Shipping shipping = shippingService.findByID(id);
        ShippingDTO shippingDTO = new ShippingDTO(shipping);
        return ResponseEntity.ok().body(shippingDTO);
    }

    // POST
    @PostMapping(value = "/createshipping")
    public ResponseEntity<Void> create(@RequestBody ShippingDTO shippingDTO) {
        Shipping shipping = shippingService.fromDTO(shippingDTO);
        shipping = shippingService.create(shipping);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(shipping.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    // DELETE
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        shippingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // PUT
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Void> update(@RequestBody ShippingDTO shippingDTO, @PathVariable Long id) {
        Shipping shipping = shippingService.fromDTO(shippingDTO);
        shipping.setId(id);
        shipping = shippingService.update(shipping);
        return ResponseEntity.noContent().build();
    }

//     @GetMapping(value = "/calcshipping/{id}/{weight}/{zipOrigin}/{zipDestination}/{nameRecipient}")
//    public ResponseEntity<ShippingDTO> calcShipping(Long id, Double weight, Integer zipOrigin, Integer zipDestination, String nameRecipient){
//        //tem que ser implementado
//     }
}
