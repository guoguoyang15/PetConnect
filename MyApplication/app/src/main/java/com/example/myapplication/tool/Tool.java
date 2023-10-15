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
     * @param petList
     * @return the petList with modified attributes
     */
    public static void ChangeColorInData(List<Pet> petList) {
        Random rd = new Random();
        PetColor[] colorList = PetColor.values();
        int limit = colorList.length;
        for (Pet onePet : petList
        ) {
            int colorNum = rd.nextInt(limit);
            onePet.setColor(colorList[colorNum].toString());
        }
//PetColor.Blue.ordinal()

    }

    public static void WriteIntoFile(List<Pet> list) {
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(path, "testjson.json");
        String jsonPath = "D:\\01Gan\\abroad\\study\\05ANU\\SoftwareEngineeringConstruction\\SECGroupAssignment2\\ga-23s2\\MyApplication\\app\\src\\main\\res\\raw\\testjson.json";
//        try (PrintWriter out = new PrintWriter(new FileWriter(jsonPath))) {
        try (PrintWriter out = new PrintWriter(file)) {
            Gson oneGson = new Gson();
            String jsonString = oneGson.toJson(list);
            out.write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param petList
     * @return the avlTree RootNode
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

