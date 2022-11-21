package com.tests.pages;

import com.tests.util.DriverTest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFramePage extends BasePage {


    @FindBy(id = "mce_0_ifr")
    private WebElement iframeInput;

    @FindBy(xpath = "//p")
    private WebElement textFieldInput;


    @BeforeClass
    public static void setUp() {
        DriverTest.getDriver().get("http://localhost:7080/iframe ");
    }


    @Test
    public void switchTheFrame() {
        DriverTest.getDriver().switchTo().frame(iframeInput);
        waitForVisibilityOf(textFieldInput);
        textFieldInput.clear();
        textFieldInput.sendKeys("Hello World!");
        String enteredText = textFieldInput.getText();
        Assert.assertTrue(enteredText.contains("Hello World"));
    }
}
