package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.AVLTree.AVLTree;
import com.example.myapplication.Parser.Parser;
import com.example.myapplication.Parser.Search;
import com.example.myapplication.Parser.Tokenizer;
import com.example.myapplication.tool.Tool;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
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
    String query;
    AVLTree<Pet> rootNode;
    RecyclerView recyclerView;
    EditText editTextSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load the latest data from Firebase Database
        updateDataFromFirebase();
        // Receive the query from SearchActivity, used to search in this
        query = getIntent().getStringExtra("query");
        // Initialize UI component
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        editTextSearch = findViewById(R.id.editTextSearch);
        Button buttonSearch = findViewById(R.id.buttonSearch);

        // Load and show
        loadShowData();

        // Search function
        buttonSearch.setOnClickListener(view -> {
            hideSoftKeyboard();
            query = editTextSearch.getText().toString();
            recyclerView.setAdapter(new MyAdapter(this, search()));
        });
    }

    /**
     * According to the search input, return the search result
     * @return a list of pets as the search result
     * @author u7605165 Hexuan Meng
     */
    public List<Pet> search() {
        try {
            rootNode = Tool.GetPetsAvlTree(list);
            Tokenizer tokenizer = new Tokenizer(query);
            Parser parser = new Parser(tokenizer);
            Search search = parser.parseSearchTest();
            return search.searchPetsTree_Test(rootNode);
        } catch (Parser.IllegalProductionException e) {
            return searchInvalid();
        }
    }

    /**
     * If the search input is invalid, use different search method to return the search result
     * @return a list of pets as the search result
     * @author u7605165 Hexuan Meng
     */
    public List<Pet> searchInvalid() {
        rootNode = Tool.GetPetsAvlTree(list);
        Tokenizer tokenizer = new Tokenizer(query);
        Parser parser = new Parser(tokenizer);
        Search search = parser.parseSearchInvalid();
        return search.searchPetsTree_Test(rootNode);
    }

    /**
     * Method to load data and show:
     * 1) All the data if user doesn't input a query in SearchActivity,
     * 2) Search result if user inputs a query in SearchActivity.
     *
     * @author Jiasheng Li (u7758372)
     */
    public void loadShowData() {
        if (list == null) {
            // If fetching data from Firebase is still processing, use local data
            loadLocalData(R.raw.data);
        }
        if (query.isEmpty()) {
            // Show all data
            recyclerView.setAdapter(new MyAdapter(this, list));
        } else {
            // Show search result
            editTextSearch.setText(query);
            recyclerView.setAdapter(new MyAdapter(this, search()));
        }
    }

    /**
     * Method to load the data saved at local.
     * Used to show results when fetching data from Firebase is processing.
     *
     * @param id This is the id of the data file in raw resource.
     * @author Jiasheng Li (u7758372)
     */
    public void loadLocalData(int id) {
        String strJson; // Store the JSON data as string

        // Data loading process starts below
        InputStream inputStream = getResources().openRawResource(id);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder buffer = new StringBuilder();
        try {
            while ((strJson = bufferedReader.readLine()) != null) {
                buffer.append(strJson);
            }
        } catch (IOException e) {
            Toast.makeText(MainActivity.this, "Failed to load local data.", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        strJson = buffer.toString();

        // Convert the string of JSON data to List<Pet> by Gson
        Gson gson = new Gson();
        Type myType = new TypeToken<List<Pet>>() {
        }.getType();
        list = gson.fromJson(strJson, myType);
    }

    /**
     * Method to fetch latest data from Firebase when network is available,
     * this task is asynchronous
     * so once it's done, it will update the data loaded by application.
     *
     * @author Jiasheng Li (u7758372)
     */
    public void updateDataFromFirebase() {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                GenericTypeIndicator<List<Pet>> genericTypeIndicator = new GenericTypeIndicator<List<Pet>>() {
                };
                list = snapshot.getValue(genericTypeIndicator);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Failed to update data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Method to return the last query back to SearchActivity.
     * Notice that it may be different from the one which user input in SearchActivity.
     * The purpose is to improve user experience.
     *
     * @author Jiasheng Li (u7758372)
     */
    @Override
    public void onBackPressed() {
        Intent back = new Intent();
        back.putExtra("query", query);
        setResult(123, back);
        finish();
        super.onBackPressed();
    }

    /**
     * Method to hide soft key board.
     * Used when user finishes typing and presses "Search" button.
     * The purpose is to improve user experience.
     *
     * @author Jiasheng Li (u7758372)
     */
    public void hideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }
}