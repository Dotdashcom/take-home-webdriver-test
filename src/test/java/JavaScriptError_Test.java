import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckBoxPage;
import pages.DropDownPage;


public class JavaScriptError_Test extends BaseTest{
	DropDownPage page=null;
	
@Test
public void validateOptionOne() {
	page=new DropDownPage(driver);
	try {
	page.selectByVisibleText("Option 1");
	Assert.assertEquals(page.verifyDropDownOption("Option 1"), true);	
	}
	catch(Exception e) {
		Assert.assertTrue(false);
		e.getLocalizedMessage();
	}
}

@Test
public void validateOptionTwo() {
	page=new DropDownPage(driver);
	try {
	page.selectByVisibleText("Option 2");
	Assert.assertEquals(page.verifyDropDownOption("Option 2"), true);	
	}
	catch(Exception e) {
		Assert.assertTrue(false);
		e.getLocalizedMessage();
	}
}
}
