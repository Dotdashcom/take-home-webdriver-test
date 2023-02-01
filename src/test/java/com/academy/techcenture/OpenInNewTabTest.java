package com.academy.techcenture;

import com.academy.techcenture.pages.OpenInNewTabPage;
import org.testng.annotations.Test;

public class OpenInNewTabTest extends BaseClassTest {

    @Test
    public void openInNewTab() {
        OpenInNewTabPage openInNewTabPage = new OpenInNewTabPage(driver, softAssert);
        openInNewTabPage.navigateTo("/windows");
        openInNewTabPage.openInNewTab();
    }
}
