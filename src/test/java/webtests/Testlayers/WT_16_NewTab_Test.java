package webtests.Testlayers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webtests.BasePackage.WT_BaseClass;
import webtests.Pageobjects.WT_016_NewTab_POM;

public class WT_16_NewTab_Test extends WT_BaseClass {

	WT_016_NewTab_POM tab;
	
	//constructor
	public WT_16_NewTab_Test() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {

	 tab = new WT_016_NewTab_POM();
	 driver.get(pr.getProperty("baseurl")+"/windows");
   }
	
	@Test
	public void NewTabTest() throws IOException {
		tab.ClickHereLink();
		
		List<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(newTab.get(1));
		 logg.info("****Test Switched to new tab****");
		 
		 String text = tab.NewWindowText();
		 System.out.println(text);
		 
		 String title =  driver.getTitle();
		 System.out.println(title);
		
		Assert.assertEquals(title,"New Window"); 
			logg.info("****Test Passed****");
			
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		logg.info("****All Tabs closed****");
	}
		
		}
		
		
	
	

