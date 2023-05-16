package homework.tests;

import homework.pages.DynamicLoadigPage;
import homework.test.TestBase;
import homework.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

public class DynamicLoadingStepDef extends TestBase {

    DynamicLoadigPage dynamicLoadigPage=new DynamicLoadigPage();


    @Test
    public void dynamicLoading(){


        Driver.getDriver().get("http://localhost:7080/dynamic_loading/2");

        dynamicLoadigPage.startButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

       String expectedResult="Hello World!";
       String actualResult=dynamicLoadigPage.textMessage.getText();

       Assert.assertEquals(expectedResult,actualResult);
    }
}
