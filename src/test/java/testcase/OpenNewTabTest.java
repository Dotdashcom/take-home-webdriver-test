package testcase;

import base.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.JavascriptErrorPage;
import pageobject.OpenNewTabPage;

public class OpenNewTabTest {


    private WebDriver driver;
    private OpenNewTabPage openNewTabPage;


    @BeforeClass
    public void setup() {
        driver = SingletonWebDriver.getInstanceOfSingletonBrowser().getDriver();
        this.openNewTabPage = new OpenNewTabPage(driver);
    }

    @AfterClass
    public void tearDown() {
        SingletonWebDriver.getInstanceOfSingletonBrowser().destroy();
    }

    @Test
    public void verifyJavaScriptAlerts() {
        Assert.assertTrue(openNewTabPage.verifyOpenNewTab());

    }


}
