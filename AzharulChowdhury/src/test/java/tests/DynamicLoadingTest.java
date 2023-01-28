package tests;

import Utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicLoadingTest {

    private WebDriverWait wait;

    @BeforeTest
    public void setup(){
        Driver.setupDriver();
        wait = new WebDriverWait(Driver.getDriver(), 10);

        Driver.getDriver().navigate().to("http://localhost:7080/dynamic_loading/2");
}

    @Test
    public void dynamicLoading() {
        Driver.getDriver().findElement(By.cssSelector("#start > button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        Assert.assertEquals(Driver.getDriver().findElement(By.id("finish")).getText(), "Hello World!");
    }

    @AfterTest
    public void done() {
        Driver.getDriver().quit();
    }
}
