package testsJunit;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.Driver;

import java.util.Set;


public class OpenNewTab extends BaseClass {
    //I am on the new tab page
    //I click Here link
    //I assert that a new tab is opened with text New Window
    @Test
    public void open_and_verifying_newtab() {
        Driver.getDriver().get("http://localhost:7080/windows");
        Driver.getDriver().manage().window().maximize();
        String parentwidowhandle = Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        Set<String> handels = Driver.getDriver().getWindowHandles();
        for (String windowHandle : handels) {
            if (!windowHandle.equals(parentwidowhandle)) {
                Driver.getDriver().switchTo().window(windowHandle);
            }
        }

        String expected = "New Window";
        String title = Driver.getDriver().getTitle();
        Assert.assertEquals(expected, title);
        System.out.println("The title of a new opened tab is as expected " + title);
    }

}
