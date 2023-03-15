package com.dotdash.stepDefinitions;

import com.dotdash.pageObjects.NotificationMsgPOM;
import com.dotdash.testUtils.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NotificationMsgDef extends TestBase {

	@Given("User launches the notification message page")
	public void user_launches_the_notifictionmsg() {
        TestBase tb= new TestBase();
      //  tb.setup();
        String addPath="notification_message_rendered";
        tb.setupdownload(addPath);	
	}    
    @When("user click on clickhere for Notification Message")
    public void clickHereNoti() {
    	NotificationMsgPOM notimsg= new NotificationMsgPOM();
    	notimsg.userClickhere();
    }
    
    @Then("user validates whether the notification message is expected")
    public void checkNotificationMsg() {
    	NotificationMsgPOM notimsg= new NotificationMsgPOM();
    	notimsg.checkForNotiMsg();
    }
}
