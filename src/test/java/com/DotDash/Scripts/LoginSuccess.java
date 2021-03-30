package com.DotDash.Scripts;

import com.DotDash.BasePage.basePage;
import com.DotDash.Pages.LoginPage;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginSuccess extends basePage {

    @Test
    public void logintest()
    {

        driver.get(baseURL+"/login");

        SoftAssert assertion = new SoftAssert();

        assertion.assertEquals(driver.getTitle(),"The Internet","Right url opened!!");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setTxtusername(username);
        loginPage.setTxtpassword(password);
        loginPage.clkbtnLogin();


        assertion.assertEquals(loginPage.txtmsgLogin(),"You logged into a secure area!\n" +
                "×","Login Successful!!");

        assertion.assertAll();



    }

}