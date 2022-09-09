package com.testInstivo.demo.integration;

import com.testInstivo.demo.entites.Dispatch;
import com.testInstivo.demo.repository.DispatchRepository;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@DisplayName("TEST INTEGRATION - DispatchFindTest")
public class DispatchFindServiceTest {


    @Autowired
    private DispatchStoreService dispatchStoreService;

    @Autowired
    private DispatchFindService dispatchFindService;

    @Autowired
    private DispatchRepository dispatchRepository;


    @AfterEach
    void tearDown() {
        this.dispatchRepository.deleteAll();
    }


    @Test
    @DisplayName("should find viaCep zip code origin")
    public final void shouldFindViaCepZipCodeOrigin() {
        var dispatchCreated = new DispatchFactory().create();

        var response = this.dispatchFindService.findViaCep(dispatchCreated.getZipCodeOrigin());
        Assertions.assertFalse(response.getCep().isEmpty());
    }


    @Test
    @DisplayName("should fail in find viaCep zip code origin")
    public final void shouldFailInFindViaCepZipCodeOrigin() {
        try {

            this.dispatchFindService.findViaCep("818803705");
        } catch (RuntimeException e) {
            Assertions.assertEquals("cep não encontrado", e.getMessage());
        }
    }


    @Test
    @DisplayName("should find by id")
    public final void shouldFindById() {
        var dispatchFactory = new DispatchFactory().create();

        ResponseEntity<Dispatch> dispatchCreated = this.dispatchStoreService.store(dispatchFactory);

        ResponseEntity<Dispatch> find = this.dispatchFindService.findById(dispatchCreated.getBody().getId());

        Assertions.assertEquals(find.getBody().getId(), dispatchCreated.getBody().getId());
    }


    @Test
    @DisplayName("should fail find by id")
    public final void shouldFailInFindById() {
        try {
            ResponseEntity<Dispatch> find = this.dispatchFindService.findById(100l);
        } catch (RuntimeException e) {
            Assertions.assertEquals("id não encontrado", e.getMessage());
        }
    }


    @Test
    @DisplayName("should find by recipient name")
    public final void shouldFindByRecipientnName() {
        var dispatchFactory = new DispatchFactory().create();

        ResponseEntity<Dispatch> dispatchCreated = this.dispatchStoreService.store(dispatchFactory);

        ResponseEntity<Dispatch> find = this.dispatchFindService.findByRecipientName(dispatchCreated.getBody().getRecipientName());
        Assertions.assertEquals(HttpStatus.ACCEPTED, find.getStatusCode());

    }

    @Test
    @DisplayName("should fail find by recipient name")
    public final void shouldFailInFindByRecipientName() {
        try {
            ResponseEntity<Dispatch> find = this.dispatchFindService.findByRecipientName("Simpato Amasaki");
        } catch (RuntimeException e) {
            Assertions.assertEquals("Nenhum item registrado com esse nome foi encontrado: Simpato Amasaki", e.getMessage());
        }
    }

    @Test
    @DisplayName("should find by weight")
    public final void shouldFindByWeight() {
        var dispatchFactory = new DispatchFactory().create();

        ResponseEntity<Dispatch> dispatchCreated = this.dispatchStoreService.store(dispatchFactory);

        ResponseEntity<Dispatch> find = this.dispatchFindService.findByWeight(dispatchCreated.getBody().getWeight());
        Assertions.assertEquals(HttpStatus.ACCEPTED, find.getStatusCode());

    }

    @Test
    @DisplayName("should fail find by weight")
    public final void shouldFailInWeight() {
        try {
            ResponseEntity<Dispatch> find = this.dispatchFindService.findByWeight(200.0);
        } catch (RuntimeException e) {
            Assertions.assertEquals("Nenhum item foi encontrado com esse peso " + 200.0, e.getMessage());
        }
    }

    @Test
    @DisplayName("should find by zip code origin")
    public final void shouldFindByZipCodeOrigin() {
        var dispatchFactory = new DispatchFactory().create();

        ResponseEntity<Dispatch> dispatchCreated = this.dispatchStoreService.store(dispatchFactory);

        ResponseEntity<Dispatch> find = this.dispatchFindService.findByZipCodeOrigin(dispatchCreated.getBody().getZipCodeOrigin());
        Assertions.assertEquals(HttpStatus.ACCEPTED, find.getStatusCode());

    }

    @Test
    @DisplayName("should fail find by zip code origin")
    public final void shouldFailInFindByZipCodeOrigin() {
        try {
            ResponseEntity<Dispatch> find = this.dispatchFindService.findByZipCodeOrigin("818803704");
        } catch (RuntimeException e) {
            Assertions.assertEquals("Nenhum item foi encontrado com esse cep " + "818803704", e.getMessage());
        }
    }

    @Test
    @DisplayName("should find by zip code destination")
    public final void shouldFindByZipCodeDestination() {
        var dispatchFactory = new DispatchFactory().create();

        ResponseEntity<Dispatch> dispatchCreated = this.dispatchStoreService.store(dispatchFactory);

        ResponseEntity<Dispatch> find = this.dispatchFindService.findByZipCodeDestination(dispatchCreated.getBody().getZipCodeDestination());
        Assertions.assertEquals(HttpStatus.ACCEPTED, find.getStatusCode());

    }

    @Test
    @DisplayName("should fail find by zip code destination")
    public final void shouldFailInFindByZipCodeDestination() {
        try {
            ResponseEntity<Dispatch> find = this.dispatchFindService.findByZipCodeDestination("818803704");
        } catch (RuntimeException e) {
            Assertions.assertEquals("Nenhum item foi encontrado com esse cep " + "818803704", e.getMessage());
        }
    }

    @Test
    @DisplayName("should find by freight")
    public final void shouldFindByFreight() {
        var dispatchFactory = new DispatchFactory().create();

        ResponseEntity<Dispatch> dispatchCreated = this.dispatchStoreService.store(dispatchFactory);

        ResponseEntity<Dispatch> find = this.dispatchFindService.findByFreight(dispatchCreated.getBody().getCostFreight());
        Assertions.assertEquals(HttpStatus.ACCEPTED, find.getStatusCode());

    }

    @Test
    @DisplayName("should fail find by freight")
    public final void shouldFailInFindByFreight() {
        try {
            ResponseEntity<Dispatch> find = this.dispatchFindService.findByFreight(65165165);
        } catch (RuntimeException e) {
            Assertions.assertEquals("Nenhum item com esse frete: " + 65165165 + " foi encontrado", e.getMessage());
        }
    }

    @Test
    @DisplayName("should find by freight")
    public final void shouldFindByExpectedDeliveryDate() {
        var dispatchFactory = new DispatchFactory().create();

        ResponseEntity<Dispatch> dispatchCreated = this.dispatchStoreService.store(dispatchFactory);

        ResponseEntity<Dispatch> find = this.dispatchFindService.findByDeliveryDate(dispatchCreated.getBody().getExpectedDeliveryDate());
        Assertions.assertEquals(HttpStatus.ACCEPTED, find.getStatusCode());

    }


    @Test
    @DisplayName("should fail in find delivery date")
    public final void shouldFailInFindByExpectedDeliveryDate() {
        try {
            ResponseEntity<Dispatch> find = this.dispatchFindService.findByDeliveryDate("10/10/2010");
        } catch (RuntimeException e) {
            Assertions.assertEquals("Nenhum item foi encontrado nessa data: 10/10/2010", e.getMessage());
        }
    }


}
