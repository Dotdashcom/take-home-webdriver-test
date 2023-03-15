package com.dotdash.stepDefinitions;

import org.testng.Assert;

import com.dotdash.pageObjects.DynamicContentPOM;
import com.dotdash.testUtils.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DynamicContentDef extends TestBase{
    

	String pageSource1,pageSource2;
	
	@Given("User launches the dynamic content page")
	public void user_launches_the_dynamiccontent() {
        TestBase tb= new TestBase();
        String addPath="dynamic_content";
        tb.setupdownload(addPath);	
	}    
    @When("user checks the page content")
    public void checkpageContent() {
    	DynamicContentPOM dc = new DynamicContentPOM();
    	pageSource1=dc.userCheckPageContent();

    }
    
    @And("user refreshes the page")
    public void refreshesPage() {
    	DynamicContentPOM dc = new DynamicContentPOM();
    	dc.userRefreshesPage();	

    }
    
    @Then("user checks the page content after page refresh")
    public void checkPageContentAfterRefresh() {
    	DynamicContentPOM dc = new DynamicContentPOM();
    	pageSource2=dc.usercheckPageContentAfterRefresh();	

    }
    
    @And("user verify that page content has changed after refresh")
    public void checkPageContentChange() {
    	Assert.assertNotEquals(pageSource2, pageSource1);

    }
    
    
}