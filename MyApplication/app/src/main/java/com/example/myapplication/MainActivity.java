package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.AVLTree.AVLTree;
import com.example.myapplication.Parser.Parser;
import com.example.myapplication.Parser.Search;
import com.example.myapplication.Parser.Tokenizer;
import com.example.myapplication.tool.Tool;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
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

        AVLTree<Pet> rootNode = Tool.GetPetsAvlTree(list);
//        Tool.ChangeColorInData(list);
        Button buttonSearch = findViewById(R.id.buttonSearch);
        buttonSearch.setOnClickListener(view -> {
            EditText editTextSearch = findViewById(R.id.editTextSearch);
            String searchInput = editTextSearch.getText().toString();
            editTextSearch.setText("id: ;name: ;type: ;money< ;bodytype: ;color: ;comment:");
            Tokenizer tokenizer = new Tokenizer(searchInput);
            Parser parser = new Parser(tokenizer);
            Search search = parser.parseSearch();
            List<Pet> searchResult = search.searchPetsTree(rootNode);
            MyAdapter myAdapter = new MyAdapter(searchResult);
            recyclerView.setAdapter(myAdapter);
        });


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                MyAdapter myAdapter = new MyAdapter(list);
                recyclerView.setAdapter(myAdapter);
            }
        });
    }


}