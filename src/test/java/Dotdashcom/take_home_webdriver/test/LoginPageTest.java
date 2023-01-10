package Dotdashcom.take_home_webdriver.test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.dotdashcom.takehomewebdrivertest.base.BaseClass;
import Dotdashcom.takehomewebdrivertest.pages.Checkboxes;
import Dotdashcom.takehomewebdrivertest.pages.ContextMenu;
import Dotdashcom.takehomewebdrivertest.pages.LoginPage;


public class LoginPageTest extends BaseClass {
	LoginPage loginPage;
	Checkboxes checkboxes;
	ContextMenu contextmenu;
    

public LoginPageTest(){
	super();
}

@BeforeMethod
public void setUp(){
	initialization();
	loginPage = new LoginPage();	
}



@Test(priority=1)
public void loginsucessTest(){
	String Text1= loginPage.loginsucess(prop.getProperty("username"), prop.getProperty("password"));
	Assert.assertEquals(Text1, "You logged into a secure area!" +"\n"+ "×");
}
@Test(priority=2)
public void loginfailureTest(){
	String Text1= loginPage.loginfailure(prop.getProperty("wrongusername"), prop.getProperty("wrongpassword"));
	Assert.assertEquals(Text1, "Your username is invalid!" +"\n"+ "×");
	
}
	



@AfterMethod
public void tearDown(){
	driver.quit();
}


}
	
	
	


