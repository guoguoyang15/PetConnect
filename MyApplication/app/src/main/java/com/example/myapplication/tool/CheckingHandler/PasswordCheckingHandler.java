package com.example.myapplication.tool.CheckingHandler;

import com.example.myapplication.Interface.AbstractCheckingHandler;

import java.util.regex.Pattern;

/**
  * @description checking the formate of password
  * @param 
  * @return 
  * @author u7568823 FanYue
  * @time 19/10/2023
  */
public class PasswordCheckingHandler extends AbstractCheckingHandler {
    @Override
    protected String doFilter(String username, String password) {

        patternStr = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$";
        boolean res = Pattern.matches(patternStr, password);
        if (res) resStr = "";
        else
            resStr = "the password should contain digitals and letters";

        return resStr;

    }
}
