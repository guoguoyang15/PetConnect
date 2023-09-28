package com.example.myapplication.Parser;

public class Attribute {
    private final String type;
    private final String value;
    private final int relation;

    public Attribute(String type, String value, int relation) {
        this.type = type;
        this.relation = relation;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public int getRelation() {
        return relation;
    }
}
