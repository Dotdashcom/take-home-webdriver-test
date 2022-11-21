package tests;

import Pages.WindowsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class WindowsTest {
    public String Url_windows="windows";
    WebDriver driverDotDash;
    WindowsPage windowsPage;
    @Before
    public void setUp() {
        windowsPage=new WindowsPage(driverDotDash);
        windowsPage.setChrome();
        windowsPage.setUrl(Url_windows);
    }

    @Test
    public void clickOnWindowNdAssert() {
        windowsPage.clickOnNewWindowLink();
    }

    @After
    public void tearDown() {
        windowsPage.closepreviousWind();
    }
}


