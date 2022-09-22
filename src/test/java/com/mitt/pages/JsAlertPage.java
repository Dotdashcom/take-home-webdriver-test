package com.mitt.pages;

import com.mitt.core.BasePage;
import com.mitt.core.Log;
import com.mitt.core.PropertyFileReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JsAlertPage extends BasePage {

    private final By alert1 = By.xpath("//*[@id='content']/div/ul/li[1]/button");
    private final By alert2 = By.xpath("//*[@id='content']/div/ul/li[2]/button");
    private final By alert3 = By.xpath("//*[@id='content']/div/ul/li[3]/button");

    private final By alert3Text = By.xpath("//*[@id='result']");


    public JsAlertPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        getDriver().get(PropertyFileReader.getInstance().getProperty("javaScript_alerts_url"));
    }

    public void alertVerification() throws InterruptedException {

        findElement(alert1).click();
        Alert alert = getDriver().switchTo().alert();
        Assert.assertTrue(alert.getText().equals("I am a JS Alert"));
        alert.accept();

        findElement(alert2).click();
        Alert alert1 = getDriver().switchTo().alert();
        Assert.assertTrue(alert1.getText().equals("I am a JS Confirm"));
        alert.accept();

        String text="Sample";
        findElement(alert3).click();
        Alert alert2 = getDriver().switchTo().alert();
        alert2.sendKeys(text);
        alert.accept();
        Assert.assertTrue(getDriver().findElement(alert3Text).getText().contains(text));
    }
}
