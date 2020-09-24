package MarionelaTirsina;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OpenInNewTab {
    @Before
    public void setUpMethod() {

        Driver.getDriver().get(ConfigurationReader.getProperty("base") + "/windows");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        Driver.closeDriver();
    }

    //Task: Open in New Tab: http://localhost:7080/windows Test Link Opens in new tab.
    @Test
    public void openInNewTab(){

        String currentWindowHandle = Driver.getDriver().getWindowHandle();
        String currentWindowTitle = Driver.getDriver().getTitle();
//        System.out.println("currentWindowHandle = " + currentWindowHandle);
        System.out.println("currentWindowTitle = " + currentWindowTitle);  //--> The Internet

        WebElement link = Driver.getDriver().findElement(By.cssSelector("a[href='/windows/new']"));
        link.click();
        Set<String> windowsHandles = Driver.getDriver().getWindowHandles();
//        System.out.println("windowsHandles = " + windowsHandles);
        String tabTitle="";
        for (String h:windowsHandles){
//            System.out.println("h = " + h);
            if (!h.equals(currentWindowHandle)){
                Driver.getDriver().switchTo().window(h);
                 tabTitle = Driver.getDriver().getTitle();
                System.out.println("tabTitle = " + tabTitle);  //--> New Window
            }

        }
        Assert.assertNotEquals(currentWindowTitle, tabTitle, "false");
    }
}
