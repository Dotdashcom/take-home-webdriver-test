package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class NotificationMessage extends Base{

    private WebDriver driver;
    private String baseUrl = "http://localhost:7080/notification_message_rendered";
    private WebElement clickHere;


    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();
        driver.get(baseUrl);
        clickHere = driver.findElement(By.xpath("//*[text()='Click here']"));
    }



    @Test
    public void notificationMessage(){


        clickHere.click();
        String notification = driver.findElement(By.id("flash")).getText();


        if(notification.contains("Action unsuccesful")){

            notification = notification.substring(0,notification.indexOf("in")+2).trim();

            Assert.assertEquals(notification,"Action unsuccesful, please try again");

        }else if(notification.contains("Action successful")){

            notification = notification.substring(0,notification.indexOf("ul")+2).trim();

            Assert.assertEquals(notification,"Action successful");
        }


    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



}
