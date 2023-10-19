package com.example.myapplication.Interface;


/**
  * @description handler to check the password and username
  * @param
  * @return
  * @author u7568823 FanYue
  * @time 16/10/2023
  */
public abstract class AbstractCheckingHandler {
    /**
      * @description the nexthandler to check the format
      * @param 
      * @return 
      * @author u7568823 FanYue
      * @time 19/10/2023
      */
    private AbstractCheckingHandler nextHandler;
    /**
      * @description the regex string to check the format of username and password
      * @param 
      * @return 
      * @author u7568823 FanYue
      * @time 19/10/2023
      */
    protected String patternStr;
    /**
      * @description the checking result
      * @param 
      * @return 
      * @author u7568823 FanYue
      * @time 19/10/2023
      */
    protected String resStr = "";

    public void setNextHandler(AbstractCheckingHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public AbstractCheckingHandler getNextHandler() {
        return nextHandler;
    }

    /**
      * @description checking the username and password, proceed to call the next handler
      * @param 
      * @return 
      * @author u7568823 FanYue
      * @time 19/10/2023
      */
    public String filter(String username, String password) {
        resStr = doFilter(username, password);
        if (resStr.length() == 0 && getNextHandler() != null)
            return getNextHandler().filter(username, password);

        return resStr;
    }
/**
  * @description the method to validate the password or username in detail
  * @param 
  * @return 
  * @author u7568823 FanYue
  * @time 18/10/2023
  */
    protected abstract String doFilter(String username, String password);
}

