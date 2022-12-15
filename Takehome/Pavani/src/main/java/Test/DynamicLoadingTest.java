package Test;

import Utilities.DriverHelper;
import Main.DynamicLoadingPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingTest {

    DynamicLoadingPage load = new DynamicLoadingPage();

    @Test
    public void checkLoading(){

        DriverHelper.getDriver().get("http://localhost:7080/dynamic_loading/2");

        DriverHelper.getDriver().manage().window().maximize();

        load.startButton.click();

        WebDriverWait wait= new WebDriverWait(DriverHelper.getDriver(),5);

        wait.until(ExpectedConditions.visibilityOf(load.HelloWorld));

        Assert.assertTrue(load.HelloWorld.isDisplayed());

        DriverHelper.closeDriver();

    }

}
