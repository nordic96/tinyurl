package com.nordic.tinyurl.util;

import com.nordic.tinyurl.exception.InvalidUrlException;

import java.net.IDN;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

public final class UrlUtils {
    private UrlUtils() {}

    public static boolean isValidUrl(String rawUrl) {
        if (rawUrl == null || rawUrl.isBlank()) return false;
        try {
            String trimmed = rawUrl.trim();
            URI uri = new URI(trimmed);
            String scheme = uri.getScheme();
            return scheme != null && (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https"));
        } catch (URISyntaxException e) {
            return false;
        }
    }

    public static String normalizeUrl(String rawUrl) {
        if (rawUrl == null || rawUrl.isBlank()) {
            throw new InvalidUrlException("URL is not null");
        }
        String trimmed = rawUrl.trim();

        if (!trimmed.matches("^[a-zA-Z][a-zA-Z0-9+.-]*://.*")) {
            trimmed = "http://" + trimmed;
        }
        if (trimmed.endsWith("/")) {
            trimmed = trimmed.substring(0, trimmed.length() - 1);
        }

        if (!isValidUrl(trimmed)) {
            throw new InvalidUrlException("Invalid URL format: " + trimmed);
        }
        return trimmed;
    }

    public static String generateShortKey(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

}

