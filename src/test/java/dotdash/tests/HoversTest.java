package dotdash.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dotdash.pageobjects.HoversPage;
import dotdash.pageobjects.IframePage;
import dotdash.resources.base;

public class HoversTest extends base{

	public WebDriver driver;
	HoversPage hp;
	String avatars[]= new String[5];
	
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("hoversUrl"));
		
	}
	
	
	@Test
	public void validateMouseHover() throws IOException, InterruptedException {	
//			 avatars[0]="firstavatar";
//			 avatars[1]="secondavatar";
//			 avatars[2]="thirdvatar";
//			 hp= new HoversPage(driver);
//			 for(int i=0; i<avatars.length; i++) {
//				 System.out.println(avatars[i]);
//				 hp.hoverAndVerifyCaption(avatars[i]);
//			 }
		
		 hp= new HoversPage(driver);
		 hp.hoverAndVerifyCaption("firstavatar");
		 hp.hoverAndVerifyCaption("secondavatar");
		 hp.hoverAndVerifyCaption("thirdavatar");
			 
			 
			 
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}
	

}
