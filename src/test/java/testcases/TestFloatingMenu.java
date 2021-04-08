package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.FloatingMenuPage;
import utils.ConfigReader;
import utils.Driver;

public class TestFloatingMenu {
    FloatingMenuPage floatingMenuPage = new FloatingMenuPage();

    @Before
    public void setUp() {
        String url = ConfigReader.readProperty("url") + "floating_menu";
        Driver.getDriver().get(url);
    }

    @Test
    public void testFloatingMenu()  {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Assert.assertTrue(floatingMenuPage.floatingMenu.isDisplayed());

    }
    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}
