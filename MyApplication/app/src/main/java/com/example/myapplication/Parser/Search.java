package com.example.myapplication.Parser;

import com.example.myapplication.AVLTree.Tree;
import com.example.myapplication.Interface.IAttribute;
import com.example.myapplication.Parser.AttributeFolder.bodyTypeAttribute;
import com.example.myapplication.Parser.AttributeFolder.colorAttribute;
import com.example.myapplication.Parser.AttributeFolder.commentAttribute;
import com.example.myapplication.Parser.AttributeFolder.idAttribute;
import com.example.myapplication.Parser.AttributeFolder.moneyAttribute;
import com.example.myapplication.Parser.AttributeFolder.nameAttribute;
import com.example.myapplication.Parser.AttributeFolder.typeAttribute;
import com.example.myapplication.Pet;
import com.example.myapplication.tool.Tool;

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
    private ArrayList<IAttribute> attributeArrayList = new ArrayList<>();

    public Search() {
    }

    public List<Pet> searchPets(List<Pet> allPets) {
        List<Pet> outputPetList = new ArrayList<>();
        if (id != null && id.getValue() != null && !id.getValue().equals("")) {
            for (Pet pet : allPets) {
                if (pet.getId().equalsIgnoreCase(id.getValue())) {
                    outputPetList.add(pet);
                    return outputPetList;
                }
            }
        }
        if (name != null && name.getValue() != null && !name.getValue().equals("")) {
            for (Pet pet : allPets) {
                if (pet.getName().equalsIgnoreCase(name.getValue())) {
                    outputPetList.add(pet);
                }
            }
        }
        if (type != null && type.getValue() != null && !type.getValue().equals("")) {
            if (outputPetList.size() > 0) {
                List<Pet> currentPetList = outputPetList;
                outputPetList = new ArrayList<>();
                for (Pet pet : currentPetList) {
                    if (pet.getType().equalsIgnoreCase(type.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            } else {
                for (Pet pet : allPets) {
                    if (pet.getType().equalsIgnoreCase(type.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            }
        }

        if (money != null && money.getValue() != null && !money.getValue().equals("")) {
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
        if (bodyType != null && bodyType.getValue() != null && !bodyType.getValue().equals("")) {
            if (outputPetList.size() > 0) {
                List<Pet> currentPetList = outputPetList;
                outputPetList = new ArrayList<>();
                for (Pet pet : currentPetList) {
                    if (pet.getBodyType().equalsIgnoreCase(bodyType.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            } else {
                for (Pet pet : allPets) {
                    if (pet.getBodyType().equalsIgnoreCase(bodyType.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            }
        }
        if (color != null && color.getValue() != null && !color.getValue().equals("")) {
            if (outputPetList.size() > 0) {
                List<Pet> currentPetList = outputPetList;
                outputPetList = new ArrayList<>();
                for (Pet pet : currentPetList) {
                    if (pet.getColor().equalsIgnoreCase(color.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            } else {
                for (Pet pet : allPets) {
                    if (pet.getColor().equalsIgnoreCase(color.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            }
        }
        if (comment != null && comment.getValue() != null && !comment.getValue().equals("")) {
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
                            break;
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


        if (money != null && money.getValue() != null && !money.getValue().equals("")) {
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
        if (id != null && id.getValue() != null && !id.getValue().equals("")) {
            if (outputPetList.size() > 0) {
                List<Pet> currentPetList = outputPetList;
                outputPetList = new ArrayList<>();
                for (Pet pet : currentPetList) {
                    if (pet.getId().equalsIgnoreCase(id.getValue())) {
                        outputPetList.add(pet);
                        return outputPetList;
                    }
                }
            } else {
                for (Pet pet : allPets.inOrder()) {
                    if (pet.getId().equalsIgnoreCase(id.getValue())) {
                        outputPetList.add(pet);
                        return outputPetList;
                    }
                }
            }
        }
        if (name != null && name.getValue() != null && !name.getValue().equals("")) {
            if (outputPetList.size() > 0) {
                List<Pet> currentPetList = outputPetList;
                outputPetList = new ArrayList<>();
                for (Pet pet : currentPetList) {
                    if (pet.getName().equalsIgnoreCase(name.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            } else {
                for (Pet pet : allPets.inOrder()) {
                    if (pet.getName().equalsIgnoreCase(name.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            }
        }
        if (type != null && type.getValue() != null && !type.getValue().equals("")) {
            if (outputPetList.size() > 0) {
                List<Pet> currentPetList = outputPetList;
                outputPetList = new ArrayList<>();
                for (Pet pet : currentPetList) {
                    if (pet.getType().equalsIgnoreCase(type.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            } else {
                for (Pet pet : allPets.inOrder()) {
                    if (pet.getType().equalsIgnoreCase(type.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            }
        }
        if (bodyType != null && bodyType.getValue() != null && !bodyType.getValue().equals("")) {
            if (outputPetList.size() > 0) {
                List<Pet> currentPetList = outputPetList;
                outputPetList = new ArrayList<>();
                for (Pet pet : currentPetList) {
                    if (pet.getBodyType().equalsIgnoreCase(bodyType.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            } else {
                for (Pet pet : allPets.inOrder()) {
                    if (pet.getBodyType().equalsIgnoreCase(bodyType.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            }
        }
        if (color != null && color.getValue() != null && !color.getValue().equals("")) {
            if (outputPetList.size() > 0) {
                List<Pet> currentPetList = outputPetList;
                outputPetList = new ArrayList<>();
                for (Pet pet : currentPetList) {
                    if (pet.getColor().equalsIgnoreCase(color.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            } else {
                for (Pet pet : allPets.inOrder()) {
                    if (pet.getColor().equalsIgnoreCase(color.getValue())) {
                        outputPetList.add(pet);
                    }
                }
            }
        }
        if (comment != null && comment.getValue() != null && !comment.getValue().equals("")) {
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
                            break;
                        }
                    }
                }
            }
        }
        return outputPetList;
    }

    /**
     * merge the "searchPetsTree" method with design pattern
     *
     * @param allPets
     * @return
     */
    public List<Pet> searchPetsTree_Test(Tree<Pet> allPets) {


        //region fan yue testing the design pattern
//        attributeArrayList.add(new moneyAttribute(money.getValue(), money.getRelation()));
//        attributeArrayList.add(new idAttribute(id.getValue(), id.getRelation()));
//        attributeArrayList.add(new nameAttribute(name.getValue(), name.getRelation()));
//        attributeArrayList.add(new typeAttribute(type.getValue(), type.getRelation()));
//        attributeArrayList.add(new bodyTypeAttribute(bodyType.getValue(), bodyType.getRelation()));
//        attributeArrayList.add(new colorAttribute(color.getValue(), color.getRelation()));
//        attributeArrayList.add(new commentAttribute(comment.getValue(), comment.getRelation()));
        List<Pet> outputPetList = new ArrayList<>();
        outputPetList.addAll(attributeArrayList.get(0).executeMethod(allPets, outputPetList));
        for (int i = 1; i < attributeArrayList.size(); i++) {
            outputPetList = attributeArrayList.get(i).executeMethod(allPets, outputPetList);
        }


        return outputPetList;
        //endregion
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

    public void addAttributesToList(IAttribute attribute) {
        attributeArrayList.add(attribute);
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
