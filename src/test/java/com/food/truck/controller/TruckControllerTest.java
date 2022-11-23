package com.food.truck.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TruckControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnAllTrucks() throws Exception {
        this.mockMvc.perform(get("/trucks/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnTrucksById() throws Exception {
        this.mockMvc.perform(get("/trucks/objectid?id=735318"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnTrucksByStatus() throws Exception {
        this.mockMvc.perform(get("/trucks/status?status=REQUESTED"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnTrucksByApplicant() throws Exception {
        this.mockMvc.perform(get("/trucks/applicant?applicant=Ziaurehman+Amini"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnTrucksByType() throws Exception {
        this.mockMvc.perform(get("/trucks/type?type=Truck"))
                .andExpect(status().isOk());
    }
}
