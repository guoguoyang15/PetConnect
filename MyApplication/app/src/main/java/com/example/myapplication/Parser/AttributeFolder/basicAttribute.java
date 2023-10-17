package com.example.myapplication.Parser.AttributeFolder;

import com.example.myapplication.AVLTree.Tree;
import com.example.myapplication.Interface.IAttribute;
import com.example.myapplication.Parser.Attribute;
import com.example.myapplication.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 13521
 * @date 15/10/2023
 */
public abstract class basicAttribute implements IAttribute{

    protected final String value;
    protected final int relation;
    protected List<Pet> outputPetList = new ArrayList<>();

    public basicAttribute(String value, int relation) {

        this.relation = relation;
        this.value = value;
    }


    protected List<Pet> findEqual(IAttribute attribute, Tree<Pet> pets) {
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

    protected List<Pet> findSmaller(IAttribute attribute, Tree<Pet> pets) {
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


    public List<Pet> findGreater(IAttribute attribute, Tree<Pet> pets) {
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

}
