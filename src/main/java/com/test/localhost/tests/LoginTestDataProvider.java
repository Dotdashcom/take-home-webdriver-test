package com.test.localhost.tests;

import org.testng.annotations.DataProvider;

public class LoginTestDataProvider {
    @DataProvider(name = "fullLogin")
    public Object[][]loginData(){
        return new Object[][]{
                {"TOMSMITH","SuperSecretPassword!","Your username is invalid!\n" +
                        "×"},
                {"TomSmith","1234567","Your username is invalid!\n" +
                        "×"},
                {"","SuperSecretPassword!","Your username is invalid!\n" +
                        "×"},
                {"tomsmith","","Your password is invalid!\n" +
                        "×"},
                {"","","Your username is invalid!\n" +
                        "×"},
                {"111111","SUPERSECRETPASSWORD!","Your username is invalid!\n" +
                        "×"},
                {"^%$tom","super6848464","Your username is invalid!\n" +
                        "×"},
        };
    }

}
