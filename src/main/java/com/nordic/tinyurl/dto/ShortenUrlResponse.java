package com.nordic.tinyurl.dto;

public class ShortenUrlResponse {
    private String originalUrl;
    private String shortenedUrl;
    private String status;

    public ShortenUrlResponse(String originalUrl, String shortenedUrl, String status) {
        this.originalUrl = originalUrl;
        this.shortenedUrl = shortenedUrl;
        this.status = status;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public void setShortenedUrl(String shortenedUrl) {
        this.shortenedUrl = shortenedUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
