/**
 * 
 */
package com.testing;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author priyanka goswami
 * this is login test file.
 */

public class Login_Test {
	
	Login_Page lp=new Login_Page();
	
	  @BeforeMethod
	  public void setup() throws InterruptedException {
		 lp.setup();
	  }
	
	  @AfterMethod
	  public void tearDown() throws InterruptedException {
		 lp.tearDown();
	  }
	  
	  @Test
	  public void loginSuccess() throws InterruptedException {
		 lp.loginSuccess();
	  }
	  @Test
	  public void loginFailed() throws InterruptedException {
		 lp.loginFailed();
	  }
}


