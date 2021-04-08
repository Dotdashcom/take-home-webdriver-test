package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.DynamicContentPage;
import utils.ConfigReader;
import utils.Driver;


public class TestDynamicContent {
    DynamicContentPage dynamicContentPage = new DynamicContentPage();

    @Before
    public void setUp() {
        String url = ConfigReader.readProperty("url") + "dynamic_content";
        Driver.getDriver().get(url);
    }

    @Test
    public void test() {
    for(int i = 0; i < dynamicContentPage.paragraphs.size(); i++) {
        String text = dynamicContentPage.paragraphs.get(i).getText();
        Driver.getDriver().navigate().refresh();
        String textAfterRefresh = dynamicContentPage.paragraphs.get(i).getText();
        Assert.assertFalse(text.equals(textAfterRefresh));
    }


    }
    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}
