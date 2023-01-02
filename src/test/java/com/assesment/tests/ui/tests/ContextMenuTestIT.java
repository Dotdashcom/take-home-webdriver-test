package com.assesment.tests.ui.tests;

import com.assesment.tests.ui.pages.ContextMenuPage;
import com.assesment.tests.ui.pages.HomePage;
import com.assesment.tests.ui.utilities.BasePageConf;
import com.assesment.tests.ui.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTestIT extends BasePageConf {

    private static final String CONTEXT_ALERT_MESSAGE = "You selected a context menu";

    private static WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = super.navigateToBasePage();
    }

    @Test
    public void runTest(){
        navigateToContextMenuPage();
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.rightClickOnTextBox();

        Alert alert =  driver.switchTo().alert();
        assertEquals(alert.getText(), CONTEXT_ALERT_MESSAGE);

        alert.accept();
    }

    void navigateToContextMenuPage(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnContextMenuPage();
    }

    @AfterMethod
    void tearDown(){
        Driver.closeDriver();
    }
}
