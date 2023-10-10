package com.example.myapplication.Parser;

import com.example.myapplication.AVLTree.Tree;
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

    public Search() {
    }

    public List<Pet> searchPets(List<Pet> allPets) {
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
        if (money != null) {
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

    public List<Pet> findGreater(Attribute attribute, Tree<Pet> pets) {
        // Ensure input is not null.
        if (attribute == null)
            throw new IllegalArgumentException("Input cannot be null");
        List<Pet> greaterNodes = new ArrayList<>();
        if (pets.value != null) {
            if (Integer.parseInt(attribute.getValue()) == pets.value.getMoney()) {
                greaterNodes.addAll(pets.rightNode.inOrder());
                if (pets.leftNode != null && pets.leftNode.value != null) {
                    greaterNodes.addAll(findGreater(attribute, pets.leftNode));
                }
            } else if (Integer.parseInt(attribute.getValue()) < pets.value.getMoney()) {
                greaterNodes.addAll(pets.rightNode.inOrder());
                greaterNodes.add(pets.value);
                if (pets.leftNode != null && pets.leftNode.value != null) {
                    greaterNodes.addAll(findGreater(attribute, pets.leftNode));
                }
            } else {
                if (pets.rightNode != null && pets.rightNode.value != null) {
                    greaterNodes.addAll(findGreater(attribute, pets.rightNode));
                }
            }
        }
        return greaterNodes;
    }

    public List<Pet> findSmaller(Attribute attribute, Tree<Pet> pets) {
        // Ensure input is not null.
        if (attribute == null)
            throw new IllegalArgumentException("Input cannot be null");

        List<Pet> smallerNodes = new ArrayList<>();
        if (pets.value != null) {
            if (Integer.parseInt(attribute.getValue()) == pets.value.getMoney()) {
                smallerNodes.addAll(pets.leftNode.inOrder());
            } else if (Integer.parseInt(attribute.getValue()) < pets.value.getMoney()) {
                if (pets.leftNode != null && pets.leftNode.value != null) {
                    smallerNodes.addAll(findSmaller(attribute, pets.leftNode));
                }
            } else {
                smallerNodes.addAll(pets.leftNode.inOrder());
                smallerNodes.add(pets.value);
                if (pets.rightNode != null && pets.rightNode.value != null) {
                    smallerNodes.addAll(findSmaller(attribute, pets.rightNode));
                }
            }
        }
        return smallerNodes;
    }

    public List<Pet> findEqual(Attribute attribute, Tree<Pet> pets) {
        // Ensure input is not null.
        if (attribute == null)
            throw new IllegalArgumentException("Input cannot be null");

        List<Pet> equalNodes = new ArrayList<>();
        if (pets.value != null) {
            if (Integer.parseInt(attribute.getValue()) == pets.value.getMoney()) {
                equalNodes.add(pets.value);
                if (pets.leftNode != null && pets.leftNode.value != null) {
                    equalNodes.addAll(findEqual(attribute, pets.leftNode));
                }
            } else if (Integer.parseInt(attribute.getValue()) < pets.value.getMoney()) {
                if (pets.leftNode != null && pets.leftNode.value != null) {
                    equalNodes.addAll(findEqual(attribute, pets.leftNode));
                }
            } else {
                if (pets.rightNode != null && pets.rightNode.value != null) {
                    equalNodes.addAll(findEqual(attribute, pets.rightNode));
                }
            }
        }
        return equalNodes;
    }

    public List<Pet> searchPetsTree(Tree<Pet> allPets) {
        List<Pet> outputPetList = new ArrayList<>();
        if (money != null) {
            outputPetList.size();
            if (money.getRelation() == 0) {
                outputPetList.addAll(findEqual(money, allPets));
            }
            if (money.getRelation() == -1) {
                outputPetList.addAll(findSmaller(money, allPets));
            }
            if (money.getRelation() == 1) {
                outputPetList.addAll(findGreater(money, allPets));
            }
        }
        if (id != null) {
            if (outputPetList.size() > 0) {
                List<Pet> currentPetList = outputPetList;
                outputPetList = new ArrayList<>();
                for (Pet pet : currentPetList) {
                    if (pet.getId().equals(id.getValue())) {
                        outputPetList.add(pet);
                        return outputPetList;
                    }
                }
            } else {
                for (Pet pet : allPets.inOrder()) {
                    if (pet.getId().equals(id.getValue())) {
                        outputPetList.add(pet);
                        return outputPetList;
                    }
                }
            }
        }
        if (name != null) {
            if (outputPetList.size() > 0) {
                List<Pet> currentPetList = outputPetList;
                outputPetList = new ArrayList<>();
                for (Pet pet : currentPetList) {
                    if (pet.getName().equals(name.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            } else {
                for (Pet pet : allPets.inOrder()) {
                    if (pet.getName().equals(name.getValue())) {
                        outputPetList.add(pet);
                    }
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
                for (Pet pet : allPets.inOrder()) {
                    if (pet.getType().equals(type.getValue())) {
                        outputPetList.add(pet);
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
                for (Pet pet : allPets.inOrder()) {
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
                for (Pet pet : allPets.inOrder()) {
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
                for (Pet pet : allPets.inOrder()) {
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
