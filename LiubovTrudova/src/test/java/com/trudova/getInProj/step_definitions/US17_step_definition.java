package com.trudova.getInProj.step_definitions;

import com.trudova.getInProj.pages.NotificationMessagePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class US17_step_definition {
    private NotificationMessagePage notificationMessagePage = new NotificationMessagePage();
    @Given("navigate to Notification Message page")
    public void navigate_to_notification_message_page() {
       notificationMessagePage.notificationMessages.click();

    }

    @Then("click on click here link multiple times,verify message contain")
    public void click_on_click_here_link_multiple_times_verify_message_contain(List<String > expectedDataTable) {
        for (int i = 0; i <20 ; i++) {
            notificationMessagePage.clickHereLink.click();
            String msg = notificationMessagePage.resultMessage.getText();
            msg=msg.replace("×","").trim();
          boolean res= expectedDataTable.contains(msg);
          Assert.assertTrue(res);
        }
    }

}
