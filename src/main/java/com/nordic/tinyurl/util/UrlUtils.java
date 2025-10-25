package com.nordic.tinyurl.util;

import com.nordic.tinyurl.exception.InvalidUrlException;

import java.net.IDN;
import java.net.URI;
import java.util.Locale;

public final class UrlUtils {
    private UrlUtils() {}

    public static boolean isValidUrl(String rawUrl) {
        try {
            if (rawUrl == null || rawUrl.isBlank()) return false;

            String trimmed = rawUrl.trim();
            URI uri = new URI(trimmed);
            String scheme = uri.getScheme();
            String host = uri.getHost();

            if (host == null && uri.getAuthority() != null) {
                host = uri.getAuthority().split(":")[0];
            }

            if (scheme == null) return false;
            scheme = scheme.toLowerCase(Locale.ROOT);
            if (!("http".equals(scheme) || "https".equals(scheme))) return false;
            if (host == null || host.isBlank()) return false;

            IDN.toASCII(host);
            return true;
        } catch (Exception e) {
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

