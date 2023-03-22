package com.QA.testSteps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.QA.BaseUtils.CommonMethods;

import io.cucumber.java.en.Then;

public class stepsNotificationMessage extends CommonMethods {

	public List<String> allMessages = new ArrayList<String>();

	public int countOfMmessage1, countOfMmessage2, countOfMmessage3;
	final String message1 = "Action Successful", 
				 message2 = "Action unsuccessful, please try again",
				 message3 = "Action Unsuccessful";

	@Then("click on the Click Here link {int} times and verify that one of the messages shows on click")
	public void click_on_the_Click_Here_link_times_and_verify_that_one_of_the_messages_shows_on_click(Integer int1) {

		for (int i = 0; i < int1; i++) {

			click(notification.clickHere);			
			
			allMessages.add(notification.flashMessage.getText().split("\n")[0]);

			AA_Hooks.scenario.attach(
					CommonMethods.takeScreenshot("testNotificationMessage/" + AA_Hooks.scenario.getName() + int1),
					"image/png", AA_Hooks.scenario.getName());

		}
		
		Iterator<String> it=allMessages.iterator();
		String actualMessage;
		while (it.hasNext()) {
			actualMessage=it.next();			
			switch (actualMessage) {
			case message1:
				countOfMmessage1++;
				break;
			case message2:
				countOfMmessage2++;
				break;
			case message3:
				countOfMmessage3++;
				break;
			default:
				AA_Hooks.softAssert.fail("The incorrect message displayed: " + actualMessage);
				break;
			}

		}
		
		AA_Hooks.softAssert.assertTrue(countOfMmessage1>0,"Message: "+message1+". Was not displayed");
		AA_Hooks.softAssert.assertTrue(countOfMmessage2>0,"Message: "+message2+". Was not displayed");
		AA_Hooks.softAssert.assertTrue(countOfMmessage3>0,"Message: "+message3+". Was not displayed");

	}

}
