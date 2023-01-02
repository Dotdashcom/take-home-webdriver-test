package com.assesment.tests.ui.tests;

import com.assesment.tests.ui.pages.DragAndDropPage;
import com.assesment.tests.ui.pages.DynamicContentPage;
import com.assesment.tests.ui.pages.HomePage;
import com.assesment.tests.ui.utilities.BasePageConf;
import com.assesment.tests.ui.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicContentTestIT extends BasePageConf {

    private static WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = super.navigateToBasePage();
    }

    @Test
    public void verifyColumnACanBeDragedAndDropped(){
        navigateToDynamicContentPage();
        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
        System.err.println(dynamicContentPage.getAllContents());
    }

    /**
     * click on Drag and Drop page on the homepage.
     */
    void navigateToDynamicContentPage(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnDynamicContentPage();
    }

//    @AfterMethod
//    void tearDown(){
//        Driver.closeDriver();
//    }
}
