package testByGeorgKelava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OpenInNewTab {
    public OpenInNewTab() {
    }

    @BeforeMethod
    public void setUp() {
        Driver.get().get(ConfigurationReader.get("baseUrl") + "windows");
        Driver.get().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }


    @Test
    public void openInNewTab() {
        String currentWindowHandle = Driver.get().getWindowHandle();
        String currentWindowTitle = Driver.get().getTitle();
        System.out.println("currentWindowTitle = " + currentWindowTitle);
        WebElement link = Driver.get().findElement(By.cssSelector("a[href='/windows/new']"));
        link.click();
        Set<String> windowsHandles = Driver.get().getWindowHandles();
        String tabTitle = "";
        Iterator iterator = windowsHandles.iterator();

        while(iterator.hasNext()) {
            String h = (String)iterator.next();
            if (!h.equals(currentWindowHandle)) {
                Driver.get().switchTo().window(h);
                tabTitle = Driver.get().getTitle();
                System.out.println("tabTitle = " + tabTitle);
            }
        }

        Assert.assertNotEquals(currentWindowTitle, tabTitle, "false");
    }
}
