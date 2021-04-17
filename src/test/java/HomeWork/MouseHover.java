package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class MouseHover extends Base{


    private WebDriver driver;
    private String baseUrl = "http://localhost:7080/hovers";
    private Actions action;
    private  WebDriverWait wait;


    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();
        driver.get(baseUrl);
        action = new Actions(driver);
       wait = new WebDriverWait(driver,5);
    }


    @Test
    public void mouseHover() throws InterruptedException {

       List<WebElement> elements = driver.findElements(By.xpath("//div[@class='figure']/img"));
       List<WebElement> information = driver.findElements(By.xpath("//div[@class='figcaption']/h5"));
        String info="";

       for(int i = 0; i < elements.size(); i++){

           wait.until(ExpectedConditions.visibilityOf(elements.get(i)));
           action.moveToElement(elements.get(i)).build().perform();


           for(int j = 0; j< information.size(); j++){
               info = information.get(j).getText();
           }

       }
        Assert.assertFalse(info.isEmpty());

    }




    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
