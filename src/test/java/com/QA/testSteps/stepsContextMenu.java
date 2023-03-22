package com.QA.testSteps;

import com.QA.BaseUtils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class stepsContextMenu extends CommonMethods {

	@Given("right click on the context menu")
	public void right_click_on_the_context_menu() {
		getActionsObj().contextClick(contextMenu.hotSpotBox).perform();
	}

	@Then("verify the alert menu text")
	public void verify_the_alert_menu_text() {
		AA_Hooks.softAssert.assertTrue(isAlertPresent(), "Alert message is not present");
		if (getAlertText().equals("You selected a context menu")) {
			AA_Hooks.scenario.attach(CommonMethods.takeScreenshotRobot("passed/" + AA_Hooks.scenario.getName()),
					"image/png", AA_Hooks.scenario.getName());
		} else {
			AA_Hooks.scenario.attach(CommonMethods.takeScreenshotRobot("failed/" + AA_Hooks.scenario.getName()),
					"image/png", AA_Hooks.scenario.getName());
		}
		acceptAlert();
	}

}
