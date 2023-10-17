package com.example.myapplication.Parser;

import com.example.myapplication.Interface.IAttribute;
import com.example.myapplication.Parser.AttributeFolder.AttributeFactory;

public class Parser {
    /**
     * The following exception should be thrown if the parse is faced with series of tokens that do not
     * correlate with any possible production rule.
     */
    public static class IllegalProductionException extends IllegalArgumentException {
        public IllegalProductionException(String errorMessage) {
            super(errorMessage);
        }
    }

    // The tokenizer (class field) this parser will use.
    private final Tokenizer tokenizer;
    private int separators;

    /**
     * Parser class constructor
     * Simply sets the tokenizer field.
     */
    public Parser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    /**
     * Adheres to the grammar rule:
     * <search>    ::= (<attribute> <separator>){0-6} <attribute> | <>
     *
     * @return type: Attribute.
     */
    public Search parseSearch() {
        Search search = new Search();
        while (tokenizer.hasNext()) {
            if (tokenizer.current().getType() == Token.Type.IDENTIFIER) {
                Attribute attribute = parseAttribute();
                search.setAttribute(attribute);
                if (tokenizer.hasNext()) {
                    if (tokenizer.current().getType() == Token.Type.SEPARATOR) {
                        separators++;
                        if (separators >= 7) {
                            throw new IllegalProductionException("Too many attributes in the search!");
                        }
                        tokenizer.next();
                        if (!tokenizer.hasNext()) {
                            throw new IllegalProductionException("Search should not end with a separator!");
                        }
                    } else {
                        throw new IllegalProductionException("Expect a separator!");
                    }
                }
            } else {
                throw new IllegalProductionException("Expect an identifier!");
            }
        }
        return search;
    }

    /**
     * FanYue testing merging with designPattern :Adheres to the grammar rule:
     * <search>    ::= (<attribute> <separator>){0-6} <attribute> | <>
     *
     * @return type: Attribute.
     */
    public Search parseSearchTest() {
        AttributeFactory attributeFactory = new AttributeFactory();
        Search search = new Search();
        while (tokenizer.hasNext()) {
            if (tokenizer.current().getType() == Token.Type.IDENTIFIER) {
                Attribute attribute = parseAttribute();
                IAttribute oneAttribute = attributeFactory.getAttribute(attribute);
                search.addAttributesToList(oneAttribute);
                if (tokenizer.hasNext()) {
                    if (tokenizer.current().getType() == Token.Type.SEPARATOR) {
                        separators++;
                        if (separators >= 7) {
                            throw new IllegalProductionException("Too many attributes in the search!");
                        }
                        tokenizer.next();
                        if (!tokenizer.hasNext()) {
                            throw new IllegalProductionException("Search should not end with a separator!");
                        }
                    } else {
                        throw new IllegalProductionException("Expect a separator!");
                    }
                }
            } else {
                throw new IllegalProductionException("Expect an identifier!");
            }
        }
        return search;
    }

    public Search parseSearchInvalid() {
        AttributeFactory attributeFactory = new AttributeFactory();
        Search search = new Search();
        while (tokenizer.hasNext()) {
            if (tokenizer.current().getType() == Token.Type.IDENTIFIER) {
                Attribute attribute = parseAttributeInvalid();
                IAttribute oneAttribute = attributeFactory.getAttribute(attribute);
                search.addAttributesToList(oneAttribute);
                if (tokenizer.hasNext()) {
                    if (tokenizer.current().getType() == Token.Type.SEPARATOR) {
                        separators++;
                        tokenizer.next();
                    }
                }
            } else {
                while (tokenizer.hasNext() && tokenizer.current().getType() != Token.Type.IDENTIFIER) {
                    tokenizer.next();
                }
            }
        }
        return search;
    }

    /**
     * Adheres to the grammar rule:
     * <attribute>   ::=  <identifier> <operator> (<numeric literal> | <string literal>)
     *
     * @return type: Attribute.
     */
    public Attribute parseAttribute() {
        String type = tokenizer.current().getToken();
        tokenizer.next();
        int relation = 0;
        String value = "";
        if (tokenizer.hasNext() && tokenizer.current().getType() == Token.Type.OPERATOR) {
            if (tokenizer.current().getToken().equals("<")) {
                relation = -1;
            }
            if (tokenizer.current().getToken().equals(">")) {
                relation = 1;
            }
            if (!type.equals("money") && relation != 0) {
                throw new IllegalProductionException("Expect an equal operator!");
            }
            tokenizer.next();
            if (tokenizer.hasNext()) {
                if (tokenizer.current().getType() == Token.Type.NUMERIC_LITERAL || tokenizer.current().getType() == Token.Type.STRING_LITERAL) {
                    value = tokenizer.current().getToken();
                    tokenizer.next();
                }
            }
        } else {
            throw new IllegalProductionException("Expect an operator!");
        }
        return new Attribute(type, value, relation);
    }
    public Attribute parseAttributeInvalid() {
        String type = tokenizer.current().getToken();
        tokenizer.next();
        int relation = 0;
        String value = "";
        if (tokenizer.hasNext() && tokenizer.current().getType() == Token.Type.OPERATOR) {
            if (tokenizer.current().getToken().equals("<")) {
                relation = -1;
            }
            if (tokenizer.current().getToken().equals(">")) {
                relation = 1;
            }
            if (!type.equals("money") && relation != 0) {
                relation = 0;
            }
            tokenizer.next();
        }
        if (tokenizer.hasNext()) {
            if (tokenizer.current().getType() == Token.Type.NUMERIC_LITERAL || tokenizer.current().getType() == Token.Type.STRING_LITERAL) {
                value = tokenizer.current().getToken();
                tokenizer.next();
            }
        }
        return new Attribute(type, value, relation);
    }
}
