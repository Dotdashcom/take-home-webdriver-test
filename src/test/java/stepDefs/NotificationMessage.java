package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.Driver;

public class NotificationMessage {
    @Given("I am on the Notification page")
    public void i_am_on_the_Notification_page() {
        Driver.getDriver().get("http://localhost:7080/notification_message_rendered ");
        Driver.getDriver().manage().window().maximize();
    }

    @When("I click on the Click Here link a multiple time and assert the message that has changed")
    public void i_click_on_the_Click_Here_link_a_multiple_time() {
        for (int i = 1;i <=3;i++){
         Driver.getDriver().findElement(By.linkText("Click here")).click();
         System.out.println("Getting the changing message "
        +Driver.getDriver().findElement(By.id("flash-messages")).getText());
        }
    }


}
