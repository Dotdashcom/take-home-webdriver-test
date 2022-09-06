package pages.Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.Driver;
import pages.CheckBoxes;


public class TC3_CheckBoxes extends Driver {

	@Before
	public void setUp() throws Exception {
		Driver.Initialize();
	}

	@After
	public void tearDown() throws Exception {
		Driver.cleanup();
	}
	
	@Test
	public void EnableCheckbox1() 
	{
		CheckBoxes.NavigateToCheckBoxPage();
		CheckBoxes.EnableCheckbox1();
		Assert.assertTrue(CheckBoxes.IsCheckBox1Selected());
	}
	
	@Test
	public void EnableCheckbox2() 
	{
		CheckBoxes.NavigateToCheckBoxPage();
		CheckBoxes.EnableCheckbox2();
		Assert.assertTrue(CheckBoxes.IsCheckBox2Selected());
	}
	
	@Test
	public void DisableCheckbox1() 
	{
		CheckBoxes.NavigateToCheckBoxPage();
		CheckBoxes.DisableCheckbox1();
		Assert.assertFalse(CheckBoxes.IsCheckBox1Selected());	
	}
	
	@Test
	public void DisableCheckbox2() 
	{
		CheckBoxes.NavigateToCheckBoxPage();
		CheckBoxes.DisableCheckbox2();
		Assert.assertFalse(CheckBoxes.IsCheckBox2Selected());
	}
}
