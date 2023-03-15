package com.dotdash.stepDefinitions;

import com.dotdash.pageObjects.NewTabPOM;
import com.dotdash.testUtils.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class NewTabDef extends TestBase {

	@Given("User launches the newTab page")
    public void user_launches_the_newtab() {
	   TestBase tb= new TestBase();
	   String addPath="windows";
	   tb.setupdownload(addPath);	
    }   
    @When("user clicks on clickhere link")
    public void clickHereLink() {
    	NewTabPOM newtab= new NewTabPOM();
    	newtab.clickLink();
    }
    
    @And("user moves to the new tab")
    public void newTab() {
    	NewTabPOM newtab= new NewTabPOM();
    	newtab.switchNewTab();
    }
    
    @Then("user asserts the text on the new window")
    public void assertNewWindowText() {
    	NewTabPOM newtab= new NewTabPOM();
    	String tabText=newtab.assertText();
    	Assert.assertEquals(tabText, prop.getProperty("newTabText"));
    }

}
