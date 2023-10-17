package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.Environment;
import android.util.Xml;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.tool.CheckingHandler.CheckingHandlerDemo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private List<User> userLocalData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        userLocalData = LoadLocalUserInfo();
        EditText email_input = findViewById(R.id.email_input);
        EditText password_input = findViewById(R.id.password_input);

        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(view -> {
            String email = email_input.getText().toString();
            String password = password_input.getText().toString();
            //region FanYueL : i am  lazy to input
//            email = "comp2100@anu.edu.au";
//            password = "comp2100";
            //endreion
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Log in failed.", Toast.LENGTH_SHORT).show();
            } else {

                String checkingResult = CheckComplianceOfUserData(email, password);

                if (checkingResult.length() > 0) {
                    Toast.makeText(LoginActivity.this, "login  failed: " + checkingResult, Toast.LENGTH_SHORT).show();
                }

                boolean isLocallyCheckSuccessful = LocalCheckUserLoginInfo(email, password);
                if (!isLocallyCheckSuccessful) {
                    Toast.makeText(LoginActivity.this, "locally login  failed", Toast.LENGTH_SHORT).show();
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    // Log in success
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                                    intent.putExtra("username", user.getEmail().split("@")[0]);
                                    startActivity(intent);
                                } else {
                                    // Log in fails
                                    Toast.makeText(LoginActivity.this, "Invalid user and password.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        Button registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(view -> {
            String email = email_input.getText().toString();
            String password = password_input.getText().toString();

            String checkingResult = CheckComplianceOfUserData(email, password);

            if (checkingResult.length() > 0) {
                Toast.makeText(LoginActivity.this, "register  failed: " + checkingResult, Toast.LENGTH_SHORT).show();
            }
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                                intent.putExtra("username", user.getEmail().split("@")[0]);
                                startActivity(intent);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(LoginActivity.this, "Sign in failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        });
    }

    /**
     * check the user login info locally. ture for validation and false for fault login
     *
     * @param email
     * @param password
     * @return
     */
    private boolean LocalCheckUserLoginInfo(String email, String password) {
        for (User ou : userLocalData
        ) {
            if (ou.Password.equals(password) && ou.Username.equals(email)) return true;
        }
        return false;
    }

    /**
     * checking the format validation of email and password with the design pattern code
     *
     * @param email
     * @param password
     * @return
     */
    private String CheckComplianceOfUserData(String email, String password) {
        String res = CheckingHandlerDemo.exec(email, password);
        return res;
    }


    /**
     * load user passsword and username from local file
     *
     * @return
     */
    private List<User> LoadLocalUserInfo() {
        List<User> resultsList = new ArrayList<User>();
        User person = null;

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
        } catch (XmlPullParserException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
