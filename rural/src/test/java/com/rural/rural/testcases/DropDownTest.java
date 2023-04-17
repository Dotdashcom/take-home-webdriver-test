package com.rural.rural.testcases;

import com.rural.rural.pages.DropDownPage;
import com.rural.rural.SeleniumTools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;

public class DropDownTest {
    private WebDriver driver;
    private DropDownPage dropDownPage;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:7080/dropdown");

        dropDownPage = new DropDownPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void DropDownTest() {

        SeleniumTools st = new SeleniumTools();


        st.selectFromListForVisibleText(dropDownPage.selectDropdown, "Option 1");
        st.selectFromListForVisibleText(dropDownPage.selectDropdown, "Option 2");

        // close the browser
        driver.quit();

    }



}
