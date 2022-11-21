package com.tests.pages;

import com.tests.util.DriverTest;
import com.tests.util.ScreenShotTest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FloatingMenuPage extends BasePage{


     @FindBy(id = "menu")
     private WebElement menuInput;

    @BeforeClass
    public static void setUp(){
        DriverTest.getDriver().get("http://localhost:7080/floating_menu");
    }


    @Test
    public void scrollThePage()throws Exception{
        waitForVisibilityOf(menuInput);
        js.executeScript("window.scrollBy(0,2000)");
        Assert.assertTrue("!!! floating menu is not displayed !!!",menuInput.isDisplayed());
        ScreenShotTest.takeScreenShot("floatingMenu");
    }
}
