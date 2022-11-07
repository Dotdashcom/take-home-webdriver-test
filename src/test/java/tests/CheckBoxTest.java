package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.CheckBoxPage;
import Utility.InternetWebBaseTest;
import junit.framework.Assert;

public class CheckBoxTest extends  InternetWebBaseTest{

	@Test()
	public void testCheckBox1Selected() throws IOException, InterruptedException {
 		driver.get(loadProperties().getProperty("BASE_URL")+"checkboxes");
 		Thread.sleep(2000);
		CheckBoxPage checkbox1=new CheckBoxPage(driver);
		Assert.assertTrue("CheckBox1 is not selected",checkbox1.selectCheckBox1());

	}
	
	@Test()
	public void testCheckBox2UnSelected() throws IOException, InterruptedException {
 		driver.get(loadProperties().getProperty("BASE_URL")+"checkboxes");
 		driver.manage().window().maximize();
 		Thread.sleep(2000);
		CheckBoxPage checkbox2=new CheckBoxPage(driver);
		Assert.assertFalse("CheckBox1 is selected",checkbox2.selectCheckBox2());

	}
}
