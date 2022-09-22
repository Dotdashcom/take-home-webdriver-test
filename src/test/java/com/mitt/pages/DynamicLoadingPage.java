package com.mitt.pages;

import com.mitt.core.BasePage;
import com.mitt.core.Log;
import com.mitt.core.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class DynamicLoadingPage extends BasePage {

    private final By startButton_xpath = By.xpath("//*[@id='start']/button");
    private final By text_xpath = By.xpath("//*[@id='finish']");
    WebDriverWait wait=new WebDriverWait(driver,30);

    public DynamicLoadingPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        getDriver().get(PropertyFileReader.getInstance().getProperty("dynamic_loading_url"));
    }

    public void dynamicContentLoadingVerification(){

        findElement(startButton_xpath).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(text_xpath));
        Assert.assertTrue(findElement(text_xpath).getText().equals("Hello World!"));
        Log.info("Hello World! displayed Successfully");

    }
}
