package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.TestBase;

import java.util.Iterator;
import java.util.Set;

public class NewTabTests extends TestBase {
    String url="windows";

    @Test
    public void newTab() throws InterruptedException {
        Driver.setUp(url);
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(5000);
        String currentWindow=driver.getWindowHandle();
        Set<String> allWindowHandles =driver.getWindowHandles();
        for(String i:allWindowHandles){
            if(!i.equals(currentWindow)){
                driver.switchTo().window(i);
                Assert.assertEquals(driver.getTitle(),"New Window");
            }
        }


    }
}
