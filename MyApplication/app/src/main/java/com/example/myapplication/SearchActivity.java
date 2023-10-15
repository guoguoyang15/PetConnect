package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

public class SearchActivity extends AppCompatActivity {


    private EditText searchInput;
    String selectedColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        String[] colors = {"color", "red", "blue", "green", "yellow"};
        String[] money = {"5~10", "10~100", "100~200", "200~500","500~1000"};
        NoFilterAdapter colorAdapter = new NoFilterAdapter(this, android.R.layout.simple_dropdown_item_1line, colors);
        NoFilterAdapter moneyAdapter = new NoFilterAdapter(this, android.R.layout.simple_dropdown_item_1line, money);
        AutoCompleteTextView colorTextView = (AutoCompleteTextView) findViewById(R.id.petColor);
        AutoCompleteTextView moneyTextView = (AutoCompleteTextView) findViewById(R.id.petMoney);
        colorTextView.setAdapter(colorAdapter);
        moneyTextView.setAdapter(moneyAdapter);

        // 这里加上监听器
        colorTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedColor = (String) parent.getItemAtPosition(position);
                // TODO: Handle the selected color
                // 例如，您可以将选中的颜色设置为textView的文本
                colorTextView.setText(selectedColor);
                colorTextView.setThreshold(0);
            }
        });
        moneyTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedMoney = (String) parent.getItemAtPosition(position);
                // TODO: Handle the selected money
                moneyTextView.setText(selectedMoney);
                moneyTextView.setThreshold(0);
            }
        });
        colorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorTextView.showDropDown();
            }
        });
        moneyTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moneyTextView.showDropDown();
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