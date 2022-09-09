package com.testInstivo.demo.e2e;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testInstivo.demo.repository.DispatchRepository;
import com.testInstivo.demo.utils.DispatchFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("E2E - DispatchStoreController")
public class DispatchStoreControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DispatchRepository dispatchRepository;


    @AfterEach
    void tearDown() {
        this.dispatchRepository.deleteAll();
    }


    @Test
    @DisplayName("should create dispatch")
    public void shouldCreateDispatch() throws Exception {

        var dispatch = new DispatchFactory().create();

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/dispatch/store")
                .content(asJsonString(dispatch))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    @Test
    @DisplayName("should fail in create with weight empty")
    void shouldFailInCreateDispatchWithWeightEmpty() throws Exception {

        var dispatch = new DispatchFactory().createWithWeightEmpty();

         mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/dispatch/store")
                .content(asJsonString(dispatch))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());


    }

    @Test
    @DisplayName("should fail in create with recipient name empty")
    void shouldFailInCreateDispatchWithRecipientNameEmpty() throws Exception {

        var dispatch = new DispatchFactory().createWithRecipientNameEmpty();

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/dispatch/store")
                .content(asJsonString(dispatch))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("should fail in create with code destination empty")
    void shouldFailInCreateDispatchWithCodeDestinationEmpty() throws Exception {

        var dispatch = new DispatchFactory().createWithZipCodeDestination();

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/dispatch/store")
                .content(asJsonString(dispatch))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("should fail in create with code origin empty")
    void shouldFailInCreateDispatchWithCodeOriginEmpty() throws Exception {

        var dispatch = new DispatchFactory().createWithZipCodeOriginEmpty();

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/dispatch/store")
                .content(asJsonString(dispatch))
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
