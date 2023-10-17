package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateDataFromFirebase();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        query = getIntent().getStringExtra("query");
        //fan yue is lazy
        query=" money<200;color=red";
        //R.raw.data_sample
        //R.raw.data_sample10
        if (list == null) {
            loadLocalData(R.raw.data_sample_8color);
        }

        MyAdapter myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);

        EditText editTextSearch = findViewById(R.id.editTextSearch);
        if (!query.isEmpty()) {
            editTextSearch.setText(getIntent().getStringExtra("query"));
            myAdapter = new MyAdapter(this, search());
            recyclerView.setAdapter(myAdapter);
        } else {
            editTextSearch.setText("id: ;name: ;type: ;money< ;bodytype: ;color: ;comment:");
        }

        Button buttonSearch = findViewById(R.id.buttonSearch);
        Activity activity = this;
        buttonSearch.setOnClickListener(view -> {
            hideSoftKeyboard();
            query = editTextSearch.getText().toString();

            editTextSearch.setText("id: ;name: ;type: ;money< ;bodytype: ;color: ;comment:");

            MyAdapter myAdapter1 = new MyAdapter(activity, search());
            recyclerView.setAdapter(myAdapter1);
        });
    }

    /**
     * XXX
     *
     * @author XXX
     */
    public List<Pet> search() {
        //AVLTree<Pet> rootNode = Tool.GetPetsAvlTree(list);
        //Tool.ChangeColorInData(list);
        rootNode = Tool.GetPetsAvlTree(list);
        Tokenizer tokenizer = new Tokenizer(query);
        Parser parser = new Parser(tokenizer);
        //commented by fan yue
//        Search search = parser.parseSearch();
//        return search.searchPetsTree(rootNode);
        Search search = parser.parseSearchTest();
        return search.searchPetsTree_Test(rootNode);
    }

    /**
     * Method to load the data saved at local.
     * Used to show results when fetching data from Firebase is processing.
     *
     * @param data This is the id of the data file in raw resource.
     *
     * @author Jiasheng Li (u7758372)
     */
    public void loadLocalData(int data) {
        String strJson;
        InputStream inputStream = getResources().openRawResource(data);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder buffer = new StringBuilder();
        try {
            while ((strJson = bufferedReader.readLine()) != null) { buffer.append(strJson); }
        } catch (IOException e) {
            Toast.makeText(MainActivity.this, "Failed to load local data.", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        strJson = buffer.toString();

        Gson gson = new Gson();
        Type myType = new TypeToken<List<Pet>>(){}.getType();
        list = gson.fromJson(strJson, myType);
    }

    /**
     * Method to fetch latest data from Firebase when network is available,
     * this task is asynchronous
     * so once it's done, it will update the data loaded by application.
     *
     * @author  Jiasheng Li (u7758372)
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
     * @author  Jiasheng Li (u7758372)
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
     * @author  Jiasheng Li (u7758372)
     */
    public void hideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }
}