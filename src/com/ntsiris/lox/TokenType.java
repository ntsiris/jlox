package com.ntsiris.lox;

enum TokenType {
    // Single-character tokens.
    LEFT_PAREN, RIGHT_PAREN,
    LEFT_BRACE, RIGHT_BRACE,
    COMMA, DOT, SEMICOLON,
    MINUS, PLUS,
    SLASH, STAR,

    // One or two character tokens.
    BANG, BANG_EQUAL,
    EQUAL, EQUAL_EQUAL,
    GREATER, GREATER_EQUAL,
    LESS, LESS_EQUAL,

    // Literals.
    IDENTIFIER, STRING, NUMBER,

    // Keywords.
    AND, OR,
    IF, ELSE,
    FOR, WHILE,
    CLASS, THIS, SUPER,
    FUNC, RETURN,
    TRUE, FALSE,
    VAR, NIL,
    PRINT,

    EOF
}