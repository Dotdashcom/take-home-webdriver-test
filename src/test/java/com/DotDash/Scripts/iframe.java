package com.DotDash.Scripts;

import com.DotDash.Pages.iframePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.DotDash.BasePage.basePage;
public class iframe extends basePage {
    String typedtxt = "Automation Testing!!";

    @Test
    public void iframe() {
        driver.get(baseURL + "/iframe");

        driver.switchTo().frame("mce_0_ifr");

        iframePage ifrmpg = new iframePage(driver);

        ifrmpg.txtcontentbox.clear();

        ifrmpg.setTxtcontentbox(typedtxt);

        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(ifrmpg.getenteredtxt(), typedtxt);


        assertion.assertAll();


    }
}
