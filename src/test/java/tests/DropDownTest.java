package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.CheckBoxPage;
import PageObjects.DropDownPage;
import Utility.InternetWebBaseTest;
import junit.framework.Assert;

public class DropDownTest extends InternetWebBaseTest{
	@Test
	public void testdropdownoption1() throws IOException, InterruptedException {
	driver.get(loadProperties().getProperty("BASE_URL")+"dropdown");
	Thread.sleep(2000);
		DropDownPage dropdown1=new DropDownPage(driver);
		dropdown1.selectobject1();
		Assert.assertTrue(DropDownPage.selectObject1.isSelected());
	}
	
	@Test
	public void testdropdownoption2() throws IOException, InterruptedException {
		driver.get(loadProperties().getProperty("BASE_URL")+"dropdown");
		Thread.sleep(2000);
			DropDownPage dropdown1=new DropDownPage(driver);
			dropdown1.selectobject2();
			Assert.assertTrue(DropDownPage.selectObject2.isSelected());
		}
}
