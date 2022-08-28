package com.project.pom.test;

import com.project.pom.page.Login;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class LoginTestFail {

    private WebDriver driver;
    Login login;

    @Before
    public void setUp(){
        login = new Login(driver);
        driver = login.chromeDriverConnection();
        login.visit("/login");
    }

    @Test
    public void loginTestFail(){
        login.failLogin();
        assertEquals( Boolean.TRUE, login.registerFail());
    }

    @After
    public void end(){
        driver.quit();
    }
}
