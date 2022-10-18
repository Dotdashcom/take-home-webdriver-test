package webtests.Testlayers;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webtests.BasePackage.WT_BaseClass;
import webtests.Pageobjects.WT_005_Dropdown_POM;


public class WT_05_Dropdown_Test extends WT_BaseClass {
	WT_005_Dropdown_POM drop;

	//Constructor
	public WT_05_Dropdown_Test() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		
	drop = new WT_005_Dropdown_POM();
	
	driver.get(pr.getProperty("baseurl")+"/dropdown");
	logg.info("****dropdown url opened****");
    }
	
	@Test(priority= 1)
	public void DropDownTest1() throws InterruptedException {
		
    String act= drop.Dropdown1();
    logg.info("****Option 1 is selected****");
    
    Thread.sleep(2000);
    
    String exp= "Option 1";
    Assert.assertEquals(act, exp);
	}
	
	
	@Test(priority= 2)
	public void DropDownTest2() {
		
	String act= drop.Dropdown2();
    logg.info("****Option 2 is selected****");
		 
    Assert.assertEquals(act,"Option 2");
		
	}
}

	
