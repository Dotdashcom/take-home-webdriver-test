package com.project.pom.test;

import com.project.pom.page.CheckBoxes;
import com.project.pom.page.Login;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class CheckBoxesTest {

    private WebDriver driver;
    CheckBoxes checkBoxes;

    @Before
    public void setUp(){
        checkBoxes = new CheckBoxes(driver);
        driver = checkBoxes.chromeDriverConnection();
        checkBoxes.visit("/checkboxes");
    }

    @Test
    public void checkBoxes(){
        assertFalse(checkBoxes.checkBoxOne());
        assertTrue(checkBoxes.checkBoxTwo());
        checkBoxes.clickOnCheckBoxes();
        assertTrue(checkBoxes.checkBoxOne());
        assertFalse(checkBoxes.checkBoxTwo());
    }

    @After
    public void end(){
        driver.quit();
    }
}
