package com.example.myapplication.tool.CheckingHandler;

import com.example.myapplication.Interface.AbstractCheckingHandler;
import com.google.firebase.database.snapshot.StringNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @param
 * @author u7568823 FanYue
 * @description chaking the format validation of username and password
 * @return
 * @time 19/10/2023
 */
public class CheckingHandlerDemo {
    /**
      * @description a list of checking handler
      * @param 
      * @return 
      * @author u7568823 FanYue
      * @time 19/10/2023
      */
    private static List<AbstractCheckingHandler> handlerList;
    private static AbstractCheckingHandler handler;


    /**
     * @param
     * @return the checking result
     * @description execute the checking the method
     * @author u7568823 FanYue
     * @time 19/10/2023
     */
    public static String exec(String username, String password) {
        initializeChainFilter();
        String res = handler.filter(username, password);
        return res;
    }
/**
  * @description initialize the handler
  * @param 
  * @return 
  * @author u7568823 FanYue
  * @time 19/10/2023
  */
    private static void initializeChainFilter() {
        handlerList = new ArrayList<>();
        handlerList.add(new EmailFormatCheckingHandler());
        handlerList.add(new PasswordLengthCheckingHandler());
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
}
