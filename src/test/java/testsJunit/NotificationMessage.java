package testsJunit;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.Driver;

public class NotificationMessage extends BaseClass {

    //I am on the Notification page
    //I click on the Click Here link a multiple time and assert the message that has changed
    @Test
    public void i_am_on_the_Notification_page() {
        Driver.getDriver().get("http://localhost:7080/notification_message_rendered ");
        Driver.getDriver().manage().window().maximize();
        String[] expected={"Action successful","Action unsuccesful, please try again"};
        for (int i = 1; i <= 2; i++) {
            Driver.getDriver().findElement(By.linkText("Click here")).click();
            String actual =Driver.getDriver().findElement(By.id("flash-messages")).getText();
            Assert.assertNotEquals(expected[i-1],actual);
            System.out.println("Getting the changing message "+ actual);
        }


    }}
