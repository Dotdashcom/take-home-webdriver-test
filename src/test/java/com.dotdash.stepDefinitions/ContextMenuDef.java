package com.dotdash.stepDefinitions;

import com.dotdash.pageObjects.ContextMenuPOM;
import com.dotdash.testUtils.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ContextMenuDef extends TestBase {
	
	@Given("User launches the contextmenu page")
	public void user_launches_the_contextmenu() {
    TestBase tb= new TestBase();
    String addPath="context_menu";
    tb.setupdownload(addPath);
	}
    @When("User clicks on contextmenubox")
    public void clickContextMenu() {
    	ContextMenuPOM cm= new ContextMenuPOM();
    	cm.rightClickCxtBox();
    	
    }
    
    
    @And("User verify the text on the JS Alert")
    public void checkTextOnJSAlret() {
    	ContextMenuPOM cm= new ContextMenuPOM();
    	String contextText=cm.getTextonAlert();	
    	Assert.assertEquals( contextText,prop.getProperty("CxtMenuAlertText"));
    	
    	
    	
    }
}
