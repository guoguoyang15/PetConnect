package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    EditText searchInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        TextView greetings = findViewById(R.id.greetings);
        String username = getIntent().getStringExtra("username");
        StringBuilder buffer = new StringBuilder();
        buffer.append("Hello, ").append(username).append("!");
        greetings.setText(buffer.toString());

        searchInput = findViewById(R.id.editTextText);
        Button buttonSearch = findViewById(R.id.button);
        buttonSearch.setOnClickListener(view -> {
            String query = searchInput.getText().toString();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("query",query);
            startActivityForResult(intent,123);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        EditText searchInput = findViewById(R.id.editTextText);
        if (data != null) {
            searchInput.setText(data.getStringExtra("query"));
        }
    }
}