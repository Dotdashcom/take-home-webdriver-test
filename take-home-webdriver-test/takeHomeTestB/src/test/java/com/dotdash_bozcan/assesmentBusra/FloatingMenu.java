package com.dotdash_bozcan.assesmentBusra;
import com.dotdash_bozcan.utilities.ConfigurationReader;
import com.dotdash_bozcan.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FloatingMenu {
    @BeforeMethod
    public void setUpMethod() {

        Driver.get().get(ConfigurationReader.get("baseUrl") + "/floating_menu");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        Driver.closeDriver();
    }

    //Floating Menu: http://localhost:7080/floating_menu Test Floating Menu.
    @Test
    public void floatingMenuTest() throws InterruptedException {
        WebElement homeButton = Driver.get().findElement(By.cssSelector("a[href=\"#home\"]"));
        homeButton.click();
        String expHomeButtonText = "Home";
        String actHomeButtonText = homeButton.getText();

        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("window.scrollBy(0,250)", "");

        Thread.sleep(2000);

        WebElement newsButton = Driver.get().findElement(By.cssSelector("a[href=\"#news\"]"));
        newsButton.click();
        String expNewsButtonText = "News";
        String actNewsButtonText = newsButton.getText();

        js.executeScript("window.scrollBy(0,250)", "");

        Thread.sleep(2000);

        WebElement contactButton = Driver.get().findElement(By.cssSelector("a[href=\"#contact\"]"));
        contactButton.click();
        String expContactButtonText = "Contact";
        String actContactButtonText = contactButton.getText();

        js.executeScript("window.scrollBy(0,250)", "");

        Thread.sleep(2000);

        WebElement aboutButton = Driver.get().findElement(By.cssSelector("a[href=\"#about\"]"));
        aboutButton.click();
        String expAboutButtonText = "About";
        String actAboutButtonText = aboutButton.getText();

        js.executeScript("window.scrollBy(0,250)", "");

        Assert.assertEquals(expHomeButtonText,actHomeButtonText);
        Assert.assertEquals(expNewsButtonText,actNewsButtonText);
        Assert.assertEquals(expContactButtonText,actContactButtonText);
        Assert.assertEquals(expAboutButtonText,actAboutButtonText);
    }
}