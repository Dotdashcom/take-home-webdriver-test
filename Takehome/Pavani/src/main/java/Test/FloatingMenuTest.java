package Test;

import Utilities.DriverHelper;
import Main.FloatingMenuPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FloatingMenuTest {

    FloatingMenuPage floating = new FloatingMenuPage();

    @Test
    public void FloatTest() throws InterruptedException {

        DriverHelper.getDriver().get("http://localhost:7080/floating_menu");

        DriverHelper.getDriver().manage().window().maximize();

        JavascriptExecutor js=(JavascriptExecutor) DriverHelper.getDriver();

        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1);
            js.executeScript("window.scrollBy(0,750)");

        }

        Assert.assertTrue(floating.floatingMenu.isDisplayed());

    }

}
