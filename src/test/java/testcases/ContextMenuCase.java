package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import pages.ContextMenuPage;
import utils.ConfigReader;
import utils.Driver;

public class ContextMenuCase {

    ContextMenuPage contextMenuPage = new ContextMenuPage();

    @Before
    public void setUp() {
        String url = ConfigReader.readProperty("url") + "context_menu";
        Driver.getDriver().get(url);
    }

    @Test
    public void testContextMenu() {
        Actions action = new Actions(Driver.getDriver());
        action.contextClick(contextMenuPage.box).perform();
        String alert = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu", alert);

    }
    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}
