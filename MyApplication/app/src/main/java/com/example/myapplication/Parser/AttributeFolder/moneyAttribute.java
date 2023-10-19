package com.example.myapplication.Parser.AttributeFolder;

import com.example.myapplication.AVLTree.Tree;
import com.example.myapplication.Interface.IAttribute;
import com.example.myapplication.Pet;
import com.example.myapplication.tool.AttributeTypeEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 13521
 * @date 15/10/2023
 */
public class moneyAttribute extends basicAttribute {
    public moneyAttribute(String value, int relation) {
        super(value, relation);
    }

    @Override
    public AttributeTypeEnum getATTRIBUTE_TYPE_ENUM() {
        return AttributeTypeEnum.money;
    }
    /**
     * @param petsList the filtered result
     * @return
     * @description filter the list or tree with this attribute to get the result
     * @author u7568823 FanYue
     * @time 19/10/2023
     */
    @Override
    public List<Pet> executeMethod(Tree<Pet> petsTree, List<Pet> petsList) {

        outputPetList = new ArrayList<>();
        if (this != null && this.getValue() != null && !this.getValue().equals("")) {
            if (this.getRelation() == 0) {
                outputPetList.addAll(findEqual(this, petsTree));
            }
            if (this.getRelation() == -1) {
                outputPetList.addAll(findSmaller(this, petsTree));
            }
            if (this.getRelation() == 1) {
                outputPetList.addAll(findGreater(this, petsTree));
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
