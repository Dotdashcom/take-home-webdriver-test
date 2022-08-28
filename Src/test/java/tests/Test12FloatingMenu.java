package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Test12FloatingMenu extends chromedriver {

    @Test
    public void Test12FloatingMenu() throws InterruptedException {
        String url = "http://localhost:7080/floating_menu";
        driver.get(url);

        By floatingMenuXpath = By.xpath("//div[@class='example']/descendant::div[@id='menu']");
        Assert.assertTrue(driver.findElement(floatingMenuXpath).isDisplayed());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        Assert.assertTrue(driver.findElement(floatingMenuXpath).isDisplayed());

    }

}