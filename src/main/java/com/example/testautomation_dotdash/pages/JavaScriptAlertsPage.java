package com.example.testautomation_dotdash.pages;

import com.example.testautomation_dotdash.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.testautomation_dotdash.base.BaseTest.prop;

public class JavaScriptAlertsPage extends BasePage {

    public JavaScriptAlertsPage(WebDriver driver){
        super(driver);
        driver.get(prop.getProperty("baseurl") + "/javascript_alerts");
    }


    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    private WebElement clickForJSAlertBtn;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    private WebElement clickForJSConfirmBtn;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    private WebElement clickForJSPromptBtn;


    public void clickJSAlertBtn(){

        clickForJSAlertBtn.click();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("I am a JS Alert", alert.getText());

        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals("You successfuly clicked an alert", result.getText());

    }


    public void clickJSConfirmBtn(){

        clickForJSConfirmBtn.click();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("I am a JS Confirm", alert.getText());

        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals("You clicked: Ok", result.getText());

    }

    public void clickJSPromptBtn(){

        clickForJSPromptBtn.click();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("I am a JS prompt", alert.getText());

        alert.sendKeys("Dotdash Automation Exam");
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals("You entered: Dotdash Automation Exam", result.getText());

    }







}
