package Tests;

import Baseclass.BaseClass;
import Pages.IframePage;
import org.testng.annotations.Test;

public class TestsIframe extends BaseClass {

    @Test
    public void T015_Iframe_Testing() {
        IframePage iframe_page = new IframePage(driver);
        iframe_page.GoToIframeMenu();
        iframe_page.WriteOnIframe();
        iframe_page.AssertFloatingMenuExistence();



    }

}
