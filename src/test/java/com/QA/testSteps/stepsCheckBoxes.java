package com.QA.testSteps;

import org.openqa.selenium.WebElement;

import com.QA.BaseUtils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class stepsCheckBoxes extends CommonMethods {

	@Given("check all checkboxes")
	public void check_all_checkboxes() {
		for (WebElement chckBox : checkBox.checkboxes) {
			if (!chckBox.isSelected()) {
				jsClick(chckBox);
			}
		}
	}

	@Then("verify all checkboxes are checked")
	public void verify_all_checkboxes_are_checked() {
		  for (WebElement chckBox : checkBox.checkboxes) {
			  AA_Hooks.softAssert.assertTrue(chckBox.isSelected());
			}
	   
	}

	@Given("unchecked all checkboxes")
	public void unchecked_all_checkboxes() {
		for (WebElement chckBox : checkBox.checkboxes) {
			if (chckBox.isSelected()) {
				jsClick(chckBox);
			}
		}
	}

	@Then("verify all checkboxes are unchecked")
	public void verify_all_checkboxes_are_unchecked() {
		for (WebElement chckBox : checkBox.checkboxes) {
			  AA_Hooks.softAssert.assertTrue(!chckBox.isSelected());
			}
	}

}
