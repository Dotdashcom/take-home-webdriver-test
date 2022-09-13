package tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Util.TestBase;
import pages.DynamicContentPage;

public class DynamicContentTest extends TestBase {
	
	DynamicContentPage dp=new DynamicContentPage();
	
	@BeforeClass
	public void openBrowser() {
		dp.Initialization();
		dp.landingPage();
	}
	@Test							
	public void RefreshPage1() {
		String Text1= dp.getSecondRowText();
		String Text2=dp.getSecondRowImg();
		dp.refreshPage();					//Refresh the Page First time
		String Text3=dp.getSecondRowText();
		Assert.assertNotEquals(Text1, Text3);//Verify second row text is different after refresh
		String Text4=dp.getSecondRowImg();	
		Assert.assertNotEquals(Text2, Text4);//Verify second row Image is different after refresh

	}
	@Test
	public void RefreshPage2() {

		String Text3= dp.getSecondRowText();
		String Text4=dp.getSecondRowImg();
		driver.navigate().refresh();		//Refresh the Page Again
		String Text5=dp.getSecondRowText();
		Assert.assertNotEquals(Text3, Text5);//Verify second row text is different after refresh
		String Text6=dp.getSecondRowImg();	
		Assert.assertNotEquals(Text4, Text6);//Verify second row Image is different after refresh

	}

	@AfterClass
	public void afterClass() {
		dp.closeBrowser();//Close the Browser
	}
}
