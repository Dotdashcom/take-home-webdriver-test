package com.DotDash.Scripts;

import com.DotDash.BasePage.basePage;
import com.DotDash.Pages.OpenWindowPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;

public class OpenWindow extends basePage {

    @Test
    public void openWindow() {
        driver.get(baseURL + "/windows");

        OpenWindowPage openWindowPage = new OpenWindowPage(driver);

        openWindowPage.setBtnClickhere();

        Set<String> handles = driver.getWindowHandles();

        SoftAssert assertion = new SoftAssert();
        for (String handle : handles) {
            String title = driver.switchTo().window(handle).getTitle();

            if (title.equals("New Window")) {
                assertion.assertEquals(openWindowPage.gettxtNewWindow(), true);
            }
            assertion.assertAll();


        }
    }
}
