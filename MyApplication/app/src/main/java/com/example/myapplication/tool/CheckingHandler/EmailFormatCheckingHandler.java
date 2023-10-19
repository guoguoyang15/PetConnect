package com.example.myapplication.tool.CheckingHandler;

import com.example.myapplication.Interface.AbstractCheckingHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @param
 * @author u7568823 FanYue
 * @description validate the format of email
 * @return
 * @time 18/10/2023
 */
public class EmailFormatCheckingHandler extends AbstractCheckingHandler {
    @Override
    protected String doFilter(String username, String password) {

//        patternStr = "\\w+@[a-zA-Z0-9]+?\\.[a-zA-Z]{2,3}\\.[a-zA-Z]{2,3}";
        patternStr = "\\w+@[a-zA-Z0-9]+?\\.[.|a-zA-Z0-9]+";
        Pattern pattern = Pattern.compile(patternStr);

        Matcher matcher = pattern.matcher(username);

        boolean res = matcher.matches();
        if (res) resStr = "";
        else resStr = "the username should be a email";
        return resStr;

    }
}
