package com.rural.rural.testcases;

import com.google.common.base.Verify;
import com.rural.rural.pages.DynamicContentPage;
import com.rural.rural.pages.DynamicControlsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicControlsTest {
    private WebDriver driver;
    private DynamicControlsPage dynamicControlsPage;



    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:7080/dynamic_controls");

        dynamicControlsPage = new DynamicControlsPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void DynamicControls() {

        //Verify A CheckBox is Present
        Assert.assertTrue(dynamicControlsPage.inputCheckBox.isDisplayed(),"the checkbox is not displayed");
        //remove the checkbox
        dynamicControlsPage.buttonRemoveCheckBox.click();

        // Wait until the element is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.pMessage));

        //Verify A CheckBox is gone
        Assert.assertTrue(dynamicControlsPage.pMessage.getText().equals("It's gone!"),"the checkbox is still displayed");

        //Verify A input text is disabled
        Assert.assertFalse(dynamicControlsPage.inputTxt.isEnabled(),"the textBox is enabled");
        //click btn to enable input text field
        dynamicControlsPage.buttonEnableText.click();
        //Verify A input text is enabled
        // Wait until the element is enabled

        wait.until(ExpectedConditions.elementToBeClickable(dynamicControlsPage.inputTxt));

        Assert.assertTrue(dynamicControlsPage.inputTxt.isEnabled(),"the textBox is disabled");
        // close the browser
        driver.quit();

    }



}
