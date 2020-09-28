package testcase;

import base.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.ContextMenuPage;
import pageobject.DragAndDropPage;

public class DragAndDropTest {

    private WebDriver driver;
    private DragAndDropPage dragAndDropPage;

    @BeforeClass
    public void setup() {
        driver = SingletonWebDriver.getInstanceOfSingletonBrowser().getDriver();
        this.dragAndDropPage = new DragAndDropPage(driver);
    }

    @AfterClass
    public void tearDown() {
        SingletonWebDriver.getInstanceOfSingletonBrowser().destroy();
    }

    @Test
    public void dragAndDrop() {
        dragAndDropPage.dragAndDropAToB();
        Assert.assertTrue(dragAndDropPage.verifyTextSwitched());

    }


}
