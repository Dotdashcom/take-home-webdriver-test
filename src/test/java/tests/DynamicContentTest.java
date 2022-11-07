package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import PageObjects.DynamicContentPage;
import Utility.InternetWebBaseTest;
import junit.framework.Assert;

public class DynamicContentTest extends InternetWebBaseTest{
	@Test
	public void testDynamicContent() throws IOException {
		driver.get(loadProperties().getProperty("BASE_URL")+"dynamic_content");
		DynamicContentPage Dynamicelement=new DynamicContentPage(driver);
		String text1=Dynamicelement.getteext();
		Dynamicelement.clicklink();
		String text2=Dynamicelement.getteext();
		Assert.assertFalse("Test content not changes with page reload.",text1.equals(text2));
		
	}

}
