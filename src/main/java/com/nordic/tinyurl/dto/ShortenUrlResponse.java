package com.nordic.tinyurl.dto;

public class ShortenUrlResponse {
    private String originalUrl;
    private String shortenedUrl;
    private String normalizedUrl;
    private String status;

    public ShortenUrlResponse(String originalUrl, String shortenedUrl, String normalizedUrl, String status) {
        this.originalUrl = originalUrl;
        this.shortenedUrl = shortenedUrl;
        this.normalizedUrl = normalizedUrl;
        this.status = status;
    }

    public String getNormalizedUrl() {
        return normalizedUrl;
    }

    public void setNormalizedUrl(String normalizedUrl) {
        this.normalizedUrl = normalizedUrl;
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
