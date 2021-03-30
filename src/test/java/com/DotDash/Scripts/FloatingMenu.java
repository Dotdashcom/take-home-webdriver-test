package com.DotDash.Scripts;

import com.DotDash.Pages.FloatingMenuPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.DotDash.BasePage.basePage;
public class FloatingMenu extends basePage {

    @Test
    public void floatingmenu() {
        driver.get(baseURL + "/floating_menu");

        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
        if (floatingMenuPage.chkfloatingmenu()) {
            System.out.println("Floating menu is displayed before Scrolling to the end of the page!!");
        } else {
            System.out.println("Floating menu NOT displayed!!");
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        SoftAssert assertion = new SoftAssert();
        assertion.assertTrue(floatingMenuPage.chkfloatingmenu());

        assertion.assertAll();
    }
}
