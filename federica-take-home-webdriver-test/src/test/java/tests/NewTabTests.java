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
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        Thread.sleep(5000);
        String currentWindow=Driver.getDriver().getWindowHandle();
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        for(String i:allWindowHandles){
            if(!i.equals(currentWindow)){
                Driver.getDriver().switchTo().window(i);
                Assert.assertEquals(Driver.getDriver().getTitle(),"New Window");
            }
        }


    }
}
