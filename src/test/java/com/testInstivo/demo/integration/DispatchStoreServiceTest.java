package com.testInstivo.demo.integration;

import com.testInstivo.demo.repository.DispatchRepository;
import com.testInstivo.demo.service.dispatchService.DispatchStoreService;
import com.testInstivo.demo.utils.DispatchFactory;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@DisplayName("TEST INTEGRATION - DispatchStoreTest")
public class DispatchStoreServiceTest {

    @Autowired
    private DispatchStoreService dispatchStoreService;

    @Autowired
    private DispatchRepository dispatchRepository;


    @AfterEach
    void tearDown() {
        this.dispatchRepository.deleteAll();
    }


    @Test
    @DisplayName("should create dispatch")
    public final void shouldCreteDispatch() {
        var dispatchCreated = new DispatchFactory().create();

        ResponseEntity response = this.dispatchStoreService.store(dispatchCreated);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    @DisplayName("should fail in create dispatch with weight empty")
    public final void shouldFailInCreateDispatch() {
        try {
            var dispatchCreated = new DispatchFactory().createWithWeightEmpty();

            this.dispatchStoreService.store(dispatchCreated);
        } catch (RuntimeException e) {
            Assertions.assertTrue(e.getMessage().contains("null"));
        }
    }



    @Test
    @DisplayName("should fail in create dispatch with zip code origin empty")
    public final void shouldFailInCreateDispatchWithZipCodeOriginEmpty() {
        try {
            var dispatchCreated = new DispatchFactory().createWithZipCodeOriginEmpty();

            this.dispatchStoreService.store(dispatchCreated);
        } catch (RuntimeException e) {
            Assertions.assertEquals("cep não encontrado", e.getMessage());
        }
    }

    @Test
    @DisplayName("should fail in create dispatch with zip code destination empty")
    public final void shouldFailInCreateDispatchWithZipCodeDestinationEmpty() {
        try {
            var dispatchCreated = new DispatchFactory().createWithZipCodeDestination();

            this.dispatchStoreService.store(dispatchCreated);
        } catch (Exception e) {
            Assertions.assertEquals("cep não encontrado", e.getMessage());
        }
    }

    @Test
    @DisplayName("should fail in create dispatch with zip code destination empty")
    public final void shouldFailInCreateDispatchRecipientNameEmpty() {
        try {
            var dispatchCreated = new DispatchFactory().createWithRecipientNameEmpty();

            this.dispatchStoreService.store(dispatchCreated);
        } catch (Exception e) {
            Assertions.assertTrue(e.getMessage().contains("Error"));
        }
    }
}
