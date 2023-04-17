package com.rural.rural.testcases;

import com.rural.rural.pages.CheckBoxesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class checkboxesTest {
    private WebDriver driver;
    private CheckBoxesPage checkBoxesPage;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:7080/checkboxes");

        checkBoxesPage = new CheckBoxesPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void checkBoxesTest() {
        checkBoxesPage.input.click();
        // verify that the checkbox is selected (checked)
        Assert.assertTrue(checkBoxesPage.input.isSelected(), "The checkbox is not selected.");
        checkBoxesPage.input.click();

        // verify that the checkbox is unselected (unchecked)
        Assert.assertFalse(checkBoxesPage.input.isSelected(), "The checkbox is not selected.");

        // close the browser
        driver.quit();

    }



}
