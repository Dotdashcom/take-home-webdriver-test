package webtests.Testlayers;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import webtests.BasePackage.WT_BaseClass;
import webtests.Pageobjects.WT_001_Loginpage_POM;
import webtests.Testdata.Excelsheet;

public class WT_01_Loginpage_Test extends WT_BaseClass{
	
	WT_001_Loginpage_POM log;
	
	//Constructor
	public WT_01_Loginpage_Test() {
		super();
	}

	@BeforeMethod
	public void initsetup() {
	
	log= new WT_001_Loginpage_POM();
	
	driver.get(pr.getProperty("baseurl")+"/login");
	logg.info("****Login url opened****");
	
    }
	
	@Test(priority= 1)
	public void LoginSucess() throws IOException {
		
		log.typeuserName(pr.getProperty("username"));
		logg.info("****Username Entered****");
		
		log.typePassword(pr.getProperty("password"));
		logg.info("****Password Entered****");
		
		log.clickloginbtn();
		logg.info("****Clicked on login button****");
		
		if (driver.getCurrentUrl().equals(pr.getProperty("baseurl")+"/secure")){
			
			Assert.assertTrue(true);
			logg.info("****Test Passed****");
		}
		else {
			
			Assert.assertTrue(false);
			logg.info("****Test Failed****");
			captureScreen(driver,"LoginSucess");
		}
		log.clicklogoutbtn();
		
}
	@DataProvider
	public Object[][]Parameters(){
		Object result[][]=Excelsheet.readdata("Sheet1");
		return result;
	}
	@Test (priority= 2, dataProvider="Parameters")
	public void LoginFailure(String username, String password) throws InterruptedException, IOException {
		log.typeuserName(username);
		logg.info("****Username Entered****");
		
		log.typePassword(password);
		logg.info("****Password Entered****");
		
		log.clickloginbtn();
		logg.info("****Clicked on login button****");
		
		if(driver.getCurrentUrl().equals(pr.getProperty("baseurl")+"/login")) {
			Assert.assertTrue(true);
			logg.info("****Test Passed****");
		}
		else {
			Assert.assertTrue(false);
			logg.info("****Test Failed****");
			captureScreen(driver,"LoginFailure");
		}
		}
	}

