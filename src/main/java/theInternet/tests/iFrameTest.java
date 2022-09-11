package theInternet.tests;

import org.testng.annotations.Test;
import theInternet.pages.iFrame;

public class iFrameTest extends TestBase {

    @Test
    public void iframeTest(){

        iFrame iframe = new iFrame(driver);
        iframe.iFramePractice(driver);
    }
}
