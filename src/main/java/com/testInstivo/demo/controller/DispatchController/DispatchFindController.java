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
    DispatchFindService  dispatchFindService;

    @GetMapping(path = "find_by_id")
    public ResponseEntity findById(@RequestParam("id") Long id) {
        return this.dispatchFindService.findById(id);
    }
}
