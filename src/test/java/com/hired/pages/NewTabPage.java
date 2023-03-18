package com.hired.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NewTabPage {
    public WebDriver driver;
    public NewTabPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@class='example']/a")
    public WebElement clickHere;

    @FindBy(tagName = "h3")
    public WebElement newWindowText;

    public void openNewTabAndVerifyText(String text)  {
        clickHere.click();
        for (String eachWindow : driver.getWindowHandles()) {
            driver.switchTo().window(eachWindow);
        }
        Assert.assertEquals(newWindowText.getText(), text);
    }
}
