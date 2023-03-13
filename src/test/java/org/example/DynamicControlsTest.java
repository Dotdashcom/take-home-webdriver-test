package org.example;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public class DynamicControlsTest extends BasePage{

    protected DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setUp(){
        driver = getDriver();
        dynamicControlsPage = PageFactory.initElements(driver, DynamicControlsPage.class);
    }
    @Test
    public void testToAddOrRemoveButton(){
        dynamicControlsPage.removeOrAddButton();
    }
    @Test
    public void testToEnableOrDisableButton(){
        dynamicControlsPage.enableTextField();
    }

    @AfterMethod
    public void endTest(){
        teardown();
    }

}
