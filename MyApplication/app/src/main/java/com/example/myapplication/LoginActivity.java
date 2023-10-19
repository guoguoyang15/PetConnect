package com.example.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.tool.CheckingHandler.CheckingHandlerDemo;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private List<User> userLocalData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize the Firebase Authentication instance
        mAuth = FirebaseAuth.getInstance();
        // Load local user information
        userLocalData = LoadLocalUserInfo();
        // Initialize UI component
        EditText email_input = findViewById(R.id.email_input);
        EditText password_input = findViewById(R.id.password_input);
        Button loginButton = findViewById(R.id.login_button);
        Button registerButton = findViewById(R.id.register_button);

        // Login process
        loginButton.setOnClickListener(view -> {
            String email = email_input.getText().toString();
            String password = password_input.getText().toString();
            login(email,password);
        });

        // Register process
        registerButton.setOnClickListener(view -> {
            String email = email_input.getText().toString();
            String password = password_input.getText().toString();
            register(email, password);
        });
    }

    /**
     * Method to login by:
     * 1) Firebase Authentication if network is available,
     * 2) Local user information if (1) fails.
     * <p>
     * Method check if:
     * 1) Input is empty,
     * 2) Input is in right format.
     * Display the corresponding result messages by Toast if login fails.
     * @param email    This is the email string that user inputs.
     * @param password This is the password string that user inputs.
     *
     * @author Jiasheng Li (u7758372)
     */
    protected void login(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            // Check if input is empty
            Toast.makeText(this, "Please enter email or password.", Toast.LENGTH_SHORT).show();
        } else if (CheckComplianceOfUserData(email, password).length() > 0) {
            // Check if input is in right format
            Toast.makeText(this, "Login Failed: " + CheckComplianceOfUserData(email, password), Toast.LENGTH_SHORT).show();
        } else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {
                if (task.isSuccessful()) {
                    // Login success by Firebase Authentication
                    FirebaseUser user = mAuth.getCurrentUser();
                    Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                    intent.putExtra("username", user.getEmail().split("@")[0]);
                    startActivity(intent);
                } else {
                    // Login failure by Firebase Authentication
                    if (LocalCheckUserLoginInfo(email, password)) {
                        // Login success by local user information
                        Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                        intent.putExtra("username", email.split("@")[0]);
                        startActivity(intent);
                    } else {
                        // Login failure by local user information
                        Toast.makeText(LoginActivity.this, "Invalid user and password.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    /**
     * Method to sign up by Firebase Authentication if network is available.
     * Method check if:
     * 1) Input is empty,
     * 2) Input is in right format.
     * Display the corresponding result messages by Toast if login fails.
     * @param email    This is the email string that user inputs.
     * @param password This is the password string that user inputs.
     *
     * @author Jiasheng Li (u7758372)
     */
    protected void register(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            // Check if input is empty
            Toast.makeText(this, "Please enter email or password.", Toast.LENGTH_SHORT).show();
        } else if (CheckComplianceOfUserData(email, password).length() > 0) {
            // Check if input is in right format
            Toast.makeText(this, "Register Failed: " + CheckComplianceOfUserData(email, password), Toast.LENGTH_SHORT).show();
        } else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {
                if (task.isSuccessful()) {
                    // Sign up success by Firebase Authentication
                    FirebaseUser user = mAuth.getCurrentUser();
                    Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                    intent.putExtra("username", user.getEmail().split("@")[0]);
                    startActivity(intent);
                } else {
                    // Sign up failure by Firebase Authentication
                    Toast.makeText(LoginActivity.this, "Sign up failed.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    /**
     * check the user login info locally. true for validation and false for fault login
     *
     * @author u7568823 FanYue
     * @time 19/10/2023
     */
    private boolean LocalCheckUserLoginInfo(String email, String password) {
        for (User ou : userLocalData
        ) {
            if (ou.Password.equals(password) && ou.Username.equals(email)) return true;
        }
        return false;
    }

    /**
      * @description checking the format validation of email and password with the design pattern code
      * @param password and email
      * @return string of checking info
      * @author u7568823 FanYue
      * @time 19/10/2023
      */
    private String CheckComplianceOfUserData(String email, String password) {
        return CheckingHandlerDemo.exec(email, password);
    }


   /**
     * @description load user password and username from local file
     * @author u7568823 FanYue
     * @time 19/10/2023
     */
    private List<User> LoadLocalUserInfo() {
        List<User> resultsList = new ArrayList<>();
        User person;

        Resources resources = getResources();
        XmlResourceParser xrParser = resources.getXml(R.xml.userdata);

        try {
            while (xrParser.getEventType() != XmlResourceParser.END_DOCUMENT) {
                if (xrParser.getEventType() == XmlResourceParser.START_TAG) {
                    String name = xrParser.getName();
                    if (name.equals("User")) {
                        person = new User();
                        person.Username = xrParser.getAttributeValue(null, "Username");
                        person.Password = xrParser.getAttributeValue(null, "Password");
                        resultsList.add(person);
                    }
                }
                xrParser.next();
            }
            return resultsList;
        } catch (XmlPullParserException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
