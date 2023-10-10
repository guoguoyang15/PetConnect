package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Environment;

import com.example.myapplication.AVLTree.AVLTree;
import com.example.myapplication.AVLTree.Tree;
import com.example.myapplication.tool.Tool;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Pet> list;
    String strJson = "";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        InputStream inputStream = getResources().openRawResource(R.raw.data_sample);
//        InputStream inputStream = getResources().openRawResource(R.raw.data_sample10);
        InputStream inputStream = getResources().openRawResource(R.raw.data_sample_8color);

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s;
        try {
            while ((s = bufferedReader.readLine()) != null) {
                strJson = strJson + s + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Gson gson = new Gson();
        Type myType = new TypeToken<List<Pet>>() {
        }.getType();
        list = gson.fromJson(strJson, myType);

        AVLTree<Pet> rootNoed = Tool.GetPetsAvlTree(list);
//        Tool.ChangeColorInData(list);


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                MyAdapter myAdapter = new MyAdapter(list);
                recyclerView.setAdapter(myAdapter);
            }
        });
    }

    /**
     * get the avlTree from the petList
     * @param petList
     * @return
     */


}