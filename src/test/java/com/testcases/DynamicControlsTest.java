package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.base.Base;
import com.pages.DynamicControlsPage;

public class DynamicControlsTest extends Base {
	DynamicControlsPage dcp;
	@BeforeMethod
	public void setUp() {
	initialization();
	driver.findElement(By.linkText("Dynamic Controls")).click();
	dcp= new DynamicControlsPage();

	
	}
	

	@Test
	public void verifyCheckboxGoneOnClickingRemoveBtn() {
		
		dcp.clickOnAddOrRemoveBtn();
		dcp.explicitWaitAfterRemoveButton();

		String checkboxGoneMessage=dcp.getMessageText(); 
		Assert.assertTrue(dcp.messageIsDisplayed());
		if(dcp.messageIsDisplayed()==true) {
			System.out.println("The checkbox "+checkboxGoneMessage+" is displayed");
		}else{
			System.out.println("The checkbox is not removed");
			
		}
	}
	@Test
	public void verifyCheckboxIsBackOnClickingAddBtn() {
		dcp.clickOnAddOrRemoveBtn();
		dcp.explicitWaitAfterRemoveButton();
		dcp.clickOnAddOrRemoveBtn();
		dcp.explicitWaitAfterAddButton();

		String checkboxBackMessage=dcp.getMessageText(); 
		Assert.assertTrue(dcp.messageIsDisplayed());
		if(dcp.messageIsDisplayed()==true) {
			System.out.println("The checkbox "+checkboxBackMessage+" is present");
		}else{
			System.out.println("The checkbox not present");
		}
			
				
		}
		
	@Test
	public void verifyTextFieldIsEnabledOnClickingEnableBtn() {
				
		dcp.clickOnEnableAndDisableBtn();
		dcp.explicitWaitAfterEnableButton();
		dcp.checkTextFieldIsEnabled();
		Assert.assertTrue(dcp.messageIsDisplayed());
		String textFieldEnabledMessage=dcp.getMessageText();
		if(dcp.messageIsDisplayed()==true) {
			System.out.println("The text field enabled "+textFieldEnabledMessage+" is present");
		}else{
			System.out.println("The text field is not enabled");
		}


			}
			
	@Test
	public void verifyTextFieldIsDisabledOnClickingDisableBtn() {
			
		dcp.clickOnEnableAndDisableBtn();
		dcp.explicitWaitAfterEnableButton();
		dcp.clickOnEnableAndDisableBtn();
		dcp.explicitWaitAfterDiableButton();
		dcp.checkTextFieldIsEnabled();
		Assert.assertTrue(dcp.messageIsDisplayed());
		String textFieldDisabledMessage=dcp.getMessageText();
		if(dcp.messageIsDisplayed()==true) {
			System.out.println("The text field disabled "+textFieldDisabledMessage+" is present");
		}else{
			System.out.println("The text field is not disabled");
		}
	}
			
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
