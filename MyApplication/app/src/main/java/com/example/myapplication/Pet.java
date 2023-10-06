package com.example.myapplication;

import java.util.List;

public class Pet {
    String id;
    String name;
    String type;
    int money;
    String bodyType;
    String color;
    List<String> comment;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getMoney() {
        return money;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getColor() {
        return color;
    }

    public List<String> getComment() {
        return comment;
    }
}
