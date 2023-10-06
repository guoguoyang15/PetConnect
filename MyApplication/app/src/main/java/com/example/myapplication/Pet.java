package com.example.myapplication;

import java.util.List;

public class Pet implements Comparable<Pet> {
    String id;
    String name;
    String type;
    int Money;
    String bodyType;
    String color;
    List<String> comment;

    @Override
    public int compareTo(Pet pet) {
        return this.Money - pet.Money;
    }
}
