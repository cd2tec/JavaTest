package com.testInstivo.demo.controller.DispatchController;

import com.testInstivo.demo.entites.Dispatch;
import com.testInstivo.demo.service.dispatchService.DispatchStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/dispatch")
@CrossOrigin("*")
public class DispatchStoreController {

    @Autowired
    DispatchStoreService dispatchStoreService;

    @PostMapping(path = "store")
    public ResponseEntity Store(@RequestBody Dispatch request) {
        return this.dispatchStoreService.store(request);
    }
}
