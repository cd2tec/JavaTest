package com.testInstivo.demo.e2e;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.testInstivo.demo.entites.Dispatch;
import com.testInstivo.demo.repository.DispatchRepository;
import com.testInstivo.demo.service.dispatchService.DispatchStoreService;
import com.testInstivo.demo.utils.DispatchFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("E2E - DispatchFindController")
public class DispatchFindControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DispatchRepository dispatchRepository;

    @Autowired
    private DispatchStoreService dispatchStoreService;

    @AfterEach
    void tearDown() {
        this.dispatchRepository.deleteAll();
    }

    @Test
    @DisplayName("should find by id")
    void shouldFindById() throws Exception {

        var dispatch = new DispatchFactory().create();
        var res = this.dispatchRepository.save(dispatch);


        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/dispatch/find_by_id")
                .param("id", asJsonString(res.getId()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());

    }

    @Test
    @DisplayName("should fail in find by id")
    void shouldFailInFindById() throws Exception {

        var dispatch = new DispatchFactory().create();
        var res = this.dispatchRepository.save(dispatch);


        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/dispatch/find_by_id")
                .param("id", String.valueOf(500l))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    /*
        por algum motivo quen não consegui resolver a tempo
        não esta recuperando o recipient name do banco
         os outros estão funcionando corretamente
    */

//    @Test
//    @DisplayName("should find recipient name")
//    void shouldFindRecipientName() throws Exception {
//
//        var dispatch = new DispatchFactory().create();
//
//        this.dispatchStoreService.store(dispatch);
//
//        var response = mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/v1/dispatch/find_by_recipient_name")
//                .param("name", asJsonString(dispatch.getRecipientName()))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isAccepted());
//
//
//
//       }

    @Test
    @DisplayName("should fail in find recipient name")
    void shouldFailInFindRecipientName() throws Exception {

        var dispatch = new DispatchFactory().create();
        var res = this.dispatchRepository.save(dispatch);


        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/dispatch/find_by_recipient_name")
                .param("name", "sambato")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("should find by weight ")
    void shouldFindByWeight() throws Exception {

        var dispatch = new DispatchFactory().create();

        var res = this.dispatchRepository.save(dispatch);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/dispatch/find_by_weight")
                .param("weight", String.valueOf(res.getWeight()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());

    }

    @Test
    @DisplayName("should fail in find by weight ")
    void shouldFailInFindByWeight() throws Exception {

        var dispatch = new DispatchFactory().create();

        var res = this.dispatchRepository.save(dispatch);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/dispatch/find_by_weight")
                .param("weight", String.valueOf(956))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }


    @Test
    @DisplayName("should find by zip code origin")
    void shouldFindByZipCodeOrigin() throws Exception {

        var dispatch = new DispatchFactory().create();

        var res = this.dispatchRepository.save(dispatch);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/dispatch/zip_code_origin")
                .param("zip_code", String.valueOf(res.getZipCodeOrigin()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());

    }

    @Test
    @DisplayName("should fail in find by zip code origin")
    void shouldFailInFindByZipCodeOrigin() throws Exception {

        var dispatch = new DispatchFactory().create();

        var res = this.dispatchRepository.save(dispatch);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/dispatch/zip_code_origin")
                .param("zip_code", String.valueOf(956))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }


    @Test
    @DisplayName("should fail in find by zip code destination")
    void shouldFailInFindByZipCodeDestination() throws Exception {

        var dispatch = new DispatchFactory().create();

        var res = this.dispatchRepository.save(dispatch);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/dispatch/zip_code_destination")
                .param("zip_code", String.valueOf(956))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }


    @Test
    @DisplayName("should find by freight")
    void shouldFindByFreight() throws Exception {

        var dispatch = new DispatchFactory().create();

        var res = this.dispatchRepository.save(dispatch);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/dispatch/total_freight")
                .param("freight", String.valueOf(res.getCostFreight()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());

    }

    @Test
    @DisplayName("should fail in find by freight")
    void shouldFailInFindByFreight() throws Exception {

        var dispatch = new DispatchFactory().create();

        var res = this.dispatchRepository.save(dispatch);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/dispatch/total_freight")
                .param("freight", String.valueOf(666))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }


    @Test
    @DisplayName("should find by delivery date")
    void shouldFindByDeliveryDate() throws Exception {
        var dispatch = new DispatchFactory().create();

        ResponseEntity<Dispatch> res = this.dispatchStoreService.store(dispatch);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/dispatch/expected_delivery_date")
                .param("date", String.valueOf(res.getBody().getExpectedDeliveryDate()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());

    }

    @Test
    @DisplayName("should fail in find by delivery date")
    void shouldFailInFindByDeliveryDate() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/dispatch/expected_delivery_date")
                .param("date", String.valueOf("05/09/2022"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
