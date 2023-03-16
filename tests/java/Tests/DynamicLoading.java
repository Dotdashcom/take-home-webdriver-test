package Tests;

import Tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DynamicLoading {
    @BeforeTest
    public void setup(){
    }
    @AfterTest
    public void teardown() {
        Driver.closeDriver();
    }
    @Test
    public void DynamicLoading(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Driver.getDriver().get("http://localhost:7080/dynamic_loading/2");
        Driver.getDriver().findElement(By.xpath("//button[.='Start']")).click();
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().
                findElement(By.xpath("//h4[.='Hello World!']"))));
        assertTrue(Driver.getDriver().findElement(By.xpath("//h4[.='Hello World!']")).
                getText().equals("Hello World!"));
    }
}
