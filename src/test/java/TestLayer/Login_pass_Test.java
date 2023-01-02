package TestLayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomPackage.Login_pass;


public class Login_pass_Test extends BaseClass {
	Login_pass Log;
	public Login_pass_Test() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiation();
		Log=new Login_pass();
		
	}
	@Test
	public void Login_TC() throws InterruptedException  {
		Log.typeemail(prop.getProperty("username"));
		Thread.sleep(1000);
		Log.typepassword(prop.getProperty("password"));
		Thread.sleep(1000);
		Log.clickbtn();
		Thread.sleep(3000);
		Log.logoutbtn();
		
		
		
	}
	@AfterMethod
	public void close() {
		driver.close();
	}

}
