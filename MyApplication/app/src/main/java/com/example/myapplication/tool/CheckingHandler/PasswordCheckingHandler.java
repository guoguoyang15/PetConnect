package com.example.myapplication.tool.CheckingHandler;

import com.example.myapplication.Interface.AbstractCheckingHandler;

import java.util.regex.Pattern;

/**
 * @author 13521
 * @date 16/10/2023
 */
public class PasswordCheckingHandler extends AbstractCheckingHandler {
    @Override
    protected String doFilter(String username, String password) {

        patternStr = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
        boolean res = Pattern.matches(patternStr, username);
        if (res) resStr = "";
        else
            resStr = "the password length  should be at least 6 and the password should contain digitals and letters";

        return resStr;

    }
}
