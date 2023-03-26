package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.CommonMethods;
@Test
public class NotificationMessageTest extends CommonMethods {
    public static void main(String[] args){
        setUp("http://localhost:7080/notification_message_rendered");

        for (int i = 0; i<5; i++){ //loop for clicking on the link 5 times
            WebElement clickHereButton = driver.findElement(By.linkText("Click here"));
            clickHereButton.click();
            WebElement message = driver.findElement(By.id("flash"));

            //checking if the notification message is as expected
            if(message.getText().equals("Action successful\n" +
                    "×")) {
                System.out.println("Message 'Action successful' is displayed");
            }else if(message.getText().equals("Action unsuccesful, please try again\n" +
                    "×")){
                System.out.println("Message 'Action unsuccesful, please try again' is displayed");
            }
        }
        tearDown();
    }
}
