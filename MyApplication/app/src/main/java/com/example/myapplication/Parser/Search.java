package com.example.myapplication.Parser;

import com.example.myapplication.AVLTree.Tree;
import com.example.myapplication.Interface.IAttribute;
import com.example.myapplication.Pet;
import com.example.myapplication.tool.AttributeTypeEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * A class represents the search input
 * @author u7605165 Hexuan Meng
 */
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

    /**
     * Find pets whose price are higher than the given price
     * @return a list of pets with the price higher than the given price
     */
    public List<Pet> findGreater(Attribute attribute, Tree<Pet> pets) {
        // Ensure input is not null.
        if (attribute == null)
            throw new IllegalArgumentException("Input cannot be null");
        List<Pet> greaterNodes = new ArrayList<>();
        if (pets.value != null) {
            if (Integer.parseInt(attribute.getValue()) == pets.value.getMoney()) {
                greaterNodes.addAll(pets.rightNode.inOrder());
            } else if (Integer.parseInt(attribute.getValue()) < pets.value.getMoney()) {
                if (pets.leftNode != null && pets.leftNode.value != null) {
                    greaterNodes.addAll(findGreater(attribute, pets.leftNode));
                }
                greaterNodes.add(pets.value);
                greaterNodes.addAll(pets.rightNode.inOrder());
            } else {
                if (pets.rightNode != null && pets.rightNode.value != null) {
                    greaterNodes.addAll(findGreater(attribute, pets.rightNode));
                }
            }
        }
        return greaterNodes;
    }

    /**
     * Find pets whose price are lower than the given price
     * @return a list of pets with the price lower than the given price
     */
    public List<Pet> findSmaller(Attribute attribute, Tree<Pet> pets) {
        // Ensure input is not null.
        if (attribute == null)
            throw new IllegalArgumentException("Input cannot be null");

        List<Pet> smallerNodes = new ArrayList<>();
        if (pets.value != null) {
            if (Integer.parseInt(attribute.getValue()) <= pets.value.getMoney()) {
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

    /**
     * Find pets whose price are equal to the given price
     * @return a list of pets with the price equal to the given price
     */
    public List<Pet> findEqual(Attribute attribute, Tree<Pet> pets) {
        // Ensure input is not null.
        if (attribute == null)
            throw new IllegalArgumentException("Input cannot be null");

        List<Pet> equalNodes = new ArrayList<>();
        if (pets.value != null) {
            if (Integer.parseInt(attribute.getValue()) == pets.value.getMoney()) {
                if (pets.leftNode != null && pets.leftNode.value != null) {
                    equalNodes.addAll(findEqual(attribute, pets.leftNode));
                }
                equalNodes.add(pets.value);
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

    /**
     * Search pets in a tree that meet the attributes of the search object
     * @param allPets pets ordered by their price in a tree
     * @return a list of pets as the search result
     */
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
     * @param
     * @return
     * @description filter the list accordingto the query.
     * this method  merge the "searchPetsTree" method with design pattern
     * @author u7568823 FanYue
     * @time 19/10/2023
     */
    public List<Pet> searchPetsTree_Test(Tree<Pet> allPets) {

        ArrayList<IAttribute> listInOrder = new ArrayList<>();
        for (IAttribute oneAttri : attributeArrayList
        ) {
            if (oneAttri.getATTRIBUTE_TYPE_ENUM().equals(AttributeTypeEnum.money))
                listInOrder.add(0, oneAttri);
            else {
                listInOrder.add(oneAttri);
            }
        }
        attributeArrayList = listInOrder;
        List<Pet> outputPetList = new ArrayList<>();
        boolean emptySearch = true;
        for (int i = 0; i < attributeArrayList.size(); i++) {
            IAttribute attribute = attributeArrayList.get(i);
            if (attribute != null && attribute.getValue() != null && !attribute.getValue().equals("")) {
                emptySearch = false;
            }
            outputPetList = attributeArrayList.get(i).executeMethod(allPets, outputPetList);
        }
        if (emptySearch) {
            return allPets.inOrder();
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
