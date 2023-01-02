package TestLayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomPackage.Login_Fail;


public class Login_Fail_Test  extends BaseClass {
	Login_Fail Log;
	public Login_Fail_Test() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiation();
		Log=new Login_Fail();
		
	}
	@Test
	public void Login_TC() throws InterruptedException  {
		Log.typeemail(prop.getProperty("username2"));
		Thread.sleep(1000);
		Log.typepassword(prop.getProperty("password2"));
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
