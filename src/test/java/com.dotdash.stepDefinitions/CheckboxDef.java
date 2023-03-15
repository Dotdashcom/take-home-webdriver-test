package com.dotdash.stepDefinitions;

import org.openqa.selenium.WebElement;

import com.dotdash.pageObjects.CheckboxPOM;
import com.dotdash.testUtils.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class CheckboxDef extends TestBase {
	Boolean status;
	WebElement checkbox;
	
	@Given("User launches the checkboxpage")
	public void user_launches_the_checkboxpage() {
         TestBase tb= new TestBase();
       //  tb.setup();
         String addPath="checkboxes";
         tb.setupdownload(addPath);	
	}
	@When("User clicks checkbox1")
	public void checksCheckbox() {
		CheckboxPOM cb= new CheckboxPOM();
		checkbox=cb.clicksCheckBox1();
			
	}
	
    @And("User verifys checkbox1 is checked")
    public void verifycheckboxStatus() {
		CheckboxPOM cb= new CheckboxPOM();
		status=cb.verifyCheckBoxIsChecked(checkbox);
		System.out.println(status);	
        Assert.assertTrue(status);    	
    }
    @And("User verifys checkbox1 is unchecked")
    public void CheckBoxUncehcked() {
	CheckboxPOM cb= new CheckboxPOM();
	status=cb.verifyCheckBoxIsChecked(checkbox);
	System.out.println(status);	
	//Assert.assertEquals(status, false);
  
    Assert.assertFalse(status);
	
}
}