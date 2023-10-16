package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Pet pet = (Pet) getIntent().getExtras().getSerializable("pet");

        TextView id = findViewById(R.id.petId);
        id.setText("Pet ID: "+pet.id);
        TextView name = findViewById(R.id.petName);
        name.setText("Pet Name: "+pet.name);
        TextView type = findViewById(R.id.petType);
        type.setText("Pet Type: "+pet.type);
        TextView money = findViewById(R.id.petMoney);
        money.setText("Pet Value: $"+pet.Money);
        TextView bodyType = findViewById(R.id.petBody);
        bodyType.setText("Pet Body Type: "+pet.bodyType);
        TextView color = findViewById(R.id.petColor);
        color.setText("Pet Color: "+pet.color);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,pet.comment);
        ListView comment = findViewById(R.id.commentList);
        comment.setAdapter(adapter);
    }
}