package com.example.myapplication.tool;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.widget.Toast;

import com.example.myapplication.AVLTree.AVLTree;
import com.example.myapplication.LoginActivity;
import com.example.myapplication.tool.CheckingHandler.CheckingHandlerDemo;

import org.junit.Test;

/**
 * @param
 * @author u7568823 FanYue
 * @description test the format-validation-method of username and password
 * @return
 * @time 19/10/2023
 */
public class unitTest {
    @Test(timeout = 1000)
    public void emailFormatErrorTest() {

        String username = "123#123.com";
        String password = "123433dd";
        String checkingRes = CheckingHandlerDemo.exec(username, password);
        String expected = "";
        assertFalse("\nFailed!  \n expected : " + expected + "\n but we got : " + checkingRes, checkingRes.equals(""));
    }

    @Test(timeout = 1000)
    public void emailFormatTest() {

        String username = "123@gg3.com";
        String password = "123ddr4f";
        String checkingRes = CheckingHandlerDemo.exec(username, password);
        String expected = "";
        assertTrue("\nFailed!  \n expected : " + expected + "\n but we got : " + checkingRes, checkingRes.equals(""));
    }

    @Test(timeout = 1000)
    public void emailFormatTest2() {

        String username = "123@123.com";
        String password = "123433dd";
        String checkingRes = CheckingHandlerDemo.exec(username, password);
        String expected = "";
        assertTrue("\nFailed!  \n expected : " + expected + "\n but we got : " + checkingRes, checkingRes.equals(expected));
    }

    @Test(timeout = 1000)
    public void passwordFormatErrorTest() {

        String username = "123@123.com";
        String password = "123456";
        String checkingRes = CheckingHandlerDemo.exec(username, password);
        String expected = "";
        assertFalse("\nFailed!  \n expected : " + expected + "\n but we got : " + checkingRes, checkingRes.equals(expected));
    }
    @Test(timeout = 1000)
    public void passwordFormatTest() {

        String username = "123@123.com";
        String password = "123456aa";
        String checkingRes = CheckingHandlerDemo.exec(username, password);
        String expected = "";
        assertTrue("\nFailed!  \n expected : " + expected + "\n but we got : " + checkingRes, checkingRes.equals(expected));
    }

    @Test(timeout = 1000)
    public void passwordLengthErrorTest() {

        String username = "123@123.com";
        String password = "1aa";
        String checkingRes = CheckingHandlerDemo.exec(username, password);
        String expected = "";
        assertFalse("\nFailed!  \n expected : " + expected + "\n but we got : " + checkingRes, checkingRes.equals(expected));
    }
}

