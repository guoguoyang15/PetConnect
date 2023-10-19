package com.example.myapplication.Parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TokenizerTest {
    private static Tokenizer tokenizer;
    private static final String SEARCH = "id:1a2b-34cd5e-67 ;name:sue ;type:mouse ;money<1000 ;bodytype:big ;color:red ;comment:cute123";
    private static final String ALTERNATIVE_SEARCH = "id=1a2b-34cd5e-67 ;name=sue ;type=mouse ;money>1000 ;bodytype=big ;color=red ;comment=cute123";

    @Test(timeout=1000)
    public void testSearchTokenResult() {
        tokenizer = new Tokenizer(SEARCH);
        assertEquals(new Token("id", Token.Type.IDENTIFIER), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token(":", Token.Type.OPERATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("1a2b-34cd5e-67", Token.Type.STRING_LITERAL), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token(";", Token.Type.SEPARATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("name", Token.Type.IDENTIFIER), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token(":", Token.Type.OPERATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("sue", Token.Type.STRING_LITERAL), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token(";", Token.Type.SEPARATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("type", Token.Type.IDENTIFIER), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token(":", Token.Type.OPERATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("mouse", Token.Type.STRING_LITERAL), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token(";", Token.Type.SEPARATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("money", Token.Type.IDENTIFIER), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("<", Token.Type.OPERATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("1000", Token.Type.NUMERIC_LITERAL), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token(";", Token.Type.SEPARATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("bodytype", Token.Type.IDENTIFIER), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token(":", Token.Type.OPERATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("big", Token.Type.STRING_LITERAL), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token(";", Token.Type.SEPARATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("color", Token.Type.IDENTIFIER), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token(":", Token.Type.OPERATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("red", Token.Type.STRING_LITERAL), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token(";", Token.Type.SEPARATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("comment", Token.Type.IDENTIFIER), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token(":", Token.Type.OPERATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("cute123", Token.Type.STRING_LITERAL), tokenizer.current());
    }
    @Test(timeout=1000)
    public void testAlternativeSearchTokenResult() {
        tokenizer = new Tokenizer(ALTERNATIVE_SEARCH);
        assertEquals(new Token("id", Token.Type.IDENTIFIER), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("=", Token.Type.OPERATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("1a2b-34cd5e-67", Token.Type.STRING_LITERAL), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token(";", Token.Type.SEPARATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("name", Token.Type.IDENTIFIER), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("=", Token.Type.OPERATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("sue", Token.Type.STRING_LITERAL), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token(";", Token.Type.SEPARATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("type", Token.Type.IDENTIFIER), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("=", Token.Type.OPERATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("mouse", Token.Type.STRING_LITERAL), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token(";", Token.Type.SEPARATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("money", Token.Type.IDENTIFIER), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token(">", Token.Type.OPERATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("1000", Token.Type.NUMERIC_LITERAL), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token(";", Token.Type.SEPARATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("bodytype", Token.Type.IDENTIFIER), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("=", Token.Type.OPERATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("big", Token.Type.STRING_LITERAL), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token(";", Token.Type.SEPARATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("color", Token.Type.IDENTIFIER), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("=", Token.Type.OPERATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("red", Token.Type.STRING_LITERAL), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token(";", Token.Type.SEPARATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("comment", Token.Type.IDENTIFIER), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("=", Token.Type.OPERATOR), tokenizer.current());
        tokenizer.next();
        assertEquals(new Token("cute123", Token.Type.STRING_LITERAL), tokenizer.current());
    }
}
