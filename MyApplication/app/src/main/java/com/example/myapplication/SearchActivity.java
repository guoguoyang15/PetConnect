package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.slider.RangeSlider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {


    private EditText searchInput;
    String selectedColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        String[] colors = {"Red", "Orange", "Green", "Blue", "Purple","Yellow","White","Black"};
        String[] petBodyType = {"Large","Medium","Small"};
        NoFilterAdapter colorAdapter = new NoFilterAdapter(this, android.R.layout.simple_dropdown_item_1line, colors);
        NoFilterAdapter bodyTypeAdapter = new NoFilterAdapter(this, android.R.layout.simple_dropdown_item_1line, petBodyType);
        AutoCompleteTextView colorTextView = (AutoCompleteTextView) findViewById(R.id.petColor);
        AutoCompleteTextView bodyTypeTextView = (AutoCompleteTextView) findViewById(R.id.petBodyType);
        colorTextView.setAdapter(colorAdapter);
        bodyTypeTextView.setAdapter(bodyTypeAdapter);
        RangeSlider rangeSlider = findViewById(R.id.rangeSlider);
        rangeSlider.setValueFrom(1.0f);
        rangeSlider.setValueTo(10000.0f);
        List<Float> initialValues = new ArrayList<>();
        initialValues.add(10000.0f);
        rangeSlider.setValues(initialValues);

        TextView budgetTextView = findViewById(R.id.budgetTextView);

        rangeSlider.addOnChangeListener(new RangeSlider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull RangeSlider slider, float value, boolean fromUser) {
                // Get the current value of the slider
                List<Float> values = slider.getValues();

                // Update the TextView's text
                budgetTextView.setText(String.format("Your budget is AUD %.0f", values.get(0)));
            }
        });

        colorTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedColor = (String) parent.getItemAtPosition(position);
                colorTextView.setText(selectedColor);
                colorTextView.setThreshold(0);
            }
        });
        bodyTypeTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedBodyType = (String) parent.getItemAtPosition(position);
                // TODO: Handle the selected money
                bodyTypeTextView.setText(selectedBodyType);
                bodyTypeTextView.setThreshold(0);
            }
        });
        colorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorTextView.showDropDown();
            }
        });
        bodyTypeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bodyTypeTextView.showDropDown();
            }
        });

        TextView greetings = findViewById(R.id.greetings);
        String username = getIntent().getStringExtra("username");
        StringBuilder buffer = new StringBuilder();
        buffer.append("Hello, ").append(username).append("!");
        greetings.setText(buffer.toString());

        searchInput = findViewById(R.id.editTextText);
        Button buttonSearch = findViewById(R.id.button);
        buttonSearch.setOnClickListener(view -> {
            String query = searchInput.getText().toString();
            if (selectedColor != null) { query = query+";color="+selectedColor; }
            selectedColor = null;

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("query",query);
            startActivityForResult(intent,123);
        });

        ImageView mouseImageView = findViewById(R.id.img_1);
        mouseImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInput.setText("type=mouse");
            }
        });
        ImageView cowImageView = findViewById(R.id.img_2);
        cowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInput.setText("type=cow");
            }
        });
        ImageView tigerImageView = findViewById(R.id.img_3);
        tigerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInput.setText("type=tiger");
            }
        });
        ImageView rabbitImageView = findViewById(R.id.img_4);
        rabbitImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInput.setText("type=rabbit");
            }
        });
        ImageView catImageView = findViewById(R.id.img_5);
        catImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInput.setText("type=cat");
            }
        });
        ImageView snakeImageView = findViewById(R.id.img_6);
        snakeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInput.setText("type=snake");
            }
        });
        ImageView horseImageView = findViewById(R.id.img_7);
        horseImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInput.setText("type=horse");
            }
        });
        ImageView sheepImageView = findViewById(R.id.img_8);
        sheepImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInput.setText("type=sheep");
            }
        });

        ImageView monkeyImageView = findViewById(R.id.img_9);
        monkeyImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInput.setText("type=monkey");
            }
        });

        ImageView chickenImageView = findViewById(R.id.img_10);
        chickenImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInput.setText("type=chicken");
            }
        });

        ImageView dogImageView = findViewById(R.id.img_11);
        dogImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInput.setText("type=dog");
            }
        });

        ImageView pigImageView = findViewById(R.id.img_12);
        pigImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInput.setText("type=pig");
            }
        });
    }
    // 这是我们新定义的适配器类
    public static class NoFilterAdapter extends ArrayAdapter<String> {

        private String[] originalData;

        public NoFilterAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.originalData = objects; // 保存原始数据
        }

        @NonNull
        @Override
        public Filter getFilter() {
            return new NoFilter();
        }

        private class NoFilter extends Filter {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                results.values = originalData; // 使用原始数据
                results.count = originalData.length;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results.count > 0) {
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        }
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