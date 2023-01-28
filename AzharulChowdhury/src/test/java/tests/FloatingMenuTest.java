package tests;

import Utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FloatingMenuTest {

    @BeforeTest
    public void setup(){
        Driver.setupDriver();
        Driver.getDriver().navigate().to("http://localhost:7080/floating_menu");
    }

    @Test
    public void floatingMenu() {
        Boolean cond = Driver.getDriver().findElement(By.cssSelector("#menu")).isDisplayed();
        Assert.assertEquals(true, cond);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 1000)", "");
        Boolean scrollCond = Driver.getDriver().findElement(By.cssSelector("#menu")).isDisplayed();
        Assert.assertEquals(scrollCond, true);
    }

    @AfterTest
    public void done() {
        Driver.getDriver().quit();
    }

}
