package webdrivertest;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NewsTab extends Base {
    WebDriver driver;
    @Test
    public void newsTab(){
        driver = getDriver();

        driver.get("http://localhost:7080/windows");
        String currentTabURL = driver.getCurrentUrl();
        System.out.println("Current Tab URL is : " + currentTabURL);

        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();

        // to open a new tab
        driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL + "t");

        driver.get("http://localhost:7080/windows/new");
        String newTabURL = driver.getCurrentUrl();
        System.out.println("New Tab URL is: " + newTabURL);



    }
}
