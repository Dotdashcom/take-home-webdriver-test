package com.dotdash.stepDefinitions;

import com.dotdash.pageObjects.JSAlertsPOM;
import com.dotdash.testUtils.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class JSAlertsDef extends TestBase{

	@Given("User launches the JS alerts page")
	public void user_launches_the_JSalerts() {
        TestBase tb= new TestBase();
      //  tb.setup();
        String addPath="javascript_alerts";
        tb.setupdownload(addPath);
	}    
    @When("User clicks on JS Alert")
    public void switchJSAlerts() {
    	JSAlertsPOM jsa= new JSAlertsPOM();
    	jsa.switchToJSAlert();    	
    }
    
    @Then("User verify JS Alert message")
    public void verifyJSAlertText() {
    	JSAlertsPOM jsa= new JSAlertsPOM();
    	String JSAlert=jsa.JSAlertText();
    	Assert.assertEquals(JSAlert, prop.getProperty("JSAlertText"));   	
    }
    
    @When("User clicks on JS Confirm")
    public void switchJSConfirm() {
    	JSAlertsPOM jsa= new JSAlertsPOM();
    	jsa.switchToJSConfirm(); 
    	
    }
    @Then("User verify JS Confirm message")
    public void verifyJSConfirmText() {
    	JSAlertsPOM jsa= new JSAlertsPOM();
    	String JSConfirm=jsa.JSAlertText();
    	Assert.assertEquals(JSConfirm, prop.getProperty("JSConfirmText"));  
    }
    
    @When("User clicks on JS Prompt")
    public void switchJSPrompt() {
    	JSAlertsPOM jsa= new JSAlertsPOM();
    	jsa.switchToJSPrompt();    	
    }
    @Then("User verify JS Prompt message")
    public void verifyJSPromptText() {
    	JSAlertsPOM jsa= new JSAlertsPOM();
    	String jsText=jsa.JSPromptText();
    	Assert.assertTrue(jsText.contains(prop.getProperty("JSPromptTextVerify")));
    //	Assert.assertEquals(jsText, prop.getProperty("JSPromptTextVerify"));
    	
    } 
    
}
