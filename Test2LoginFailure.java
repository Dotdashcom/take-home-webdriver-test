package com.dotdash;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test2LoginFailure extends BaseMethod{
    private By usNmLoc = By.cssSelector("#username");
    private By pswLoc = By.cssSelector("#password");
    private By loginLoc = By.cssSelector("button[type='submit']");
    private By confMsg = By.cssSelector("div[id='content'] h2");

    @Test
    public void testLogin() throws InterruptedException {
        driver.get("http://localhost:7080/login");
        WebElement usNmElem = findByVisibility(usNmLoc);
        usNmElem.sendKeys("Atomsmith");

        WebElement pswElem = findByVisibility(pswLoc);
        pswElem.sendKeys("SuperSecretPassword!");
        //Thread.sleep(3000);

        WebElement loginElem = findByVisibility(loginLoc);
        loginElem.click();

        WebElement confMsgElem = findByVisibility(confMsg);
        String actualConfMsgText = confMsgElem.getText().trim();

        String expectedConfMsgText =  "Secure Area";
        Assert.assertEquals(expectedConfMsgText, actualConfMsgText);
        //Thread.sleep(3000);

    }
}