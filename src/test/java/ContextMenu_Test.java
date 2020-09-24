import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckBoxPage;
import pages.ContextMenuPage;


public class ContextMenu_Test extends BaseTest{
	ContextMenuPage page=null;
	
@Test
public void boxChecked() {
	page=new ContextMenuPage(driver);
	try {
		page.invokeAlert();
		page.verifyAlertText();
	Assert.assertEquals(page.verifyAlertText(), true);	
	}
	catch(Exception e) {
		Assert.assertTrue(false);
		e.getLocalizedMessage();
	}
}



}
