package com.dotdash.stepDefinitions;

import com.dotdash.pageObjects.DynamicLoadingPOM;
import com.dotdash.testUtils.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DynamicLoadingDef extends TestBase {

	
	
	@Given("User launches the dynamic loading page")
	public void user_launches_the_dynamicloading() {
        TestBase tb= new TestBase();
        String addPath="dynamic_loading/2";
        tb.setupdownload(addPath);
	}
    @When("user click start button")
    public void clickStart() {
    	DynamicLoadingPOM dl= new DynamicLoadingPOM();
    	dl.userclickStart();
    }
    @And("user wait for helloworld text to be displayed")
    public void verifyHelloWord() {
    	DynamicLoadingPOM dl= new DynamicLoadingPOM();
    	dl.userverifyHelloWord();	
    }
    
    @Then("user verify the helloworld text")
    public void verifyhelloWordText() {
    	DynamicLoadingPOM dl= new DynamicLoadingPOM();
    	dl.userverifyhelloWordText();
    }
	
	
	
	
}