package com.testInstivo.demo.controller.zipCodeController;

import com.testInstivo.demo.entites.Dispatch;
import com.testInstivo.demo.service.zipCodeService.DispatchCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/dispatch")
@CrossOrigin("*")
public class DispatchCreateController {

    @Autowired
    DispatchCreateService dispatchCreateService;

    @PostMapping(path = "create")
    public ResponseEntity Create(@RequestBody Dispatch request) {
        return this.dispatchCreateService.create(request);
    }
}
