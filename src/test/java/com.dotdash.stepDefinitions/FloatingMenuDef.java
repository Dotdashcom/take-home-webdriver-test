package com.dotdash.stepDefinitions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.dotdash.pageObjects.FloatingMenuPOM;
import com.dotdash.testUtils.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class FloatingMenuDef extends TestBase {

	@Given("User launches the floating menu page")
	public void user_launches_the_floatingmenu() {
        TestBase tb= new TestBase();
        String addPath="floating_menu";
        tb.setupdownload(addPath);	
	}    
	@And("user checks whether the floating menu is visible")
	public void checkFloatingMenu() {
		FloatingMenuPOM fm= new FloatingMenuPOM();
		boolean flag=fm.usercheckFloatingMenu();
		Assert.assertTrue(flag);
	}
	
	@And("user scrolls to the bottom of the page")
	public void scrollToBottom() {
		FloatingMenuPOM fm= new FloatingMenuPOM();
		fm.userscrollToBottom();
		
	}
}
