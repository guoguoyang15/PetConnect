package com.example.myapplication.Parser;

import com.example.myapplication.Pet;

import java.util.ArrayList;
import java.util.List;

public class Search {
    private Attribute id;
    private Attribute name;
    private Attribute type;
    private Attribute money;
    private Attribute bodyType;
    private Attribute color;
    private Attribute comment;
    public Search() {}
    public List<Pet> searchPets (List<Pet> allPets) {
        List<Pet> outputPetList = new ArrayList<>();
        if (id != null) {
            for (Pet pet : allPets) {
                if (pet.getId().equals(id.getValue())) {
                    outputPetList.add(pet);
                    return outputPetList;
                }
            }
        }
        if (name != null) {
            for (Pet pet : allPets) {
                if (pet.getName().equals(name.getValue())) {
                    outputPetList.add(pet);
                }
            }
        }
        if (type != null) {
            if (outputPetList.size() > 0) {
                List<Pet> currentPetList = outputPetList;
                outputPetList = new ArrayList<>();
                for (Pet pet : currentPetList) {
                    if (pet.getType().equals(type.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            } else {
                for (Pet pet : allPets) {
                    if (pet.getType().equals(type.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            }
        }
        if (money!= null) {
            if (outputPetList.size() > 0) {
                List<Pet> currentPetList = outputPetList;
                outputPetList = new ArrayList<>();
                for (Pet pet : currentPetList) {
                    if (money.getRelation() == 0) {
                        if (pet.getMoney() == Integer.parseInt(money.getValue())) {
                            outputPetList.add(pet);
                        }
                    }
                    if (money.getRelation() == -1) {
                        if (pet.getMoney() < Integer.parseInt(money.getValue())) {
                            outputPetList.add(pet);
                        }
                    }
                    if (money.getRelation() == 1) {
                        if (pet.getMoney() > Integer.parseInt(money.getValue())) {
                            outputPetList.add(pet);
                        }
                    }
                }
            } else {
                for (Pet pet : allPets) {
                    if (money.getRelation() == 0) {
                        if (pet.getMoney() == Integer.parseInt(money.getValue())) {
                            outputPetList.add(pet);
                        }
                    }
                    if (money.getRelation() == -1) {
                        if (pet.getMoney() < Integer.parseInt(money.getValue())) {
                            outputPetList.add(pet);
                        }
                    }
                    if (money.getRelation() == 1) {
                        if (pet.getMoney() > Integer.parseInt(money.getValue())) {
                            outputPetList.add(pet);
                        }
                    }
                }
            }
        }
        if (bodyType != null) {
            if (outputPetList.size() > 0) {
                List<Pet> currentPetList = outputPetList;
                outputPetList = new ArrayList<>();
                for (Pet pet : currentPetList) {
                    if (pet.getBodyType().equals(bodyType.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            } else {
                for (Pet pet : allPets) {
                    if (pet.getBodyType().equals(bodyType.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            }
        }
        if (color != null) {
            if (outputPetList.size() > 0) {
                List<Pet> currentPetList = outputPetList;
                outputPetList = new ArrayList<>();
                for (Pet pet : currentPetList) {
                    if (pet.getColor().equals(color.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            } else {
                for (Pet pet : allPets) {
                    if (pet.getColor().equals(color.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            }
        }
        if (comment != null) {
            if (outputPetList.size() > 0) {
                List<Pet> currentPetList = outputPetList;
                outputPetList = new ArrayList<>();
                for (Pet pet : currentPetList) {
                    for (String comment : pet.getComment()) {
                        if (comment.contains(this.comment.getValue())) {
                            outputPetList.add(pet);
                        }
                    }
                }
            } else {
                for (Pet pet : allPets) {
                    for (String comment : pet.getComment()) {
                        if (comment.contains(this.comment.getValue())) {
                            outputPetList.add(pet);
                        }
                    }
                }
            }
        }
        return outputPetList;
    }
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
