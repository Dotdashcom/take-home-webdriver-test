package com.hired.tests;

import com.hired.pages.BasePage;
import com.hired.pages.ContextPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ContextTest extends BasePage {
    public WebDriver driver;
    ContextPage contextPage;

    @BeforeMethod
    public void setup() {
        driver= getDriver();
        driver.get(prop.getProperty("contextUrl"));
    }

    @Test
    public void contextMenuValidation(){

        contextPage= new ContextPage(driver);
        Actions actions = new Actions(driver);
        actions.contextClick(contextPage.context).perform();
        Assert.assertEquals(driver.switchTo().alert().getText(), "You selected a context menu");
        driver.switchTo().alert().accept();

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
