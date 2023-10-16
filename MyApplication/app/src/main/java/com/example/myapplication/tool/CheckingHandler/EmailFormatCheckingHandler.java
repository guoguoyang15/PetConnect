package com.example.myapplication.tool.CheckingHandler;

import com.example.myapplication.Interface.AbstractCheckingHandler;

import java.util.regex.Pattern;

/**
 * @author 13521
 * @date 16/10/2023
 */
public class EmailFormatCheckingHandler extends AbstractCheckingHandler {
    @Override
    protected String doFilter(String username, String password) {

        patternStr = "^(\\w+([-.][A-Za-z0-9]+)*){3,18}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.][A-Za-z0-9]+)*$\n";
        boolean res = Pattern.matches(patternStr, username);
        if (res) resStr = "";
        else resStr = "the username should be a email";
        return resStr;

    }
}
