package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.FloatingMenuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class FloatingMenu {
    FloatingMenuPage floatingMenuPage = new FloatingMenuPage();
    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl")+"floating_menu");
        Assert.assertTrue(floatingMenuPage.menu.isDisplayed());
        JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
        jse.executeScript("scroll(0,4650)");
        Assert.assertTrue(floatingMenuPage.menu.isDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
