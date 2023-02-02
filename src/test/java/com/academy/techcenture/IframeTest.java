package com.academy.techcenture;

import com.academy.techcenture.pages.IframePage;
import org.testng.annotations.Test;

public class IframeTest extends BaseClassTest {

    @Test
    public void iframeTest() {
        IframePage iframePage = new IframePage(driver,softAssert);
        iframePage.navigateTo("/iframe");
        iframePage.verifyIframe();
    }

}
