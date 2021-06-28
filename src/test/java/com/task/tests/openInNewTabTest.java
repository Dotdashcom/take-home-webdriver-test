package com.task.tests;

import com.task.pages.openInNewTabPage;
import com.task.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class openInNewTabTest {

    openInNewTabPage openInNewTabPage = new openInNewTabPage();

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://localhost:7080/windows");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().close();
    }

    @Test
    public void openInNewTab() throws InterruptedException {

        Thread.sleep(2000);
        openInNewTabPage.clickHere.click();

        Thread.sleep(2000);

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();

        for (String each : windowHandles) {
            Driver.getDriver().switchTo().window(each);
            if (Driver.getDriver().getCurrentUrl().contains("new")){
                Assert.assertTrue( Driver.getDriver().getTitle().contains("New Window") );
                break;
            }

        }

    }




}
