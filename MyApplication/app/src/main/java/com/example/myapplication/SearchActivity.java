package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.slider.RangeSlider;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    String selectedColor;
    String selectedBodyType;
    Float selectedBudget;
    private EditText searchInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        setUI();
        putToSearch();
    }

    /**
     * Method to put the query to MainActivity for search,
     * when the search button is clicked.
     *
     * @author Jiasheng Li (u7758372)
     */
    public void putToSearch() {
        Button buttonSearch = findViewById(R.id.button);
        buttonSearch.setOnClickListener(view -> {
            String query = constructQuery();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("query", query);
            startActivityForResult(intent, 123);
        });
    }

    /**
     * Method to combine:
     * 1) search input in EditText
     * 2) options in AutoCompleteTextView
     *
     * @return String query
     * @author Jiasheng Li (u7758372)
     */
    public String constructQuery() {
        String query = searchInput.getText().toString();
        // Combine color option
        if (selectedColor != null && !selectedColor.isEmpty()) {
            if (query.isEmpty())
                query = query + "color=" + selectedColor;
            else query = query + ";color=" + selectedColor;
        }
        // Combine body type option
        if (selectedBodyType != null && !selectedBodyType.isEmpty()) {
            if (query.isEmpty())
                query = query + "bodytype=" + selectedBodyType;
            else query = query + ";bodytype=" + selectedBodyType;
        }
        // Combine budget value
        if (selectedBudget != null && selectedBudget != 10000.0f) {
            if (query.isEmpty())
                query = query + String.format("money<%.0f", selectedBudget);
            else query = query + String.format(";money<%.0f", selectedBudget);
        }
        return query;
    }

    /**
     * Method to receive the last query return from MainActivity.
     * Remove the tokens, that can be selected in SearchActivity, in the query.
     * Notice that it may be different from the one which user input in SearchActivity.
     * The purpose is to improve user experience.
     *
     * @author Jiasheng Li (u7758372)
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String tokens = "(color\\s*=|bodytype\\s*=|money\\s*=|money\\s*<|money\\s*>)";
        if (data != null) {
            // Get the last query from MainActivity
            String query = data.getStringExtra("query");
            if (query != null) {
                if (query.matches("^\\s*" + tokens + ".*;")) {
                    // Remove the token at first
                    query = query.replaceAll("^\\s*" + tokens + ".*;", "");
                } else if (query.matches(";\\s*" + tokens + ".*;")) {
                    // Remove the token at middle
                    query = query.replaceAll("\\s*" + tokens + ".*;", "");
                } else {
                    // Remove the token at last
                    query = query.replaceAll("\\s*" + tokens + ".*$", "");
                }
            }
            while (query != null && query.endsWith(";")) {
                // Remove semicolon at last that may cause error
                query = query.substring(0, query.length() - 1);
            }
            // Update the query in EditTextView
            searchInput.setText(query);
        }
    }

    /**
     * Set up the user interface and event handling logic.
     * <p>
     * This method initializes the user interface components, including text views, sliders, auto-complete text fields, and handles related event logic.
     *
     * @author Zhining Zhang
     */
    private void setUI() {
        // Find and initialize the search input field
        searchInput = findViewById(R.id.editTextText);

        // Get the username passed in and display it in a welcome text view
        TextView greetings = findViewById(R.id.greetings);
        String username = getIntent().getStringExtra("username");
        greetings.setText("Hello, " + username + "!");

        // Initialize auto-complete text fields for color and pet body type, and their adapters
        String[] colors = {"", "Red", "Orange", "Green", "Blue", "Purple", "Yellow", "White", "Black"};
        String[] petBodyType = {"", "Large", "Medium", "Small"};
        NoFilterAdapter colorAdapter = new NoFilterAdapter(this, android.R.layout.simple_dropdown_item_1line, colors);
        NoFilterAdapter bodyTypeAdapter = new NoFilterAdapter(this, android.R.layout.simple_dropdown_item_1line, petBodyType);
        AutoCompleteTextView colorTextView = findViewById(R.id.petColor);
        AutoCompleteTextView bodyTypeTextView = findViewById(R.id.petBodyType);
        colorTextView.setAdapter(colorAdapter);
        bodyTypeTextView.setAdapter(bodyTypeAdapter);

        // Initialize the range slider and set default values
        RangeSlider rangeSlider = findViewById(R.id.rangeSlider);
        rangeSlider.setValueFrom(1.0f);
        rangeSlider.setValueTo(10000.0f);
        List<Float> initialValues = new ArrayList<>();
        initialValues.add(10000.0f);
        rangeSlider.setValues(initialValues);

        // Initialize the budget text view
        TextView budgetTextView = findViewById(R.id.budgetTextView);

        // Add a change listener to the range slider to update the budget text
        rangeSlider.addOnChangeListener((slider, value, fromUser) -> {
            // Get the current value of the slider
            List<Float> values = slider.getValues();

            // Update the text view's text
            selectedBudget = values.get(0);
            budgetTextView.setText(String.format("Your budget is AUD %.0f", values.get(0)));
        });

        // Handle item click events for the color text view
        colorTextView.setOnItemClickListener((parent, view, position, id) -> {
            selectedColor = (String) parent.getItemAtPosition(position);
            colorTextView.setText(selectedColor);
            colorTextView.setThreshold(0);
        });

        // Handle item click events for the pet body type text view
        bodyTypeTextView.setOnItemClickListener((parent, view, position, id) -> {
            selectedBodyType = (String) parent.getItemAtPosition(position);
            // TODO: Handle the selected pet body type
            bodyTypeTextView.setText(selectedBodyType);
            bodyTypeTextView.setThreshold(0);
        });

        // Show the drop-down menu when clicking on the color and body type text views
        colorTextView.setOnClickListener(v -> colorTextView.showDropDown());
        bodyTypeTextView.setOnClickListener(v -> bodyTypeTextView.showDropDown());

        // Initialize image views for different animals and set click listeners
        ImageView mouseImageView = findViewById(R.id.img_1);
        mouseImageView.setOnClickListener(v -> searchInput.setText("type=mouse"));
        ImageView cowImageView = findViewById(R.id.img_2);
        cowImageView.setOnClickListener(v -> searchInput.setText("type=cow"));
        ImageView tigerImageView = findViewById(R.id.img_3);
        tigerImageView.setOnClickListener(v -> searchInput.setText("type=tiger"));
        ImageView rabbitImageView = findViewById(R.id.img_4);
        rabbitImageView.setOnClickListener(v -> searchInput.setText("type=rabbit"));
        ImageView catImageView = findViewById(R.id.img_5);
        catImageView.setOnClickListener(v -> searchInput.setText("type=cat"));
        ImageView snakeImageView = findViewById(R.id.img_6);
        snakeImageView.setOnClickListener(v -> searchInput.setText("type=snake"));
        ImageView horseImageView = findViewById(R.id.img_7);
        horseImageView.setOnClickListener(v -> searchInput.setText("type=horse"));
        ImageView sheepImageView = findViewById(R.id.img_8);
        sheepImageView.setOnClickListener(v -> searchInput.setText("type=sheep"));
        ImageView monkeyImageView = findViewById(R.id.img_9);
        monkeyImageView.setOnClickListener(v -> searchInput.setText("type=monkey"));
        ImageView chickenImageView = findViewById(R.id.img_10);
        chickenImageView.setOnClickListener(v -> searchInput.setText("type=chicken"));
        ImageView dogImageView = findViewById(R.id.img_11);
        dogImageView.setOnClickListener(v -> searchInput.setText("type=dog"));
        ImageView pigImageView = findViewById(R.id.img_12);
        pigImageView.setOnClickListener(v -> searchInput.setText("type=pig"));
    }


    /**
     * Custom ArrayAdapter with no filtering.
     * <p>
     * This class extends ArrayAdapter and provides a custom adapter that does not perform any filtering on the data.
     *
     * @author Zhining Zhang
     */
    public static class NoFilterAdapter extends ArrayAdapter<String> {

        private String[] originalData;

        public NoFilterAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.originalData = objects; // Store the original data
        }

        @NonNull
        @Override
        public Filter getFilter() {
            return new NoFilter();
        }

        /**
         * Custom filter that returns the original data unfiltered.
         */
        private class NoFilter extends Filter {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                results.values = originalData; // Set the original data as results
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

}
