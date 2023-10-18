package com.example.myapplication.tool;

import android.os.Environment;

import com.example.myapplication.AVLTree.AVLTree;
import com.example.myapplication.Pet;
import com.google.gson.Gson;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author 13521
 * @date 10/10/2023
 */
public class Tool {



    /**
      * @description get the avltree from pet list
      * @param
      * @return the avlTree RootNode
      * @author u7568823 FanYue
      * @time 19/10/2023
      */
    public static AVLTree<Pet> GetPetsAvlTree(List<Pet> petList) {
        AVLTree<Pet> avl = new AVLTree<>(petList.get(0));

        for (int i = 1; i < petList.size(); i++) {
            Pet onePet = petList.get(i);
            avl = avl.insert(onePet);
        }

        return avl;

    }


}

