package com.example.myapplication.tool.CheckingHandler;

import com.example.myapplication.Interface.AbstractCheckingHandler;
import com.google.firebase.database.snapshot.StringNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 13521
 * @date 16/10/2023
 */
public class CheckingHandlerDemo {
    private static List<AbstractCheckingHandler> handlerList;
    private static AbstractCheckingHandler handler;

    private static void initializeChainFilter() {
        handlerList = new ArrayList<>();
        handlerList.add(new EmailFormatCheckingHandler());
        handlerList.add(new PasswordCheckingHandler());
        for (int i = 0; i < handlerList.size(); i++) {
            if (i == 0) handler = handlerList.get(0);
            else {
                AbstractCheckingHandler crtHandler = handlerList.get(i - 1);
                AbstractCheckingHandler nextHandler = handlerList.get(i);
                crtHandler.setNextHandler(nextHandler);
            }
        }
    }

    public static String exec(String username, String password) {
        initializeChainFilter();
        String res = handler.filter(username, password);
        return res;
    }
}
