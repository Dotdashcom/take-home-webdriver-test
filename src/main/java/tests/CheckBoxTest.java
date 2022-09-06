package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.CheckboxPage;
import pages.utils;


public class CheckBoxTest {
    CheckboxPage checkboxPage;

    public CheckBoxTest() {
        checkboxPage = new CheckboxPage();
    }

    @Test
    public void checkBoxTest() {
        WebDriver driver = TestBase.getInstance().getDriver();
        driver.get(utils.url + "/checkboxes");
        WebElement cb1 = checkboxPage.selectCheckbox();

        try {
            Assert.assertTrue(cb1.isSelected());
            System.out.println("passed");
        } catch (AssertionError e) {
            System.out.println("failed");
            throw e;
        }

        WebElement cb2 = checkboxPage.unselectCheckbox();

        try {
            Assert.assertFalse(cb2.isSelected());
            System.out.println("passed");
        } catch (AssertionError e) {
            System.out.println("failed");
            throw e;
        }
    }

    @AfterTest
    public void teardown() {
        TestBase.getInstance().getDriver().quit();
    }
}



