package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BaseClass;
import pages.IFramePage;

public class IFrameTestCase extends BaseClass {
	public IFramePage iFramePage;
	public String text1 = "Hello!";
	public IFrameTestCase(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		System.out.println("Before Method");
		initialization("urlIFrame");
		iFramePage = new IFramePage();	
	}
	
	@Test 
	public void iFrame() throws Exception {
		String textData = iFramePage.typeText(text1);
		Assert.assertEquals(textData, text1);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("driver in tear down method");
		driver.close();
	}
}
