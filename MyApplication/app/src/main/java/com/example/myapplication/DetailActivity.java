/**
 * DetailActivity.java implements the detail page for a single pet data,
 * to show the detailed information including photo, id, name, type, and etc.
 * Detailed comments please find in the code below.
 *
 * @author  Jiasheng Li (u7758372)
 */

package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Get the pet data selected by user from MainActivity
        Pet pet = (Pet) getIntent().getExtras().getSerializable("pet");

        // Load and show the text data in some TextView, including id, name, type, value, body type and color
        TextView id = findViewById(R.id.petId);

        id.setText("Pet ID: " + pet.id);

        TextView name = findViewById(R.id.petName);
        name.setText("Pet Name: " + pet.name);

        TextView type = findViewById(R.id.petType);
        type.setText(pet.type);

        TextView money = findViewById(R.id.petMoney);
        money.setText("$ "+pet.Money);

        TextView bodyType = findViewById(R.id.petBody);
        bodyType.setText("Body Type: " + pet.bodyType);

        TextView color = findViewById(R.id.petColor);
        color.setText("Color: " + pet.color);

        // Load and show the comments of the pet in a ListVew
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,pet.comment){
            @NonNull
            @Override
            // Edit the text color of comments to white.
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.WHITE);
                return view;
            }
        };
        ListView comment = findViewById(R.id.commentList);
        comment.setAdapter(adapter);

        // Load and show the corresponding photo of the pet in a ImageView
        ImageView imageView=findViewById(R.id.petPhoto);
        switch (pet.type){
            case "Mouse":
                imageView.setImageResource(R.drawable.mouse_one);
                break;
            case "Cow":
                imageView.setImageResource(R.drawable.cow_two);
                break;
            case "Tiger":
                imageView.setImageResource(R.drawable.tiger_three);
                break;
            case "Rabbit":
                imageView.setImageResource(R.drawable.rabbit_four);
                break;
            case "Cat":
                imageView.setImageResource(R.drawable.cat_five);
                break;
            case "Snake":
                imageView.setImageResource(R.drawable.snake_six);
                break;
            case "Horse":
                imageView.setImageResource(R.drawable.horse_seven);
                break;
            case "Sheep":
                imageView.setImageResource(R.drawable.sheep_eight);
                break;
            case "Monkey":
                imageView.setImageResource(R.drawable.monkey_nine);
                break;
            case "Chicken":
                imageView.setImageResource(R.drawable.chicken_ten);
                break;
            case "Dog":
                imageView.setImageResource(R.drawable.dog_eleven);
                break;
            case "Pig":
                imageView.setImageResource(R.drawable.pig_twelve);
                break;
        }
    }
}