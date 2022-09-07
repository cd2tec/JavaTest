package com.testInstivo.demo.controller.DispatchController;

import com.testInstivo.demo.entites.Dispatch;
import com.testInstivo.demo.service.dispatchService.DispatchStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/dispatch")
@CrossOrigin("*")
public class DispatchStoreController {

    @Autowired
    DispatchStoreService dispatchStoreService;

    @PostMapping(path = "store")
    public ResponseEntity Store(@Valid @RequestBody Dispatch request) {
        return this.dispatchStoreService.store(request);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
