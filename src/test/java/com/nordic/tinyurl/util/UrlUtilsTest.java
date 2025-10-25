package com.nordic.tinyurl.util;

import com.nordic.tinyurl.exception.InvalidUrlException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UrlUtilsTest {
    @Test
    void normalize_shouldAddHttpSchemeWhenMissing() {
        String input = "example.com";
        String result = UrlUtils.normalizeUrl(input);
        assertEquals("http://example.com", result);
    }

    @Test
    void normalize_shouldRemoveTrailingSlash() {
        String input = "example.com/";
        String result = UrlUtils.normalizeUrl(input);
        assertEquals("http://example.com", result);
    }

    @Test
    void normalize_shouldThrowExceptionForInvalidUrl() {
        String input = "not-a%^valid%url";
        assertThrows(InvalidUrlException.class, () -> UrlUtils.normalizeUrl(input));
    }

    @Test
    void generateShortKey_shouldReturnCorrectLength() {
        String key = UrlUtils.generateShortKey(6);
        assertEquals(6, key.length());
    }

    @Test
    void generateShortKey_shouldGenerateDifferentKey() {
        String key1 = UrlUtils.generateShortKey(6);
        String key2 = UrlUtils.generateShortKey(6);

        assertNotEquals(key1, key2);
    }
}
