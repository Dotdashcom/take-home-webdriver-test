package webtests.Testlayers;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webtests.BasePackage.WT_BaseClass;
import webtests.Pageobjects.WT_011_FloatingMenu_POM;

public class WT_11_FloatingMenu_Test extends WT_BaseClass {

	 WT_011_FloatingMenu_POM fm;
	
	 //Constructor
	public WT_11_FloatingMenu_Test() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
	
	fm = new  WT_011_FloatingMenu_POM();
	driver.get(pr.getProperty("baseurl")+"/floating_menu");
   }
	
	@Test
	public void FloatingMenuTest() throws InterruptedException {
		
		Boolean a= fm.Menu();
		
		JavascriptExecutor scroll = (JavascriptExecutor)driver;
		
		scroll.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(2000);
		
		Boolean b= fm.Menu();
		
		Assert.assertEquals(a, b);
		
		
	}

}
	
