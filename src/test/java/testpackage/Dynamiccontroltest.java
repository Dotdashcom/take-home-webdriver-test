package testpackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.Dynamiccontrol;

public class Dynamiccontroltest extends BaseTest {

	public Dynamiccontroltest() {
		super();
	}
	
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		initiate();
		driver.get(prop.getProperty("dynamiccontrolurl"));
		Thread.sleep(1000);
		dynamiccontrol = new Dynamiccontrol();
	}
	
	Dynamiccontrol dynamiccontrol;
	
	public void Addbuttontest() {
		
	}
	@Test
	public void Removebuttontest() {
		dynamiccontrol.Removebutton();
	}
	@Test
	public void Enablebuttontest() {
		dynamiccontrol.Enable();
		Assert.assertEquals(dynamiccontrol.empty(), true);
	}
	@Test
	public void ACheckboxtest() {
		dynamiccontrol.ACheckbox();
		Assert.assertEquals(dynamiccontrol.Addbutton(), false);
	}
	@Test
	public void emptyelementdisabletest() {
		dynamiccontrol.Disable();
	}
	
	@Test
	public void emptyelementtest() {
		dynamiccontrol.empty();
	}
	
	@AfterMethod
	public void EndSignInTest() {
		quitbrowser();
}
	
}