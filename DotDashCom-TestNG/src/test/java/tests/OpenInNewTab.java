package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.OpenInNewTabPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class OpenInNewTab {
    OpenInNewTabPage openInNewTabPage = new OpenInNewTabPage();

    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl")+"windows");

        openInNewTabPage.clickHere.click();
        List<String> browserTabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(browserTabs .get(1));
        String expectedText = "New Window";
        Assert.assertEquals(expectedText,openInNewTabPage.text.getText());

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();

    }

}
