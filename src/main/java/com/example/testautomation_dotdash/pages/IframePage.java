package com.example.testautomation_dotdash.pages;

import com.example.testautomation_dotdash.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.testautomation_dotdash.base.BaseTest.prop;

public class IframePage extends BasePage {

    public IframePage(WebDriver driver){

        super(driver);
        driver.get(prop.getProperty("baseurl") + "/iframe");
    }

    @FindBy(id = "mce_0_ifr")
    private WebElement iframe;

    public void typeInTheIframe(String message){

        driver.switchTo().frame(iframe);

        WebElement inputField = driver.findElement(By.id("tinymce"));

        inputField.clear();
        inputField.sendKeys(message);

        Assert.assertEquals(message, inputField.getText());

    }


}
