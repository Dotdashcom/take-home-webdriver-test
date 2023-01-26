package com.test.qa.pages;

import com.test.qa.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class javaScript extends TestBase{


    @FindBy(xpath = "//button[contains(text(),'Click for JS Alert')]")
    WebElement jsAlertButton;

    @FindBy(xpath = "//button[contains(text(),'Click for JS Confirm')]")
    WebElement jsConfirmButton;

    @FindBy (xpath = "//button[contains(text(),'Click for JS Prompt')]")
    WebElement jsPromptButton;

    @FindBy (id= "result")
    WebElement jsEnteredText;


    public javaScript() {
        PageFactory.initElements(driver, this);
    }

    public void script() {

        jsAlertButton.click();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();

        //click JS confirm Button and clicks ok on alert.
        jsConfirmButton.click();
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");
        alert.accept();
        //clicks on JS Prompt Button and types a message on Prompt.
        jsPromptButton.click();
        String typeMessage="To verify we are on JS prompt";
        alert.sendKeys(typeMessage);
        alert.accept();
        Assert.assertEquals((jsEnteredText).getText(), "You entered: "+typeMessage);
    }
}

