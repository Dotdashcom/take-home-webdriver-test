package webtests.Testlayers;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webtests.BasePackage.WT_BaseClass;
import webtests.Pageobjects.WT_013_MouseHover_POM;

public class WT_13_MouseHover_Test extends WT_BaseClass{

	WT_013_MouseHover_POM mh;
	
	//Constructor
   public WT_13_MouseHover_Test() {
	   super();
   }
   
   @BeforeMethod
	public void initsetup() {
	mh = new   WT_013_MouseHover_POM();
	
	driver.get(pr.getProperty("baseurl")+"/hovers");
   }
   
   @Test(priority = 1)
   public void hoverOnUser1() {
		mh.hoverOnUser1();
		
		Assert.assertTrue(mh.VerifyhoverOnUser1().contains("name: user1"));
		
	}
   
	@Test(priority = 2)
	public void hoverOnUser2(){
		mh.hoverOnUser2();
		Assert.assertTrue(mh.VerifyhoverOnUser2().contains("name: user2"));
	}
	
	@Test(priority = 3)
	public void hoverOnUser3() {
		mh.hoverOnUser3();
		Assert.assertTrue(mh.VerifyhoverOnUser3().contains("name: user3"));

	}
		
   }
   

