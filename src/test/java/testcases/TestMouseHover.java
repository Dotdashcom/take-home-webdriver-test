package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import pages.MouseHoverPage;
import utils.ConfigReader;
import utils.Driver;


public class TestMouseHover {
    MouseHoverPage mouseHoverPage = new MouseHoverPage();

    @Before
    public void setUp() {
        String url = ConfigReader.readProperty("url") + "hovers";
        Driver.getDriver().get(url);
    }

    @Test
    public void test() {
        for(int i = 0; i < mouseHoverPage.figures.size(); i++) {
            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(mouseHoverPage.figures.get(i)).perform();
            Assert.assertTrue(mouseHoverPage.user1.getText().contains("name: user1")
                    || mouseHoverPage.user2.getText().contains("name: user2")
            || mouseHoverPage.user3.getText().contains("name: user3"));
        }
    }

    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}
