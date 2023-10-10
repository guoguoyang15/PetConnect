package com.example.myapplication;

import android.service.autofill.FillEventHistory;

import java.util.List;

public class Pet implements Comparable<Pet> {
    String id;
    String name;
    String type;
    int Money;
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
        return Money;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String value) {
        this.color = value;
    }

    public List<String> getComment() {
        return comment;
    }

    @Override
    public int compareTo(Pet pet) {
        return this.Money - pet.Money;
    }
}
