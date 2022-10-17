package Assignment;

import Utilities.TestBase;
import com.github.javafaker.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoading extends TestBase {

    @Test
    public void dynamicLoadingTest(){


        driver.get(baseUrl + "/dynamic_loading/2 ");

        getWait().until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='start']//button"))));
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='finish']//h4")).getText().equalsIgnoreCase("Hello World!"),"Dynamic Load test FAILED!");


    }
}
