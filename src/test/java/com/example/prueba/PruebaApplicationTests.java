package com.example.prueba;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")  // Activa el perfil de "test" si tienes una configuración específica
public class PruebaApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetPriceAt10AMOn14thJune() throws Exception {

                mockMvc.perform(get("/api/prices/prices")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-14T10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].price").value(35.5));
    }
    @Test
    public void testGetPriceAt4PMOn14thJune() throws Exception {
        mockMvc.perform(get("/api/prices/prices")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-14T16:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].price").value(25.45));
    }

    @Test
    public void testGetPriceAt9PMOn14thJune() throws Exception {
        mockMvc.perform(get("/api/prices/prices")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-14T21:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].price").value(35.50));
    }

    @Test
    public void testGetPriceAt10AMOn15thJune() throws Exception {
        mockMvc.perform(get("/api/prices/prices")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-15T10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].price").value(30.50));
    }

    @Test
    public void testGetPriceAt9PMOn16thJune() throws Exception {
        mockMvc.perform(get("/api/prices/prices")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-16T21:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].price").value(38.95));
    }
}
