package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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
        id.setText("Pet ID: " + pet.id);
        TextView name = findViewById(R.id.petName);
        name.setText("Pet Name: " + pet.name);
        TextView type = findViewById(R.id.petType);
        type.setText("Pet Type: " + pet.type);
        TextView money = findViewById(R.id.petMoney);
        money.setText("Pet Value: $" + pet.Money);
        TextView bodyType = findViewById(R.id.petBody);
        bodyType.setText("Pet Body Type: " + pet.bodyType);
        TextView color = findViewById(R.id.petColor);
        color.setText("Pet Color: " + pet.color);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,pet.comment){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.WHITE);
                return view;
            }
        };
        ListView comment = findViewById(R.id.commentList);
        comment.setAdapter(adapter);
    }
}