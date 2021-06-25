package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OpenNewTabPage;
import utilities.BrowserUtils;
import utilities.EndPoints;
import java.util.Set;

public class OpenNewTab extends TestBase {

    @Test
    public void testOpenNewTab() {
        OpenNewTabPage ont = new OpenNewTabPage();
        extentTest = extentReports.createTest("Open New Tab Test");
        ont.navigateTo(EndPoints.NEWTAB);
        extentTest.info("Navigate to Open New Tab Page");

        ont.clickHere.click();
        extentTest.info("'Click Here' Link is Clicked in the First Tab");
        String firstTab = ont.driver.getWindowHandle();
        BrowserUtils.wait(2);

        Set<String> windowHandles = ont.driver.getWindowHandles();
        extentTest.info("Opened Tabs are Ordered");

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(firstTab)) {
                ont.driver.switchTo().window(windowHandle);
            }
        }
        extentTest.info("New Tab is Chosen from Ordered Tabs");

        Assert.assertEquals(ont.text.getText(), "New Window");
        extentTest.info("New Tab's text is verified");
        extentTest.pass("Test of OpenNewTab is Successful");



    }
}
