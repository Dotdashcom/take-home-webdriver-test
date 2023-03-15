package com.dotdash.stepDefinitions;

import org.testng.Assert;

import com.dotdash.pageObjects.DropdownPOM;
import com.dotdash.testUtils.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DropdownDef extends TestBase {

	@Given("User launches the dropdown page")
	public void user_launches_the_dropdown() {
        TestBase tb= new TestBase();
        String addPath="dropdown";
        tb.setupdownload(addPath);
	}
    @When("User selects option1")
    public void selectFirstOption() {
    	DropdownPOM dd=new DropdownPOM();
    	dd.selectOption1();   	
    }
    
    @And("User selects option2")
    public void selectSecOption() {
    	DropdownPOM dd=new DropdownPOM();
    	dd.selectOption2();   	
    }
    
    @Then("User verify option1 is selected")
    public void option1Selected() {
    	DropdownPOM dd=new DropdownPOM();
    	boolean status=dd.isOption1Selected();  
    	Assert.assertEquals(status, true);
    }
    
    @Then("User verify option2 is selected")
    public void option2Selected() {
    	DropdownPOM dd=new DropdownPOM();
    	boolean status=dd.isOption2Selected(); 	
    	Assert.assertEquals(status, true);
    }
    
    @Then("User verify option1 is not selected")
    public void option1NotSelected() {
    	DropdownPOM dd=new DropdownPOM();
    	boolean status=dd.isOption1Selected(); 	
    	Assert.assertFalse(status);
    }
    
}
