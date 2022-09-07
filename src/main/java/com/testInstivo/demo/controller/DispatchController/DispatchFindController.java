package com.testInstivo.demo.controller.DispatchController;

import com.testInstivo.demo.entites.Dispatch;
import com.testInstivo.demo.service.dispatchService.DispatchFindService;
import com.testInstivo.demo.service.dispatchService.DispatchStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/dispatch")
@CrossOrigin("*")
public class DispatchFindController {
    @Autowired
    private DispatchFindService  dispatchFindService;

    @GetMapping(path = "find_by_id")
    public ResponseEntity findById(@RequestParam("id") Long id) {
        return this.dispatchFindService.findById(id);
    }

    @GetMapping(path = "find_by_recipient_name")
    public ResponseEntity findByRecipientName(@RequestParam("name") String name) {
        return this.dispatchFindService.findByRecipientName(name);
    }

    @GetMapping(path = "find_by_weight")
    public ResponseEntity findByWeight(@RequestParam("weight") Double weight) {
      return this.dispatchFindService.findByWeight(weight);
    }

    @GetMapping(path = "zip_code_origin")
    public ResponseEntity findByZipCodeOrigin(@RequestParam("zip_code") String zip_code) {
        return this.dispatchFindService.findByZipCodeOrigin(zip_code);
    }

    @GetMapping(path = "zip_code_destination")
    public ResponseEntity findByZipCodeDestination(@RequestParam("zip_code") String zip_code) {
        return this.dispatchFindService.findByZipCodeDestination(zip_code);
    }

    @GetMapping(path = "total_freight")
    public ResponseEntity findByTotalFreight(@RequestParam("freight") int freight) {
        return this.dispatchFindService.findByFreight(freight);
    }


    @GetMapping(path = "expected_delivery_date")
    public ResponseEntity findByDeliveryDate(@RequestParam("date") String date) {
        return this.dispatchFindService.findByDeliveryDate(date);
    }

//    @GetMapping(path = "expected_delivery_date")
//    public ResponseEntity findByDeliveryDate(@RequestParam("date") String date) {
//        return this.dispatchFindService.findByDeliveryDate(date);
//    }
}

