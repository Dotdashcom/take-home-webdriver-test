package com.automation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class IframePage extends BasePage {

    @FindBy(xpath = "//a[@href='/frames']")
    WebElement firstLink;

    @FindBy(xpath = "//a[@href='/iframe']")
    WebElement secondLink;

    @FindBy(xpath = "//button[@type='button']//div[@aria-label='Close']")
    WebElement button;

    @FindBy(id = "mce_0_ifr")
    WebElement iframe;

    @FindBy(id = "tinymce")
    WebElement text;

    public void clickOnLink() {
        firstLink.click();
        secondLink.click();
    }

    public void writeIntoIframe() {
        button.click();
        driver.switchTo().frame(iframe);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.sendKeys("I wrote this text").perform();
        Assert.assertTrue(text.getText().contains("I wrote this text"));
    }
}
