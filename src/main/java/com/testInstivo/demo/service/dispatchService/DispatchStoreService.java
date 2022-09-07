package com.testInstivo.demo.service.dispatchService;

import com.testInstivo.demo.entites.Dispatch;
import com.testInstivo.demo.repository.DispatchRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DispatchStoreService {
    final DispatchRepository dispatchRepository;
    final DispatchFindService dispatchFindService;
    final DispatchDiscountService dispatchDiscountService;

    public ResponseEntity store(Dispatch request) {
        try {
            var dispatchSender = this.dispatchFindService.findViaCep(request.getZipCodeOrigin());

            var dispatchDestiny = this.dispatchFindService.findViaCep(request.getZipCodeDestination());

            var responseDispatch = this.dispatchDiscountService.discount(request, dispatchSender, dispatchDestiny);

            var dispatchCreated = this.dispatchRepository.save(responseDispatch);
            return new ResponseEntity(dispatchCreated, HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            throw new IllegalStateException(e.getMessage());
        }

    }


}
