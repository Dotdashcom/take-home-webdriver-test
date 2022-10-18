package webtests.Testlayers;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webtests.BasePackage.WT_BaseClass;
import webtests.Pageobjects.WT_006_DynamicContent_POM;

public class WT_06_DynamicContent_Test extends WT_BaseClass{

	WT_006_DynamicContent_POM dcontent ;
	
	//Constructor
	public WT_06_DynamicContent_Test() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		dcontent = new 	WT_006_DynamicContent_POM();

		driver.get(pr.getProperty("baseurl")+"/dynamic_content");
		logg.info("****DynamicContent url opened****");
    }
	
	@Test
	public void DynamicContentTest1() throws InterruptedException {
		dcontent.DynamicContent1();
		Thread.sleep(2000);
		
		dcontent.DynamicContent2();
		Thread.sleep(2000);
		dcontent.DynamicContent3();
		
		if (dcontent.DynamicContent1()!= null) {
			Assert.assertNotEquals(dcontent.DynamicContent1(), dcontent.DynamicContent2());
			logg.info("****Test Passed****");
		}
		else if(dcontent.DynamicContent2()!= null) {
			Assert.assertNotEquals(dcontent.DynamicContent2(), dcontent.DynamicContent3());
			logg.info("****Test Passed****");
		}
		else if(dcontent.DynamicContent3()!= null) {
			Assert.assertNotEquals(dcontent.DynamicContent3(), dcontent.DynamicContent1());
			logg.info("****Test Passed****");
		}
		
			
		}}
	
