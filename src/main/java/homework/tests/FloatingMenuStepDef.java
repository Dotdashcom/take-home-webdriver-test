package homework.tests;

import homework.pages.FloatingMenuPage;
import homework.test.TestBase;
import homework.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FloatingMenuStepDef extends TestBase {

    FloatingMenuPage floatingMenuPage=new FloatingMenuPage();

    @Test
    public void verifyFloatingMenu(){

        Driver.getDriver().get("http://localhost:7080/floating_menu");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,600)");


        Assert.assertTrue(floatingMenuPage.floatingMenu.isDisplayed());
    }
}
