package com.example.myapplication.Parser;

import androidx.annotation.NonNull;

import java.util.Objects;

/**
 * @author u7605165 Hexuan Meng
 */
public class Token {
    // The following enum defines different types of tokens.
    public enum Type {SEPARATOR, OPERATOR, IDENTIFIER, STRING_LITERAL, NUMERIC_LITERAL}

    // Fields of the class Token.
    private final String token; // Token representation in String form.
    private final Type type;    // Type of the token.

    public Token(String token, Type type) {
        this.token = token;
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public Type getType() {
        return type;
    }

    @NonNull
    @Override
    public String toString() {
        return type + "(" + token + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true; // Same hashcode.
        if (!(other instanceof Token)) return false; // Null or not the same type.
        return this.type == ((Token) other).getType() && this.token.equals(((Token) other).getToken()); // Values are the same.
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, type);
    }
}
