package com.nordic.tinyurl.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nordic.tinyurl.dto.ShortenUrlRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UrlController.class)
public class UrlControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shortenUrl_shouldReturnSuccessResponse() throws Exception {
        ShortenUrlRequest request = new ShortenUrlRequest("https://example.com");
        mockMvc.perform(post("/api/url/shorten")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("success"))
                .andExpect(jsonPath("$.shortenedUrl").exists());
    }

    @Test
    void shortenUrl_shouldReturnErrorWhenUrlMissing() throws Exception {
        ShortenUrlRequest request = new ShortenUrlRequest("");
        mockMvc.perform(post("/api/url/shorten")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
}
