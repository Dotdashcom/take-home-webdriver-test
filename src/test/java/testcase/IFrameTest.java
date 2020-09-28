package testcase;

import base.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.DropdownPage;
import pageobject.IFramePage;

public class IFrameTest {

    private WebDriver driver;
    private IFramePage iFramePage;
    private static final String text = "Hello Selenium";

    @BeforeClass
    public void setup() {
        driver = SingletonWebDriver.getInstanceOfSingletonBrowser().getDriver();
        this.iFramePage = new IFramePage(driver);
    }

    @AfterClass
    public void tearDown() {
        SingletonWebDriver.getInstanceOfSingletonBrowser().destroy();
    }

    @Test
    public void verifyIFrame() {
        iFramePage.typeATextInIFrame(text);
        Assert.assertTrue(iFramePage.verifyTextInIFrame(text));

    }


}
