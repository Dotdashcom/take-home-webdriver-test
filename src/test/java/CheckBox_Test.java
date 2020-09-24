import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckBoxPage;


public class CheckBox_Test extends BaseTest{
	CheckBoxPage chkboxPage=null;
	
@Test
public void boxChecked() {
	chkboxPage=new CheckBoxPage(driver);
	try {
		chkboxPage.getCheckBoxURL();
		chkboxPage.clickCheckBoxOne();
	Assert.assertEquals(chkboxPage.isFirstBoxChecked(), true);	
	}
	catch(Exception e) {
		Assert.assertTrue(false);
		e.getLocalizedMessage();
	}
}

@Test
public void boxUnChecked() {
	chkboxPage=new CheckBoxPage(driver);
	try {
		chkboxPage.getCheckBoxURL();
		chkboxPage.clickCheckBoxTwo();
	Assert.assertEquals(chkboxPage.isSecondBoxChecked(), false);	
	}
	catch(Exception e) {
		Assert.assertTrue(false);
		e.getLocalizedMessage();
	}
}
}
