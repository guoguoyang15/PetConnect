package com.example.myapplication.Parser;

public class Tokenizer {
    private String buffer;          // String to be transformed into tokens each time next() is called.
    private Token currentToken;     // The current token. The next token is extracted when next() is called.

    /**
     * Tokenizer class constructor
     * The constructor extracts the first token and save it to currentToken
     */
    public Tokenizer(String text) {
        buffer = text;          // save input text (string)
        next();                 // extracts the first token.
    }

    /**
     * This function will find and extract a next token from {@code _buffer} and
     * save the token to {@code currentToken}.
     */
    public void next() {
        buffer = buffer.trim();     // remove whitespace

        if (buffer.isEmpty()) {
            currentToken = null;    // if there's no string left, set currentToken null and return
            return;
        }
        char firstChar = buffer.charAt(0);
        if (buffer.length() >= 2 && buffer.substring(0, 2).equalsIgnoreCase("id")) {
            currentToken = new Token("id", Token.Type.IDENTIFIER);
        } else if (buffer.length() >= 4 && buffer.substring(0, 4).equalsIgnoreCase("name")) {
            currentToken = new Token("name", Token.Type.IDENTIFIER);
        } else if (buffer.length() >= 4 && buffer.substring(0, 4).equalsIgnoreCase("type")) {
            currentToken = new Token("type", Token.Type.IDENTIFIER);
        } else if (buffer.length() >= 5 && buffer.substring(0, 5).equalsIgnoreCase("money")) {
            currentToken = new Token("money", Token.Type.IDENTIFIER);
        } else if (buffer.length() >= 8 && buffer.substring(0, 8).equalsIgnoreCase("bodytype")) {
            currentToken = new Token("bodytype", Token.Type.IDENTIFIER);
        } else if (buffer.length() >= 5 && buffer.substring(0, 5).equalsIgnoreCase("color")) {
            currentToken = new Token("color", Token.Type.IDENTIFIER);
        } else if (buffer.length() >= 7 && buffer.substring(0, 7).equalsIgnoreCase("comment")) {
            currentToken = new Token("comment", Token.Type.IDENTIFIER);
        } else if (firstChar == ';') {
            currentToken = new Token(";", Token.Type.SEPARATOR);
        } else if (firstChar == ':') {
            currentToken = new Token(":", Token.Type.OPERATOR);
        } else if (firstChar == '=') {
            currentToken = new Token("=", Token.Type.OPERATOR);
        } else if (firstChar == '<') {
            currentToken = new Token("<", Token.Type.OPERATOR);
        } else if (firstChar == '>') {
            currentToken = new Token(">", Token.Type.OPERATOR);
        } else if (Character.isDigit(firstChar)) {
            int pos = 1;
            while (pos < buffer.length() && Character.isDigit(buffer.charAt(pos))) {
                pos++;
            }
            if (pos + 1 < buffer.length() && buffer.charAt(pos) == '.' && Character.isDigit(buffer.charAt(pos + 1))) {
                pos++;
                while (pos < buffer.length() && Character.isDigit(buffer.charAt(pos))) {
                    pos++;
                }
            }
            currentToken = new Token(buffer.substring(0, pos), Token.Type.NUMERIC_LITERAL);
        } else {
            int pos = 0;
            while (pos < buffer.length() && buffer.charAt(pos) != ';' && buffer.charAt(pos) != ' ') {
                pos++;
            }
            currentToken = new Token(buffer.substring(0, pos), Token.Type.STRING_LITERAL);
        }
        // Remove the extracted token from buffer
        int tokenLen = currentToken.getToken().length();
        buffer = buffer.substring(tokenLen);
    }

    /**
     * Returns the current token extracted by {@code next()}
     *
     * @return type: Token
     */
    public Token current() {
        return currentToken;
    }

    /**
     * Check whether tokenizer still has tokens left
     *
     * @return type: boolean
     */
    public boolean hasNext() {
        return currentToken != null;
    }
}
