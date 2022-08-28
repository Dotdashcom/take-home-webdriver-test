package com.project.pom.test;

import com.project.pom.page.DropDownList;
import com.project.pom.page.Login;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DropDownListTest {

    private WebDriver driver;
    DropDownList dropDownList;

    @Before
    public void setUp(){
        dropDownList = new DropDownList(driver);
        driver = dropDownList.chromeDriverConnection();
        dropDownList.visit("/dropdown");
    }

    @Test
    public void DropDownTest(){
        dropDownList.selectOption("2");
        assertTrue(dropDownList.validateOption("2"));
        dropDownList.selectOption("3");
        assertTrue(dropDownList.validateOption("3"));
    }

    @After
    public void end(){ driver.quit(); }
}
