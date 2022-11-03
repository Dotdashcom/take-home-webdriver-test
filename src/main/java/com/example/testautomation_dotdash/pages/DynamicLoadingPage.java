package com.example.testautomation_dotdash.pages;

import com.example.testautomation_dotdash.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.example.testautomation_dotdash.base.BaseTest.prop;

public class DynamicLoadingPage extends BasePage {

    public DynamicLoadingPage(WebDriver driver){

        super(driver);
        driver.get(prop.getProperty("baseurl") + "/dynamic_loading/2");
    }

    @FindBy(css = "div[id='start'] button")
    private WebElement startBtn;


    public void clickStartButton(){
        startBtn.click();
    }

    public void assertLoadingFinished(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        WebElement text = driver.findElement(By.id("finish"));

        Assert.assertEquals("Hello World!", text.getText());
    }



}
