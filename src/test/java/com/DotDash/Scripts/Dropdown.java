package com.DotDash.Scripts;

import com.DotDash.Pages.DropdownPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.DotDash.BasePage.basePage;
public class Dropdown extends basePage {

    @Test
    public void dropdown() throws InterruptedException {
        driver.get(baseURL + "/dropdown");

        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.clkdrpdown();

        SoftAssert assertion = new SoftAssert();
        dropdownPage.selOption1();
        assertion.assertTrue(dropdownPage.getOptionselected().contains("Option 1"));
        driver.navigate().refresh();

        Thread.sleep(2000);

        dropdownPage.selOption2();
        assertion.assertTrue(dropdownPage.getOptionselected().contains("Option 2"));

        assertion.assertAll();


    }
}
