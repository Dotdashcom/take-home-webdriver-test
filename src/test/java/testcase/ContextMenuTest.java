package testcase;

import base.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.ContextMenuPage;

public class ContextMenuTest {

    private WebDriver driver;
    private ContextMenuPage contextMenuPage;

    @BeforeClass
    public void setup() {
        driver = SingletonWebDriver.getInstanceOfSingletonBrowser().getDriver();
        this.contextMenuPage = new ContextMenuPage(driver);
    }

    @AfterClass
    public void tearDown() {
        SingletonWebDriver.getInstanceOfSingletonBrowser().destroy();
    }

    @Test
    public void verifyAlertOnRightClick() {
        contextMenuPage.rightClickContextMenu();
        Assert.assertTrue(contextMenuPage.isDisplayAlert());

    }


}
