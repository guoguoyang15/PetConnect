package com.example.myapplication.tool.CheckingHandler;

import com.example.myapplication.Interface.AbstractCheckingHandler;

import java.util.regex.Pattern;

/**
  * @description checking the length of password
  * @param 
  * @return 
  * @author u7568823 FanYue
  * @time 19/10/2023
  */
public class PasswordLengthCheckingHandler extends AbstractCheckingHandler {
    @Override
    protected String doFilter(String username, String password) {


        boolean res = password.length() >= 6;
        if (res) resStr = "";
        else
            resStr = "the password length  should be at least 6";

        return resStr;

    }
}
