package testcase;

import base.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.HoverPage;
import pageobject.IFramePage;

import java.util.Arrays;
import java.util.List;

public class HoverTest {

    private WebDriver driver;
    private HoverPage hoverPage;
    private final static List<String> names = Arrays.asList("name: user1", "name: user2", "name: user3");

    @BeforeClass
    public void setup() {
        driver = SingletonWebDriver.getInstanceOfSingletonBrowser().getDriver();
        this.hoverPage = new HoverPage(driver);
    }

    @AfterClass
    public void tearDown() {
        SingletonWebDriver.getInstanceOfSingletonBrowser().destroy();
    }

    @Test
    public void verifyMouseHover() {
        Assert.assertTrue(hoverPage.verifyTextInAllImages(names));

    }


}
