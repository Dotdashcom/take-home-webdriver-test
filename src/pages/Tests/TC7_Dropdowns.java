package pages.Tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;
import pages.Driver;
import pages.DropDown;



public class TC7_Dropdowns {

	@Before
	public void setUp() throws Exception {
		Driver.Initialize();
	}


	@Test
	public void SelectDropDownOption1() {
		
		DropDown.NavigateToDropDownPage();
		String value = DropDown.SelectDropDown1();
		Assert.assertTrue(value.contains("Option 1"));
		
	}
	
	@Test
	public void SelectDropDownOption2() {
		
		DropDown.NavigateToDropDownPage();
		String value = DropDown.SelectDropDown2();
		Assert.assertTrue(value.contains("Option 2"));
		
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		Driver.cleanup();
	}

}
