package tests;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;
import utils.Driver;
import utils.TestBase;

import java.util.concurrent.TimeUnit;

public class DynamicLoadingTests extends TestBase {

    String url="dynamic_loading";
    WebDriverWait wait;
    DynamicLoadingPage dynamicLoadingPage=new DynamicLoadingPage();

    @Test
    public void helloWorld(){
        Driver.setUp(url);
        dynamicLoadingPage.example1.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        dynamicLoadingPage.start.click();
        wait=new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.visibilityOf(dynamicLoadingPage.helloWorld));
        Assert.assertEquals(dynamicLoadingPage.helloWorld.getText(),"Hello World!");
        Driver.setUp(url);
        dynamicLoadingPage.example2.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        dynamicLoadingPage.start.click();
        wait=new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.visibilityOf(dynamicLoadingPage.helloWorld));
        Assert.assertEquals(dynamicLoadingPage.helloWorld.getText(),"Hello World!");

    }
}
