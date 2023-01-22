package ui_automation.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui_automation.pages.NotificationMsgPage;
import ui_automation.utilities.ConfigurationReder;
import ui_automation.utilities.Driver;

import java.util.concurrent.TimeUnit;

public class NotificationMsg {

    WebDriver driver = Driver.getDriver();
    NotificationMsgPage page = new NotificationMsgPage(driver);

    @Given("user Navigate to notification URL")
    public void user_Navigate_to_notification_URL() {
        String notificationURl = (ConfigurationReder.getProperties("ui-config.properties", "notificationURl"));
        driver.get(notificationURl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



    @When("user click on notification for one time it will receive message {string} or {string}")
    public void user_click_on_notification_for_one_time_it_will_receive_message_or(String expMsg, String expMssg) {
        page.clickHere.click();
        String realMsg = page.realMsg.getText().substring(0, 18);
        System.out.println(realMsg);
        String succ = "Action successful";
        String unsucc = "Action unsuccessful";



        Assert.assertFalse(realMsg.equals(succ) || realMsg.equals(unsucc));

    }


}
