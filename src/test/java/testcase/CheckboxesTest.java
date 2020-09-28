package testcase;

import base.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.CheckboxPage;
import pageobject.LoginPage;

public class CheckboxesTest {

    private WebDriver driver;
    private CheckboxPage checkboxPage;

    @BeforeClass
    public void setup() {
        driver = SingletonWebDriver.getInstanceOfSingletonBrowser().getDriver();
        this.checkboxPage = new CheckboxPage(driver);
    }

    @AfterClass
    public void tearDown() {
        SingletonWebDriver.getInstanceOfSingletonBrowser().destroy();
    }

    @Test
    public void loginSuccessfully() {
        //check checkbox
        checkboxPage.checkCheckBox(" checkbox 1");
        Assert.assertTrue(checkboxPage.isCheck());
        //uncheck checkbox
        checkboxPage.checkCheckBox(" checkbox 1");
        Assert.assertTrue(checkboxPage.isNotCheck());
    }


}
