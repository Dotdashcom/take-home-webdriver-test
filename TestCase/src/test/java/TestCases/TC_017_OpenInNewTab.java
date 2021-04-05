package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class TC_017_OpenInNewTab extends BaseClass
{
    @Test (priority=17) // Test cae for Open in New Tab
    public void OpenNewWindow() throws InterruptedException
    {
        //Launching OPen New Window Url
        driver.get(BaseUrl+"windows");
        //Inspecting WebElement of 'CliclHere ' link
        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        //Getting WindowHandle values of All opened windows
        Set<String> handlevalues=driver.getWindowHandles();
        for(String h:handlevalues)
        {
            System.out.println(h);
            //Switching driver to new Window
            String title = driver.switchTo().window(h).getTitle();
            //Getting title of new Window
            System.out.println("New WINdow Title:" + title);
            //  driver.switchTo().window(h)
        }

        //Assertion Checking for new Window Title
        Assert.assertTrue(driver.getPageSource().contains("New Window"));

        }
    }


