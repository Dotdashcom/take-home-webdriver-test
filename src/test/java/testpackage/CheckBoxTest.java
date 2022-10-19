package testpackage;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.CheckBox;

public class CheckBoxTest extends BaseTest {

	public CheckBoxTest() {
		super();
	}
	
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		initiate();
		driver.get(prop.getProperty("checkboxurl"));
		Thread.sleep(1000);
		checkbox = new CheckBox();
		}
	
	CheckBox checkbox;
	
	@Test
	public void UncheckedCheckBoxtest() {
		driver.manage().timeouts().pageLoadTimeout(EXPLICIT_WAIT, TimeUnit.MILLISECONDS);
		checkbox.UncheckedCheckBox();
		checkbox.AssertionCheckBox();
	}
	@Test
	public void CheckedCheckBoxtest() {
		driver.manage().timeouts().pageLoadTimeout(EXPLICIT_WAIT, TimeUnit.MILLISECONDS);
		checkbox.CheckedCheckBox();
		checkbox.AssertionCheckBox();
	}
	
	@AfterMethod
	public void EndSignInTest() {
		quitbrowser();
}
}