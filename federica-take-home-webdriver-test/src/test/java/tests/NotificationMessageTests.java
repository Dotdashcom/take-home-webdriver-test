package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.TestBase;

public class NotificationMessageTests extends TestBase {
    String url="notification_message_rendered";

    @Test
    public void notifications() throws InterruptedException {
        Driver.setUp(url);
        WebElement clickHere=Driver.getDriver().findElement(By.xpath("//p/a"));
        try {
            for (int i=0; i<6; i++){
                clickHere.click();
                WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
                wait.until(ExpectedConditions.visibilityOf(clickHere));
                WebElement message=Driver.getDriver().findElement(By.id("flash"));
                Assert.assertTrue(message.getText().contains("Action Successful")||
                        message.getText().contains("Action unsuccessful, please try again")||
                        message.getText().contains("Action Unsuccessful"));
            }
        }catch (StaleElementReferenceException e){
            e.printStackTrace();
        }
    }
}
