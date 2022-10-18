package com.example.testautomation_dotdash.pages;

import com.example.testautomation_dotdash.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void assertLoadingFinished() throws InterruptedException{
        Thread.sleep(7000);
        WebElement text = driver.findElement(By.id("finish"));

        Assert.assertEquals("Hello World!", text.getText());
    }



}
