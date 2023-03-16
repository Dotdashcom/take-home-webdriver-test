package Tests;

import Tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class OpenInNewTab {
    @BeforeTest
    public void setup(){
    }
    @AfterTest
    public void teardown() {
        Driver.closeDriver();
    }
    @Test
    public void OpenInNewTab() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        Driver.getDriver().get("http://localhost:7080/windows");
        String mainWindow = Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.xpath("//a[.='Click Here']")).click();
        Set<String> windows = Driver.getDriver().getWindowHandles();
        for (String windowHandle : windows) {
            if (!windowHandle.equals(mainWindow)) {
                Driver.getDriver().switchTo().window(windowHandle);
            }
        }
        assertTrue(Driver.getDriver().getTitle().equals("New Window"));
    }
}
