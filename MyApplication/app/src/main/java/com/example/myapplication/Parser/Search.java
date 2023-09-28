package com.example.myapplication.Parser;

public class Search {
    private Attribute id;
    private Attribute name;
    private Attribute type;
    private Attribute money;
    private Attribute bodyType;
    private Attribute color;
    private Attribute comment;
    public Search() {}
    public void setAttribute(Attribute attribute) {
        if (attribute.getType().equals("id")) {
            this.id = attribute;
        }
        if (attribute.getType().equals("name")) {
            this.name = attribute;
        }
        if (attribute.getType().equals("type")) {
            this.type = attribute;
        }
        if (attribute.getType().equals("money")) {
            this.money = attribute;
        }
        if (attribute.getType().equals("bodytype")) {
            this.bodyType = attribute;
        }
        if (attribute.getType().equals("color")) {
            this.color = attribute;
        }
        if (attribute.getType().equals("comment")) {
            this.comment = attribute;
        }
    }

    public Attribute getId() {
        return id;
    }

    public Attribute getName() {
        return name;
    }

    public Attribute getType() {
        return type;
    }

    public Attribute getMoney() {
        return money;
    }

    public Attribute getBodyType() {
        return bodyType;
    }

    public Attribute getColor() {
        return color;
    }

    public Attribute getComment() {
        return comment;
    }
}
