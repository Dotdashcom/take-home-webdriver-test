package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FloatingMenuPage;
import utilities.BrowserUtils;
import utilities.EndPoints;

public class FloatingMenu extends TestBase {


    @Test
    public void testFloatingMenu() {
        FloatingMenuPage fmp = new FloatingMenuPage();
        extentTest = extentReports.createTest("Floating Menu Test");
        fmp.navigateTo(EndPoints.FLOATINGMENU);
        extentTest.info("Navigate to Floating Menu Page");

        Assert.assertTrue(fmp.menu.isDisplayed());
        extentTest.info("On The Top of the Page Menu Bar is Visible");

        JavascriptExecutor jse = (JavascriptExecutor)fmp.driver;
        jse.executeScript("scroll(0,4650)");
        extentTest.info("Page is Scrolled");
        BrowserUtils.wait(3);
        extentTest.info("After Scrolling Menu Bar is still Visible");
        Assert.assertTrue(fmp.menu.isDisplayed());
        extentTest.pass("Testing Floating Menu is Successful");

    }
}
