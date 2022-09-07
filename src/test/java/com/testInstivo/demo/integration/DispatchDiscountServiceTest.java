package com.testInstivo.demo.integration;

import com.testInstivo.demo.repository.DispatchRepository;
import com.testInstivo.demo.service.dispatchService.DispatchDiscountService;
import com.testInstivo.demo.service.dispatchService.DispatchFindService;
import com.testInstivo.demo.service.dispatchService.DispatchStoreService;
import com.testInstivo.demo.utils.DispatchFactory;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
@DisplayName("TEST INTEGRATION - DispatchDiscountServiceTest")
public class DispatchDiscountServiceTest {

    @Autowired
    private DispatchStoreService dispatchStoreService;

    @Autowired
    private DispatchFindService dispatchFindService;


    @Autowired
    private DispatchDiscountService dispatchDiscountService;


    @Autowired
    private DispatchRepository dispatchRepository;


    @AfterEach
    void tearDown() {
        this.dispatchRepository.deleteAll();
    }

    @Test
    @DisplayName("should create with discount ddd")
    public final void shouldCreateWithDiscountDDD() {
        var dispatchCreated = new DispatchFactory().createWithSameDDD();

        var dispatchSender = this.dispatchFindService.findViaCep(dispatchCreated.getZipCodeOrigin());
        var dispatchDestiny = this.dispatchFindService.findViaCep(dispatchCreated.getZipCodeDestination());

        var res = this.dispatchDiscountService.discount(dispatchCreated, dispatchSender, dispatchDestiny);

        var someWithDiscount = dispatchCreated.getWeight() / 2;

        Assertions.assertEquals(res.getCostFreight(), someWithDiscount);

    }

    @Test
    @DisplayName("should create with discount location")
    public final void shouldCreateWithDiscountLocation() {
        var dispatchCreated = new DispatchFactory().createWithSameLocation();

        var dispatchSender = this.dispatchFindService.findViaCep(dispatchCreated.getZipCodeOrigin());
        var dispatchDestiny = this.dispatchFindService.findViaCep(dispatchCreated.getZipCodeDestination());

        var response = this.dispatchDiscountService.discount(dispatchCreated, dispatchSender, dispatchDestiny);

        var someWithDiscount = Math.toIntExact(Math.round(response.getWeight() / 4));

        Assertions.assertEquals(someWithDiscount, response.getCostFreight());

    }

    @Test
    @DisplayName("should create with no discount")
    public final void shouldCreateWithNoDiscount() {
        var dispatchCreated = new DispatchFactory().createWithDiferentLocation();

        var dispatchSender = this.dispatchFindService.findViaCep(dispatchCreated.getZipCodeOrigin());
        var dispatchDestiny = this.dispatchFindService.findViaCep(dispatchCreated.getZipCodeDestination());

        var response = this.dispatchDiscountService.discount(dispatchCreated, dispatchSender, dispatchDestiny);

        var someWithDiscount =  0;

        Assertions.assertEquals(someWithDiscount, response.getCostFreight());

    }

}
