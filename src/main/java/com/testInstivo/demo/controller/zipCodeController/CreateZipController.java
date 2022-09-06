package com.testInstivo.demo.controller.zipCodeController;

import com.testInstivo.demo.entites.ZipCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/zip_code")
@CrossOrigin("*")
public class CreateZipController {

    @PostMapping(path = "create")
    public ZipCode Create(@RequestBody ZipCode request) {
        return request;
    }
}
