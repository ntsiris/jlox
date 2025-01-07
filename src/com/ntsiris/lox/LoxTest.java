package com.ntsiris.lox;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoxTest {

    @Test
    void testErrorReporting() {
        Lox.error(1, "Unexpected character.");
        assertTrue(Lox.hadError);

        // Reset the error state
        Lox.hadError = false;
        assertFalse(Lox.hadError);
    }
}
