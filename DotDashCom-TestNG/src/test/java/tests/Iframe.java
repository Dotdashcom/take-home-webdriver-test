package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.IframePage;
import utilities.ConfigReader;
import utilities.Driver;

public class Iframe {
    IframePage iframePage = new IframePage();
    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl")+"iframe");
        Driver.getDriver().switchTo().frame(iframePage.iFrame);
        String expectedText = "Your content goes here.";
        String actualText = iframePage.inputArea.getText();
        Assert.assertEquals(actualText,expectedText);
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
