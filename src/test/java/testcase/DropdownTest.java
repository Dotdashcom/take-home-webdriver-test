package testcase;

import base.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.CheckboxPage;
import pageobject.DropdownPage;

public class DropdownTest {

    private WebDriver driver;
    private DropdownPage dropdownPage;

    @BeforeClass
    public void setup() {
        driver = SingletonWebDriver.getInstanceOfSingletonBrowser().getDriver();
        this.dropdownPage = new DropdownPage(driver);
    }

    @AfterClass
    public void tearDown() {
        SingletonWebDriver.getInstanceOfSingletonBrowser().destroy();
    }

    @Test
    public void dropdownTest() {
        String value = "Option 1";
        dropdownPage.selectDropDownByNameDisplay(value);
        Assert.assertTrue(dropdownPage.verifyDropdownSelectedByNameDisplay(value));

        value = "Option 2";
        dropdownPage.selectDropDownByNameDisplay(value);
        Assert.assertTrue(dropdownPage.verifyDropdownSelectedByNameDisplay(value));

        value = "1";
        dropdownPage.selectDropDownByValue(value);
        Assert.assertTrue(dropdownPage.verifyDropdownSelectedByValue(value));

        value = "2";
        dropdownPage.selectDropDownByValue(value);
        Assert.assertTrue(dropdownPage.verifyDropdownSelectedByValue(value));

    }


}
