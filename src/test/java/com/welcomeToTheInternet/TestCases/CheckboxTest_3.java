package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.CheckboxPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class CheckboxTest_3 extends BaseClass{

    @Test
    public void CheckboxTest() throws IOException {
        driver.get(baseURL);
        CheckboxPage checkbox = new CheckboxPage(driver);

        checkbox.clickCheckboxLink();
        checkbox.clickCheckbox1();
        checkbox.clickCheckbox2();

        boolean isCheckbox1Checked = driver.getPageSource().contains("checked");
        if (isCheckbox1Checked) {
            Assert.assertTrue(true);
        } else {
            captureScreen(driver, "Failed enabling checkbox1");
            Assert.fail();
        }

        boolean isCheckbox2Checked = driver.getPageSource().contains(" ");
        if (isCheckbox2Checked) {
            Assert.assertTrue(true);
        } else {
            captureScreen(driver, "Failed disabling checkbox2");
            Assert.fail();
        }
    }
}
