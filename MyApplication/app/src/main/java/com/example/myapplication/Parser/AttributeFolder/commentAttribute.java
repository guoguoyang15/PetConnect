package com.example.myapplication.Parser.AttributeFolder;

import com.example.myapplication.AVLTree.Tree;
import com.example.myapplication.Pet;
import com.example.myapplication.tool.AttributeTypeEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 13521
 * @date 15/10/2023
 */
public class commentAttribute extends basicAttribute {
    public commentAttribute(String value, int relation) {
        super(value, relation);
    }

    @Override
    public AttributeTypeEnum getATTRIBUTE_TYPE_ENUM() {
        return AttributeTypeEnum.comment;
    }

    @Override
    public List<Pet> executeMethod(Tree<Pet> petsTree, List<Pet> petsList) {
        outputPetList = petsList;
        if (this != null && this.getValue() != null && !this.getValue().equals("")) {
            if (outputPetList.size() > 0) {
                List<Pet> currentPetList = outputPetList;
                outputPetList = new ArrayList<>();
                for (Pet pet : currentPetList) {
                    for (String comment : pet.getComment()) {
                        if (comment.contains(this.getValue())) {
                            outputPetList.add(pet);
                        }
                    }
                }
            } else {
                for (Pet pet : petsTree.inOrder()) {
                    for (String comment : pet.getComment()) {
                        if (comment.contains(this.getValue())) {
                            outputPetList.add(pet);
                            break;
                        }
                    }
                }
            }
        }
        return outputPetList;
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
