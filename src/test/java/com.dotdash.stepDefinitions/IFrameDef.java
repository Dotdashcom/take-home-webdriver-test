package com.dotdash.stepDefinitions;

import com.dotdash.pageObjects.IFramePOM;
import com.dotdash.testUtils.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class IFrameDef extends TestBase {

	@Given("User launches the iFrame page")
	public void user_launches_the_iFrame() {
        TestBase tb= new TestBase();
        String addPath="iframe";
        tb.setupdownload(addPath);
	}    
    @When("User switch to iframe")
    public void switchToiframe() {
    	IFramePOM ifr= new IFramePOM();
    	ifr.swtIFrame();
    	
    }
    @And("User enters text in iframe")
    public void enterText() {
    	IFramePOM ifr= new IFramePOM();
    	ifr.enterTextIframe();
    	
    }
    
    @Then("User verify the text in the iframe")
    public void verifyText() {
    	IFramePOM ifr= new IFramePOM();
    	String iframeText=ifr.verifyIframeText();    	
    	Assert.assertEquals(iframeText,prop.getProperty("TextOnIframe") );
    	
    	
    }
}
