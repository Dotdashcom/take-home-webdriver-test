package tests;

import Pages.IFramePage;
import Pages.Login_Page;
import org.bouncycastle.util.encoders.UrlBase64;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class IFrameTest {
    public String Url_iFrame= "iframe";
    WebDriver driverDotDash;
    IFramePage iFramePage;
    @Before
    public void setUp() {
        iFramePage=new IFramePage(driverDotDash);
        iFramePage.setChrome();
        iFramePage.setUrl(Url_iFrame);
    }

    @Test
    public void switchNdWrite() {
        iFramePage.waitIFrame();
        iFramePage.switchToFrameNdwrite();
        iFramePage.typeIntoTextBox();
        iFramePage.assertIFrame();
    }

    @After
    public void tearDown() {
        iFramePage.closeAllWindows();
    }
}
