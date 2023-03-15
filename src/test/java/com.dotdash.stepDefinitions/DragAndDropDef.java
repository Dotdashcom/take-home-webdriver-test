package com.dotdash.stepDefinitions;

import java.awt.AWTException;

import com.dotdash.pageObjects.DragAndDropPOM;
import com.dotdash.testUtils.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DragAndDropDef extends TestBase {

	@Given("User launches the drag and drop page")
	public void user_launches_the_draganddrop() {
        TestBase tb= new TestBase();
        String addPath="drag_and_drop";
        tb.setupdownload(addPath);
	}

    @And("User verify text on ElementA and ElementB")
    public void verifyTextBeforeSwitch() {
    	
    }
    @When("User drags ElementA to ElementB")
    public void drgdrp() throws InterruptedException, AWTException {
    	DragAndDropPOM dd = new DragAndDropPOM();
    	dd.drgAndrop();
    	
    	
    	
    }
    @Then("Verify the switched text on ElementA and ElementB")
    public void switchText() {
    	
    }
	
	
}
