package com.hired.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class IframePage {
    public WebDriver driver;
    public IframePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="tinymce")
    public WebElement textField;

    @FindBy(xpath = "//div[@aria-label='Close']//*[name()='svg']")
    public WebElement closeAlertBtn;

    @FindBy(xpath = "//iframe[@id='mce_0_ifr']")
    public WebElement iFrameBox;

    public void switchToiFrameAndType(String text)  {
        WebDriverWait wait =new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(closeAlertBtn));
        closeAlertBtn.click();
        driver.switchTo().frame(iFrameBox);
        textField.clear();
        textField.sendKeys(text);
        Assert.assertTrue((textField.getText()).equals(text));
    }
}
