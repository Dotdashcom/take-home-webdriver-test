package com.mitt.pages;

import com.mitt.core.BasePage;
import com.mitt.core.Log;
import com.mitt.core.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;

public class IFramePage extends BasePage {

    private final By frameContainer = By.xpath("//*[@id='tinymce']");

    public IFramePage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
        getDriver().get(PropertyFileReader.getInstance().getProperty("iframe_url"));
    }

    public void iframeVerification() throws InterruptedException {
        String text="Sample";
        getDriver().switchTo().frame("mce_0_ifr");
        findElement(frameContainer).clear();
        findElement(frameContainer).sendKeys(text);
        Assert.assertTrue(findElement(frameContainer).getText().equals(text));
    }
}
