package com.example.myapplication.Interface;

import com.example.myapplication.AVLTree.Tree;
import com.example.myapplication.Pet;
import com.example.myapplication.tool.AttributeTypeEnum;

import java.util.List;

/**
 * @author 13521
 * @date 15/10/2023
 */
public interface IAttribute {


    AttributeTypeEnum getATTRIBUTE_TYPE_ENUM();

    List<Pet> executeMethod(Tree<Pet> petsTree,List<Pet> petsList);

    String getValue();

    int getRelation();
}
