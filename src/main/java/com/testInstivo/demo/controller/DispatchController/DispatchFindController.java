package com.testInstivo.demo.controller.DispatchController;

import com.testInstivo.demo.entites.Dispatch;
import com.testInstivo.demo.service.dispatchService.DispatchFindService;
import com.testInstivo.demo.service.dispatchService.DispatchStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/dispatch")
@CrossOrigin("*")
@Api(value="API DISPATCH FIND")
public class DispatchFindController {
    @Autowired
    private DispatchFindService  dispatchFindService;

    @ApiOperation(value="should find by id")
    @GetMapping(path = "find_by_id")
    public ResponseEntity findById(@RequestParam("id") Long id) {
        return this.dispatchFindService.findById(id);
    }

    @ApiOperation(value="should find by recipient name")
    @GetMapping(path = "find_by_recipient_name")
    public ResponseEntity findByRecipientName(@RequestParam("name") String name) {
        return this.dispatchFindService.findByRecipientName(name);
    }

    @ApiOperation(value="should find by weight")
    @GetMapping(path = "find_by_weight")
    public ResponseEntity findByWeight(@RequestParam("weight") Double weight) {
      return this.dispatchFindService.findByWeight(weight);
    }

    @ApiOperation(value="should find by zip code origin")
    @GetMapping(path = "zip_code_origin")
    public ResponseEntity findByZipCodeOrigin(@RequestParam("zip_code") String zip_code) {
        return this.dispatchFindService.findByZipCodeOrigin(zip_code);
    }

    @ApiOperation(value="should find by zip code destination")
    @GetMapping(path = "zip_code_destination")
    public ResponseEntity findByZipCodeDestination(@RequestParam("zip_code") String zip_code) {
        return this.dispatchFindService.findByZipCodeDestination(zip_code);
    }

    @ApiOperation(value="should find by total freight")
    @GetMapping(path = "total_freight")
    public ResponseEntity findByTotalFreight(@RequestParam("freight") int freight) {
        return this.dispatchFindService.findByFreight(freight);
    }

    @ApiOperation(value="should find by delivery date")
    @GetMapping(path = "expected_delivery_date")
    public ResponseEntity findByDeliveryDate(@RequestParam("date") String date) {
        return this.dispatchFindService.findByDeliveryDate(date);
    }


}

