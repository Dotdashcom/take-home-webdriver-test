package com.QA.testSteps;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.QA.BaseUtils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class stepsOpenInNewTab extends CommonMethods {

	@Given("click on the Click Here link")
	public void click_on_the_Click_Here_link() {
		click(newTab.clickHereLink);
	}

	@Then("verify that a new tab is opened with text {string}")
	public void verify_that_a_new_tab_is_opened_with_text(String string) {
		
		Assert.assertTrue(driver.getWindowHandles().size() == 2);
		
		switchTo2ndWindow(driver.getWindowHandle());
		
		AA_Hooks.softAssert.assertTrue(driver.findElements(By.xpath("//*[contains(text(),'"+string+"')]")).size()>0);

	}

}
