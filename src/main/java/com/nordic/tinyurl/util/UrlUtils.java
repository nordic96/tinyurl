package com.nordic.tinyurl.util;

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
}
