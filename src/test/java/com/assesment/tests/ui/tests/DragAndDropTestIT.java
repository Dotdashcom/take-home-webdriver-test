package com.assesment.tests.ui.tests;

import com.assesment.tests.ui.pages.DragAndDropPage;
import com.assesment.tests.ui.pages.HomePage;
import com.assesment.tests.ui.utilities.BasePageConf;
import com.assesment.tests.ui.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTestIT extends BasePageConf {

    private static WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = super.navigateToBasePage();
    }

    @Test
    public void verifyColumnACanBeDragedAndDropped(){
        navigateToDragAndDropPage();
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.dragAndDrop();
    }

    /**
     * click on Drag and Drop page on the homepage.
     */
    void navigateToDragAndDropPage(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnDragAndDropPage();
    }

    @AfterMethod
    void tearDown(){
        Driver.closeDriver();
    }
}
