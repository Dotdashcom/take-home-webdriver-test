package com.test.qa.pages;

import com.test.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class mainPages extends TestBase {


    @FindBy(id =  "username")
    WebElement username;

    @FindBy(id =  "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;

    @FindBy(id = "flash")
    WebElement errMsg;

    @FindBy (xpath = "//h4[contains(text(),'Welcome to the Secure Area. When you are done clic')]")
    WebElement confirmMsg;

    public mainPages() {
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void validLogin() {

        username.sendKeys(prop.getProperty("userName"));
        password.sendKeys(prop.getProperty("password"));
        submit.click();

        String successMsg = confirmMsg.getText();

        Assert.assertEquals(successMsg, "Welcome to the Secure Area. When you are done click logout below.");
    }

    public void invallidLogin() {

        username.sendKeys(prop.getProperty("invalidUserName"));
        password.sendKeys(prop.getProperty("invalidPassword"));
        submit.click();

        String error = errMsg.getText();
        System.out.println(error);
        if (error.contains("Your username is invalid!")) {
            Assert.assertTrue(true);
        } else
            Assert.assertTrue(false);



    }







}
