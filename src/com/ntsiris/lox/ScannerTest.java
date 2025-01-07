package com.ntsiris.lox;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScannerTest {

    @Test
    void testSingleCharacterTokens() {
        String source = "(){}";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        assertEquals(5, tokens.size());
        assertEquals(TokenType.LEFT_PAREN, tokens.get(0).type);
        assertEquals(TokenType.RIGHT_PAREN, tokens.get(1).type);
        assertEquals(TokenType.LEFT_BRACE, tokens.get(2).type);
        assertEquals(TokenType.RIGHT_BRACE, tokens.get(3).type);
        assertEquals(TokenType.EOF, tokens.get(4).type);
    }

    @Test
    void testKeywordsAndIdentifiers() {
        String source = "var x = 42; print x;";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        assertEquals(TokenType.VAR, tokens.get(0).type);
        assertEquals(TokenType.IDENTIFIER, tokens.get(1).type);
        assertEquals(TokenType.EQUAL, tokens.get(2).type);
        assertEquals(TokenType.NUMBER, tokens.get(3).type);
        assertEquals(TokenType.SEMICOLON, tokens.get(4).type);
        assertEquals(TokenType.PRINT, tokens.get(5).type);
        assertEquals(TokenType.IDENTIFIER, tokens.get(6).type);
        assertEquals(TokenType.SEMICOLON, tokens.get(7).type);
        assertEquals(TokenType.EOF, tokens.get(8).type);
    }

    @Test
    void testStrings() {
        String source = "\"hello world\"";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        assertEquals(TokenType.STRING, tokens.get(0).type);
        assertEquals("hello world", tokens.get(0).literal);
        assertEquals(TokenType.EOF, tokens.get(1).type);
    }

    @Test
    void testUnterminatedString() {
        String source = "\"hello world";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        assertEquals(1, tokens.size()); // Only EOF should be added
        assertEquals(TokenType.EOF, tokens.get(0).type);
    }

    @Test
    void testComments() {
        String source = "// This is a comment\nvar x = 42;";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        assertEquals(TokenType.VAR, tokens.get(0).type);
        assertEquals(TokenType.IDENTIFIER, tokens.get(1).type);
        assertEquals(TokenType.EQUAL, tokens.get(2).type);
        assertEquals(TokenType.NUMBER, tokens.get(3).type);
        assertEquals(TokenType.SEMICOLON, tokens.get(4).type);
        assertEquals(TokenType.EOF, tokens.get(5).type);
    }

    @Test
    void testMultilineComment() {
        String source = "var x = 42; /* this is a multiline comment */ print x;";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        // Check the tokens before and after the multiline comment
        assertEquals(TokenType.VAR, tokens.get(0).type);          // 'var'
        assertEquals(TokenType.IDENTIFIER, tokens.get(1).type);   // 'x'
        assertEquals(TokenType.EQUAL, tokens.get(2).type);        // '='
        assertEquals(TokenType.NUMBER, tokens.get(3).type);       // '42'
        assertEquals(TokenType.SEMICOLON, tokens.get(4).type);    // ';'
        assertEquals(TokenType.PRINT, tokens.get(5).type);        // 'print'
        assertEquals(TokenType.IDENTIFIER, tokens.get(6).type);   // 'x'
        assertEquals(TokenType.SEMICOLON, tokens.get(7).type);    // ';'
        assertEquals(TokenType.EOF, tokens.get(8).type);          // End of file
    }

    @Test
    void testMultilineCommentAcrossLines() {
        String source = "var x = 42; /* multiline \n comment \n over \n multiple lines */ print x;";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        // Check the tokens before and after the multiline comment
        assertEquals(TokenType.VAR, tokens.get(0).type);          // 'var'
        assertEquals(TokenType.IDENTIFIER, tokens.get(1).type);   // 'x'
        assertEquals(TokenType.EQUAL, tokens.get(2).type);        // '='
        assertEquals(TokenType.NUMBER, tokens.get(3).type);       // '42'
        assertEquals(TokenType.SEMICOLON, tokens.get(4).type);    // ';'
        assertEquals(TokenType.PRINT, tokens.get(5).type);        // 'print'
        assertEquals(TokenType.IDENTIFIER, tokens.get(6).type);   // 'x'
        assertEquals(TokenType.SEMICOLON, tokens.get(7).type);    // ';'
        assertEquals(TokenType.EOF, tokens.get(8).type);          // End of file
    }

    @Test
    void testUnterminatedMultilineComment() {
        String source = "var x = 42; /* unterminated multiline comment ";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        // The scanner should still produce an EOF token but might log an error
        assertEquals(TokenType.VAR, tokens.get(0).type);          // 'var'
        assertEquals(TokenType.IDENTIFIER, tokens.get(1).type);   // 'x'
        assertEquals(TokenType.EQUAL, tokens.get(2).type);        // '='
        assertEquals(TokenType.NUMBER, tokens.get(3).type);       // '42'
        assertEquals(TokenType.SEMICOLON, tokens.get(4).type);    // ';'
        assertEquals(TokenType.EOF, tokens.get(5).type);          // End of file
    }

    @Test
    void testNestedMultilineComment() {
        String source = "var x = 42; /* outer /* nested */ end of outer */ print x;";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        assertEquals(TokenType.VAR, tokens.get(0).type);          // 'var'
        assertEquals(TokenType.IDENTIFIER, tokens.get(1).type);   // 'x'
        assertEquals(TokenType.EQUAL, tokens.get(2).type);        // '='
        assertEquals(TokenType.NUMBER, tokens.get(3).type);       // '42'
        assertEquals(TokenType.SEMICOLON, tokens.get(4).type);    // ';'
        assertEquals(TokenType.PRINT, tokens.get(5).type);        // 'print'
        assertEquals(TokenType.IDENTIFIER, tokens.get(6).type);   // 'x'
        assertEquals(TokenType.SEMICOLON, tokens.get(7).type);    // ';'
        assertEquals(TokenType.EOF, tokens.get(8).type);          // End of file
    }

    @Test
    void testDeeplyNestedMultilineComment() {
        String source = "/* level 1 /* level 2 /* level 3 */ level 2 ends */ level 1 ends */";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        assertEquals(1, tokens.size()); // Only EOF token should be present
        assertEquals(TokenType.EOF, tokens.get(0).type);
    }

    @Test
    void testUnterminatedNestedMultilineComment() {
        String source = "/* level 1 /* level 2 /* level 3 */ level 2 ends ";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        // Should produce an error but still return tokens
        assertEquals(1, tokens.size()); // Only EOF token should be present
        assertEquals(TokenType.EOF, tokens.get(0).type);
    }
}
