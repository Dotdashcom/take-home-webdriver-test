package com.rtr.steps;

import org.apache.xpath.functions.FuncContains;
import org.junit.Assert;
import static org.hamcrest.Matcher.*;

import java.util.ArrayList;
import java.util.List;

import com.rtr.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class NotificationMessageTestSteps extends CommonMethods {

	@Given("I navigated to Notification Message website")
	public void i_navigated_to_notification_message_website() {
		setUp("/notification_message_rendered");

	}

	@Given("I clicl click here multiable time and assert each text is appear")
	public void i_clicl_click_here_multiable_time_and_assert_each_text_is_appear() {
		for(int i = 0; i<=3;i++) {
		click(notification.clicklink);
		Assert.assertTrue(notification.msg.isDisplayed());

		String text = notification.msg.getText();

		if (text.startsWith("Action successful") || text.startsWith("Action unsuccesful, please try again")
				|| text.startsWith("Action unsuccessful")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed!");
		}
		}

	}

}
