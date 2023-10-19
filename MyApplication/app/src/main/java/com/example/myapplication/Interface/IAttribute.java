package com.example.myapplication.Interface;

import com.example.myapplication.AVLTree.Tree;
import com.example.myapplication.Pet;
import com.example.myapplication.tool.AttributeTypeEnum;

import java.util.List;

/**
 * @param
 * @author u7568823 FanYue
 * @description the attribute interface, such as money,color
 * @return
 * @time 15/10/2023
 */
public interface IAttribute {

    /**
     * get the attribute type
     *
     * @return attribute type
     */
    AttributeTypeEnum getATTRIBUTE_TYPE_ENUM();

    /**
     * @param petsList the filtered result
     * @return
     * @description filter the list with an attribute to get the result
     * @author u7568823 FanYue
     * @time 19/10/2023
     */
    List<Pet> executeMethod(Tree<Pet> petsTree, List<Pet> petsList);

    /**
     * @param
     * @return the value in string
     * @description get the value of this attribute
     * @author u7568823 FanYue
     * @time 18/10/2023
     */
    String getValue();

    /**
     * @param
     * @return
     * @description get the relation of attribute,for example, the 0 means equal
     * @author u7568823 FanYue
     * @time 18/10/2023
     */
    int getRelation();
}
