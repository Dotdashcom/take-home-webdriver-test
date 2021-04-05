package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_012_FloatingMenu extends BaseClass {
    @Test (priority=12) // Test case for floating menu
    public void FloatingMenu() throws InterruptedException {
        //Launching FloatingMenu Url
        driver.get(BaseUrl + "floating_menu");
        //Using Java Script Executor for Window Scrolling
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scrolling window to check Floating Menu display
        js.executeScript("window.scrollBy(0,3000)", "");


        WebElement menu = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[1]/a"));
        System.out.println(menu.isDisplayed());
        System.out.println("Window Scrolled to 3000 Pixels and");
        if (menu.isDisplayed()==true)
        {
            Assert.assertTrue(menu.isDisplayed(), "");
            System.out.println("Floating menu is displaying");
        }
        else
        {
            Assert.assertTrue(false);
            System.out.println("Not Displaying");
        }

        Thread.sleep(3000);
        //After giving wait time scrolling window to check Floating Menu
        js.executeScript("window.scrollBy(3000,5000)", "");
        System.out.println(menu.isDisplayed());
        System.out.println("Window Scrolled to 5000 Pixels and");
        if (menu.isDisplayed() == true)
        {
            Assert.assertTrue(menu.isDisplayed(), "");
            System.out.println("floating menu is Still Displaying");
        }
        else
        {
            Assert.assertTrue(false);
            System.out.println("Menu not Displaying");
        }
    }
}