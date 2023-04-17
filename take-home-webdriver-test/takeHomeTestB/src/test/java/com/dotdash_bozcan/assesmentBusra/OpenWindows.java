package com.dotdash_bozcan.assesmentBusra;
import com.dotdash_bozcan.utilities.ConfigurationReader;
import com.dotdash_bozcan.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OpenWindows {
    @BeforeMethod
    public void setUpMethod() {

        Driver.get().get(ConfigurationReader.get("baseUrl") + "/windows");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);

    }
    //Open in New Tab: Opens in new tab.
    @Test
    public void openInNewTab(){

        String currentWindowHandle = Driver.get().getWindowHandle();
        String currentWindowTitle = Driver.get().getTitle();

        System.out.println("currentWindowTitle = " + currentWindowTitle);

        WebElement link = Driver.get().findElement(By.cssSelector("a[href='/windows/new']"));
        link.click();
        Set<String> windowsHandles = Driver.get().getWindowHandles();

        String tabTitle="";
        for (String h:windowsHandles){
//            System.out.println("h = " + h);
            if (!h.equals(currentWindowHandle)){
                Driver.get().switchTo().window(h);
                tabTitle = Driver.get().getTitle();
                System.out.println("tabTitle = " + tabTitle);
            }

        }
        Assert.assertNotEquals(currentWindowTitle, tabTitle, "false");
    }
}
