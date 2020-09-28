package testcase;

import base.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.DynamicControlsPage;
import pageobject.DynamicLoadingPage;

public class DynamicLoadingTest {

    private WebDriver driver;
    private DynamicLoadingPage dynamicLoadingPage;

    @BeforeClass
    public void setup() {
        driver = SingletonWebDriver.getInstanceOfSingletonBrowser().getDriver();
        this.dynamicLoadingPage = new DynamicLoadingPage(driver);
    }

    @AfterClass
    public void tearDown() {
        SingletonWebDriver.getInstanceOfSingletonBrowser().destroy();
    }

    @Test
    public void verifyActionsWithExplicitWait() {
        Assert.assertTrue(dynamicLoadingPage.verifyHelloWorldDisplay());

    }


}
