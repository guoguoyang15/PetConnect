package com.example.myapplication.Interface;

import com.example.myapplication.AVLTree.Tree;
import com.example.myapplication.Pet;
import com.example.myapplication.tool.AttributeTypeEnum;

import java.util.List;

/**
  * @description the attribute interface, such as money,color
  * @param
  * @return
  * @author u7568823 FanYue
  * @time 15/10/2023
  */
public interface IAttribute {

    /**
     * get the attribute type
     * @return attribute type
     */
    AttributeTypeEnum getATTRIBUTE_TYPE_ENUM();

    /**
     *
     * @param petsTree
     * @param petsList
     * @return
     */

    List<Pet> executeMethod(Tree<Pet> petsTree,List<Pet> petsList);
/**
  * @description get the value of this attribute
  * @param 
  * @return the value in string
  * @author u7568823 FanYue
  * @time 18/10/2023
  */
    String getValue();
/**
  * @description get the relation of attribute,for example, the 0 means equal
  * @param 
  * @return 
  * @author u7568823 FanYue
  * @time 18/10/2023
  */
    int getRelation();
}
