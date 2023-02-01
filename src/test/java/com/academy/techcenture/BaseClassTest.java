package com.academy.techcenture;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import static com.academy.techcenture.driver.Driver.*;

public class BaseClassTest {

    protected WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeMethod
    public void setUp(){
        driver = getDriver();
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
        softAssert.assertAll();
    }
}
