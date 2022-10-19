package testpackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.Dropdown;

public class Dropdowntest extends BaseTest {

	public Dropdowntest() {
		super();
	}
	
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		initiate();
		driver.get(prop.getProperty("dropdownurl"));
		Thread.sleep(1000);
		dropdown = new Dropdown();
	}
	
	Dropdown dropdown;
	
	@Test
	public void option1test(){
		dropdown.Dropdownoption1();
		dropdown.DropdownAssertion();
	}
	
	@Test
	public void option2test() {
		dropdown.Dropdownoption2();
		dropdown.DropdownAssertion();
	}
	
	@AfterMethod
	public void EndSignInTest() {
		quitbrowser();
}
	
}
