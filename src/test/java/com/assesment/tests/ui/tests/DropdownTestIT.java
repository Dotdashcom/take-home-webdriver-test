package com.assesment.tests.ui.tests;

import com.assesment.tests.ui.pages.DropdownPage;
import com.assesment.tests.ui.pages.HomePage;
import com.assesment.tests.ui.utilities.BasePageConf;
import com.assesment.tests.ui.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DropdownTestIT extends BasePageConf {

    private static final String CONTEXT_ALERT_MESSAGE = "You selected a context menu";

    private static final String DEFAULT_OPTION = "Please select an option";
    private static WebDriver driver;


    @BeforeMethod
    public void setup(){
        driver = super.navigateToBasePage();
    }

    @Test(priority = 0)
    public void selectedOptionIsTheVisibleOnThePage(){
        navigateToDropdownPage();
        DropdownPage dropdownPage = new DropdownPage(driver);
        String selectedOption = dropdownPage.selectRandomOption();
        assertEquals(selectedOption,dropdownPage.selectVisibleOption(),
                "Selected option is not visible on the page");
    }

    @Test(priority = 1)
    public void defaultOptionIsSelectedWhenPageIsOpenned(){
        navigateToDropdownPage();
        DropdownPage dropdownPage = new DropdownPage(driver);

        assertEquals(dropdownPage.selectVisibleOption(), DEFAULT_OPTION,
                "Default option is not selected.");
    }

    void navigateToDropdownPage(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnDropDownPage();
    }

    @AfterMethod
    void tearDown(){
        Driver.closeDriver();
    }
}
