package com.assesment.tests.ui.tests;

import com.assesment.tests.ui.pages.HomePage;
import com.assesment.tests.ui.pages.OpenNewTabPage;
import com.assesment.tests.ui.utilities.BasePageConf;
import com.assesment.tests.ui.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class OpenNewTabTestIT extends BasePageConf {

    private static WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = super.navigateToBasePage();
    }
    @Test
    public static void verifyNewTabCanBeOpened(){
        /**
         * Navigate to HomePage to click on Multiple Windows link
         */
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMultipleWindowsLink();

        /**
         * Click on 'Click Here' link to open a new tab
         */
        OpenNewTabPage openNewTabPage = new OpenNewTabPage(driver);
        openNewTabPage.clickNewTabLink();

        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        while (iterator.hasNext()){
            String childWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                String header = driver.findElement(By.cssSelector("h3")).getText();
                /**
                 * assert that can be switched to the new tab by checking the header of new tab
                 */
                assertTrue(header.equalsIgnoreCase("New Window"));
            }
        }
    }
    @AfterMethod
    void tearDown() {
        Driver.closeDriver();
    }
}
