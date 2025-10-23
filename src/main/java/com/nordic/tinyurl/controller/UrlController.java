package com.nordic.tinyurl.controller;

import com.nordic.tinyurl.dto.ShortenUrlRequest;
import com.nordic.tinyurl.dto.ShortenUrlResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/url")
public class UrlController {
    private static final Logger logger = LoggerFactory.getLogger(UrlController.class);

    @PostMapping("/shorten")
    public ResponseEntity<ShortenUrlResponse> getShortenedUrl(@RequestBody ShortenUrlRequest request) {
        if (request.getOriginalUrl() == null || request.getOriginalUrl().isBlank()) {
            throw new IllegalArgumentException("Original URL must not be empty");
        }
        String originalUrl = request.getOriginalUrl();

        String fakeShortenedUrl = "https://short.ly/12345abc";
        ShortenUrlResponse response;
        response = new ShortenUrlResponse(originalUrl, fakeShortenedUrl, "success");

        logger.info("Successful URL Shortening: " + response.getShortenedUrl());
        return ResponseEntity.ok(response);
    }
}
