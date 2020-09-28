package testcase;

import base.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.DynamicContentPage;

public class DynamicContentTest {

    private WebDriver driver;
    private DynamicContentPage dynamicContentPage;

    @BeforeClass
    public void setup() {
        driver = SingletonWebDriver.getInstanceOfSingletonBrowser().getDriver();
        this.dynamicContentPage = new DynamicContentPage(driver);
    }

    @AfterClass
    public void tearDown() {
        SingletonWebDriver.getInstanceOfSingletonBrowser().destroy();
    }

    @Test
    public void verifyValueChangeWhenRefreshPage() {

        Assert.assertTrue(dynamicContentPage.refreshAndVerifyAllContentChanged(3));

        Assert.assertTrue(dynamicContentPage.refreshAndVerifySomeContentChanged(2));

    }


}
