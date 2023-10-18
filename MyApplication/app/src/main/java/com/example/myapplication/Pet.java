/**
 * @author Jiasheng Li (u7758372): Create the prototype of Pet class.
 * @author Fan Yue (u7568823): Implement Pet class to Comparable
 * @author Hexuan Meng: Create get method to use in Tree
 */
package com.example.myapplication;

import java.io.Serializable;
import java.util.List;

public class Pet implements Comparable<Pet>, Serializable {
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
