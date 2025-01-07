package com.ntsiris.lox;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TokenTest {

    @Test
    void testToString() {
        Token token = new Token(TokenType.IDENTIFIER, "x", null, 1);
        assertEquals("IDENTIFIER x null", token.toString());
    }

    @Test
    void testNumberToken() {
        Token token = new Token(TokenType.NUMBER, "42", 42.0, 1);
        assertEquals("NUMBER 42 42.0", token.toString());
    }
}
