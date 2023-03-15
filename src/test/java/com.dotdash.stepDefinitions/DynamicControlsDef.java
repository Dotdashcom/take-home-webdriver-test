package com.dotdash.stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import com.dotdash.pageObjects.DynamicControlsPOM;
import com.dotdash.testUtils.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DynamicControlsDef extends TestBase {

	@Given("User launches the dynamic controls page")
	public void user_launches_the_dynamiccontrols() {
        TestBase tb= new TestBase();
        String addPath="dynamic_controls";
        tb.setupdownload(addPath);	
	}
	@When("user clicks on the RemoveButton")
	public void clickRemoveButton() {
		DynamicControlsPOM dc= new DynamicControlsPOM();
		dc.userclickRemoveButton();		
	}
	
    @Then("Verify that the checkbox is gone.")
    	public void checkboxnotfound() {
    		DynamicControlsPOM dc= new DynamicControlsPOM();
    		boolean eleNotPresent=dc.usercheckboxnotfound();
    		Assert.assertTrue(eleNotPresent);
    	}
    @When("user clicks on AddButton")
    public void clickAddButton() {
		DynamicControlsPOM dc= new DynamicControlsPOM();
		dc.userclickAddButton();	
    }
    @Then("Verify that the checkbox is present")
    public void checkboxPresent() {
		DynamicControlsPOM dc= new DynamicControlsPOM();
		boolean elepresent=dc.usercheckboxPresent();
		Assert.assertTrue(elepresent);
    }
    @When("user clicks on the EnableButton")
    public void clickEnableButton() {
		DynamicControlsPOM dc= new DynamicControlsPOM();
		dc.userclickEnableButton();	
    }
    @Then("Verify that the text box is enabled")
    public void checkTextBoxEnabled() {
		DynamicControlsPOM dc= new DynamicControlsPOM();
		boolean eleEnabled=dc.usercheckTextBoxEnabled();
		Assert.assertTrue(eleEnabled);
    }
    @When("user clicks on the DisableButton")
    public void clickDisableButton() {
		DynamicControlsPOM dc= new DynamicControlsPOM();
		dc.userclickDisableButton();	
    }
    @Then("Verify that the text box is disabled")
    public void textBoxDisabled() {
		DynamicControlsPOM dc= new DynamicControlsPOM();
		boolean eleEnabled=dc.usertextBoxDisabled();
		Assert.assertFalse(eleEnabled);
    }
    }

