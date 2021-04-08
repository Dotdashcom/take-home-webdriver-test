package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.DynamicLoadingPage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;

public class TestDynamicLoading {
    DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();

    @Before
    public void setUp() {
        String url = ConfigReader.readProperty("url") + "dynamic_loading";
        Driver.getDriver().get(url);
    }

    @Test
    public void testExample1() {
        dynamicLoadingPage.example1.click();
        dynamicLoadingPage.startBtn.click();
        BrowserUtils.waitForVisibility(dynamicLoadingPage.HelloWorld);
        Assert.assertEquals("Hello World!", dynamicLoadingPage.HelloWorld.getText());
    }
        @Test
        public void testExample2() {
            dynamicLoadingPage.example2.click();
            dynamicLoadingPage.startBtn.click();
            BrowserUtils.waitForVisibility(dynamicLoadingPage.HelloWorld);
            Assert.assertEquals("Hello World!", dynamicLoadingPage.HelloWorld.getText());

    }
    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}


