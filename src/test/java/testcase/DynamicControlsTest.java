package testcase;

import base.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.DynamicContentPage;
import pageobject.DynamicControlsPage;

public class DynamicControlsTest {

    private WebDriver driver;
    private DynamicControlsPage dynamicControlsPage;

    @BeforeClass
    public void setup() {
        driver = SingletonWebDriver.getInstanceOfSingletonBrowser().getDriver();
        this.dynamicControlsPage = new DynamicControlsPage(driver);
    }

    @AfterClass
    public void tearDown() {
        SingletonWebDriver.getInstanceOfSingletonBrowser().destroy();
    }

    @Test
    public void verifyActionsWithExplicitWait() {
        Assert.assertTrue(dynamicControlsPage.verifyRemoveButton());
        Assert.assertNotNull(dynamicControlsPage.verifyAddButton());

        Assert.assertNotNull(dynamicControlsPage.verifyEnableButton());
        Assert.assertNotNull(dynamicControlsPage.verifyDisableButton());

    }


}
