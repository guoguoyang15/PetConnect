package com.example.myapplication.Parser.AttributeFolder;

import com.example.myapplication.AVLTree.Tree;
import com.example.myapplication.Pet;
import com.example.myapplication.tool.AttributeTypeEnum;

import java.util.List;

/**
 * @author 13521
 * @date 15/10/2023
 */
public class bodyTypeAttribute extends basicAttribute {
    public bodyTypeAttribute(String value, int relation) {
        super(value, relation);
    }

    @Override
    public AttributeTypeEnum getATTRIBUTE_TYPE_ENUM() {
        return AttributeTypeEnum.bodyType;
    }

    @Override
    public List<Pet> executeMethod(Tree<Pet> petsTree, List<Pet> petsList) {
        return findDefault(petsTree, petsList);
    }


    @Override
    public String getValue() {
        return value;
    }

    @Override
    public int getRelation() {
        return relation;
    }
}
