package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class OpenInNewTab extends Base{


    private WebDriver driver;
    private String baseUrl = "http://localhost:7080/windows";
    private WebElement link;


    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();
        driver.get(baseUrl);
        link = driver.findElement(By.xpath("//div[@class='example']/a"));
    }


    @Test
    public void newTabOpen(){

        link.click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        driver.switchTo().window(childWindow);
        String text = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();

        Assert.assertEquals(text,"New Window");

    }






    @AfterMethod
    public void tearDown() {
        driver.quit();
    }







}
