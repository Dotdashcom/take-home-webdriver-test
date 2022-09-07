package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.DropDownPage;
import pages.utils;


public class DropDownTest {
    DropDownPage dropDownPage;

    public DropDownTest() {
        dropDownPage = new DropDownPage();
    }

    @Test
    public void dropDownTest() {
        WebDriver driver = TestBase.getInstance().getDriver();
        driver.get(utils.url + "/dropdown");

        String expectedOption1 = "Option 1";
        String expectedOption2 = "Option 2";

        String actualOption1 = dropDownPage.selectOption1();

        try {
            Assert.assertEquals(actualOption1, expectedOption1, " passed");
        } catch (AssertionError e) {
            System.out.println("failed");
            throw e;
        }
        String actualOption2 = dropDownPage.selectOption2();
        try {
            Assert.assertEquals(actualOption2, expectedOption2);
            System.out.println(actualOption2 + " passed");
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



