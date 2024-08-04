package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SmartHomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSetTargetTemperature() throws Exception {
        mockMvc.perform(post("/api/smart-home/temperature")
                .param("temperature", "22.0"))
                .andExpect(status().isOk());
    }

    @Test
    public void testControlLighting() throws Exception {
        mockMvc.perform(post("/api/smart-home/lighting")
                .param("turnOn", "true"))
                .andExpect(status().isOk());
    }

    @Test
    public void testControlGate() throws Exception {
        mockMvc.perform(post("/api/smart-home/gate")
                .param("open", "true"))
                .andExpect(status().isOk());
    }

    @Test
    public void testControlSurveillance() throws Exception {
        mockMvc.perform(post("/api/smart-home/surveillance")
                .param("activate", "true"))
                .andExpect(status().isOk());
    }
}