package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class DynamicLoading {
    DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
    @Test
    public void test() {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl") + "dynamic_loading/2");
        ReusableMethods.waitForPageToLoad(3);

        dynamicLoadingPage.startButton.click();
       //Wait until visible
        ReusableMethods.waitForVisibility(dynamicLoadingPage.finishText,10);
        Assert.assertTrue(dynamicLoadingPage.finishText.isDisplayed());

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
