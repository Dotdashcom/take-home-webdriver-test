package testcase;

import base.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.FloatingMenuPage;
import pageobject.UploadPage;

public class FloatingMenuTest {

    private WebDriver driver;
    private FloatingMenuPage floatingMenuPage;

    @BeforeMethod
    public void setup() {
        driver = SingletonWebDriver.getInstanceOfSingletonBrowser().getDriver();
        this.floatingMenuPage = new FloatingMenuPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        SingletonWebDriver.getInstanceOfSingletonBrowser().destroy();
    }

    @Test
    public void uploadTest() {
        Assert.assertTrue(floatingMenuPage.verifyFLoatingMenuStillDisplayedWhenScroll());
    }




}
