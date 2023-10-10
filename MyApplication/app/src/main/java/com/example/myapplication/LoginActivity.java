package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText email_imput = findViewById(R.id.email_input);
        EditText password_imput = findViewById(R.id.password_input);

        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(view -> {
            String email = email_imput.getText().toString();
            String password = password_imput.getText().toString();

            if ((email.equals("comp2100@anu.edu.au") && password.equals("comp2100")) || (email.equals("comp6442@anu.edu.au") && password.equals("comp6442"))) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
