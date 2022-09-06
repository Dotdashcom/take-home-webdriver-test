package pages.Tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import pages.Driver;
import pages.DynamicControls;

public class TC4_DynamicControls extends Driver{

	@Before
	public void setUp() throws Exception 
	{
		Driver.Initialize();
	}

	@Test
	public void ValidateACheckBoxIsRemoved() 
	{	
		DynamicControls.NavigateToDynamicControlsPage();
		DynamicControls.ClickremoveButton();
		Assert.assertTrue(DynamicControls.IscheckBoxNotVisible());
			
	}
	
	@Test
	public void ValidateBCheckBoxIsAddedBack() 
	{	
		ValidateACheckBoxIsRemoved();
		DynamicControls.ClickAddButton();
		Assert.assertTrue(DynamicControls.IscheckBoxVisible());	
	}
	
	@Test
	public void ValidateCEnableTextField() 
	{	
		DynamicControls.NavigateToDynamicControlsPage();
		DynamicControls.ClickEnableButton();
		Assert.assertTrue(DynamicControls.IsEnableTextBoxEnabled());	
	}
	
	@Test
	public void ValidateDDisableTextField() 
	{	
		ValidateCEnableTextField();
		DynamicControls.ClickDisableButton();
		Assert.assertFalse(DynamicControls.IsEnableTextBoxEnabled());	
	}
	
	
	@AfterClass
	public static void tearDown() throws Exception 
	{
		Driver.cleanup();
		
	}
	
}
