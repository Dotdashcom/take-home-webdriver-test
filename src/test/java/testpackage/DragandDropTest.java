package testpackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.DragandDrop;

public class DragandDropTest extends BaseTest {

	public DragandDropTest() {
		super();
	}
	
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		initiate();
		driver.get(prop.getProperty("draganddropurl"));
		Thread.sleep(1000);
		draganddrop = new DragandDrop();
	}
	
	DragandDrop draganddrop;
	
	@Test
	public void DragtestforA() {
		draganddrop.DragandDropA();
		draganddrop.DragandDropAssertion();
	}
	
	@Test
	public void DragtestforB() {
		draganddrop.DragandDropB();
		draganddrop.DragandDropAssertion();
	}
	
	@AfterMethod
	public void EndSignInTest() {
		quitbrowser();
}
}
