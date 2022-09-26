package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.LoginBaseClass;
import pageClasses.LoginHomePage;

public class UnsuccessfulLogin extends LoginBaseClass {

	@Test
	public void verifyUnsuccessfulLogin() throws InterruptedException {

		LoginHomePage lp = new LoginHomePage(driver);
		lp.enterUsername("Henry");
		lp.enterPassword("Wrong Password");
		lp.clickLgnBtn();
		String act_errmsg = lp.getErrorMsg();
		String exp_errmsg = "Your username is invalid!\n" + "×";

		Assert.assertEquals(act_errmsg, exp_errmsg);
		System.out.println("Unsuccessful login");

	}

}
