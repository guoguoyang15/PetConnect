package com.example.myapplication.Interface;

/**
 * @author 13521
 * @date 16/10/2023
 */
public abstract class AbstractCheckingHandler {
    private AbstractCheckingHandler nextHandler;
    protected String patternStr;
    protected String resStr = "";

    public void setNextHandler(AbstractCheckingHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public AbstractCheckingHandler getNextHandler() {
        return nextHandler;
    }

    public String filter(String username, String password) {
        resStr = doFilter(username, password);
        if (resStr.length() == 0 && getNextHandler() != null)
            return getNextHandler().filter(username, password);

        return resStr;
    }

    protected abstract String doFilter(String username, String password);
}

